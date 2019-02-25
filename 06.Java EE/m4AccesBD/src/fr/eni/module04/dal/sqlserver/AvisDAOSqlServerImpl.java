package fr.eni.module04.dal.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.module04.bo.Avis;
import fr.eni.module04.dal.AvisDAO;
import fr.eni.module04.dal.ConnectionProvider;
import fr.eni.module04.dal.DALException;

public class AvisDAOSqlServerImpl implements AvisDAO{
	
	private static final String INSERT = "insert into AVIS(description, note) values (?, ?)";
	
	//Ajouter un avis en base de données
	public void insert(Avis avis) throws DALException {
		Connection conn = null;
		try {
			//Récupérer une connexion
			conn = ConnectionProvider.getConnection();

			//Préparer la requete
			PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, avis.getDescription());
			stmt.setInt(2, avis.getNote());
			
			//Executer la requete
			stmt.executeUpdate();
			
			//Recupérer l'identifiant créé
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				avis.setIdentifiant(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException("Erreur insert", e);
		}finally {
			//Fermer la connexion
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	

}
