package fr.eni.TPSuiviDesRepas.dal.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.TPSuiviDesRepas.bo.Aliment;
import fr.eni.TPSuiviDesRepas.bo.Repas;
import fr.eni.TPSuiviDesRepas.dal.ConnectionProvider;
import fr.eni.TPSuiviDesRepas.dal.DALException;
import fr.eni.TPSuiviDesRepas.dal.RepasDAO;

public class RepasDAOSqlServerImpl implements RepasDAO{

	private static final String INSERT = "insert into REPAS(date_repas) values (?)";
	private static final String INSERT_A = "insert into ALIMENT(aliment, idRepas) values (?,?)";
	private static final String SELECT = "SELECT * FROM REPAS left join ALIMENT on REPAS.idRepas = ALIMENT.idRepas order by REPAS.idRepas desc";
	
	@Override
	public void insert(Repas repas) throws DALException {
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				
				//Préparer la requete repas
				PreparedStatement stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setTimestamp(1, new Timestamp(repas.getDate().getTime()) );
				stmt.executeUpdate();	
				ResultSet rs = stmt.getGeneratedKeys();
					if (rs.next()) {
						repas.setIdRepas(rs.getInt(1));
					}
				rs.close();
				stmt.close();
				
				PreparedStatement stmt1 = conn.prepareStatement(INSERT_A, PreparedStatement.RETURN_GENERATED_KEYS);
				for (Aliment aliment : repas.getAliments()) {	
					stmt1.setString(1, aliment.getNom() );
					stmt1.setInt(2, repas.getIdRepas());
					
					stmt1.executeUpdate();
					
					ResultSet rs1 = stmt1.getGeneratedKeys();
					if(rs1.next()) {
						aliment.setIdAliment(rs1.getInt(1));
					}
					rs1.close();	
				}
				stmt1.close();
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
				throw e;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur insert", e);
		}
		
	}

	@Override
	public List<Repas> selectAll() throws DALException {
		List <Repas> liste = new ArrayList<>();
		//Récupèrer une connexion
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			PreparedStatement st = conn.prepareStatement(SELECT);
			ResultSet rs = st.executeQuery();
			Repas repasCourant = new Repas();
			while(rs.next()) {
				if(rs.getInt("IdRepas") != repasCourant.getIdRepas()) {
					repasCourant = repasBuilder(rs);
					liste.add(repasCourant);
				}
				Aliment aliment = new Aliment();
				aliment.setNom(rs.getString("aliment"));
				repasCourant.getAliments().add(aliment);
				
			}
		} catch (SQLException e) {
			throw new DALException("Selection Echouée", e);
		}
		return liste;
	}
	
	private Repas repasBuilder(ResultSet rs) throws SQLException {
		Repas repasCourant;
		repasCourant=new Repas();
		repasCourant.setIdRepas(rs.getInt("idRepas"));
		repasCourant.setDate(new Date(rs.getTimestamp("date_repas").getTime()));
		return repasCourant;
	}
}
