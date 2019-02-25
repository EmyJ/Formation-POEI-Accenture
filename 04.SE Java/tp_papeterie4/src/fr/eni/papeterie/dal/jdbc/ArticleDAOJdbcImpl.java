/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String TYPE_STYLO = "Stylo";
	private static final String TYPE_RAMETTE = "Ramette";
	
	private static final String SQL_DELETE = "DELETE FROM Articles WHERE idArticle =?";
	private static final String SQL_INSERT = "INSERT INTO Articles (reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type)"
												+ " VALUES (?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM Articles WHERE idArticle =?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM Articles";
	private static final String SQL_UPDATE = "UPDATE Articles set reference=?,marque=?,designation=?,prixUnitaire=?,"
											+ "qteStock=?,grammage=?,couleur=?,type=? Where idArticle=? ";

	/************************************************INSERT*************************************************************************/
	public void insert(Article a1) throws DALException {
		
		try (Connection connect = JdbcTools.getConnection();
			PreparedStatement pr = connect.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				){
			pr.setString(1, a1.getReference());
			pr.setString(2, a1.getMarque());
			pr.setString(3, a1.getDesignation());
			pr.setFloat(4, a1.getPrixUnitaire());
			pr.setInt(5, a1.getQteStock());
			if (a1 instanceof Ramette) {
				Ramette r = (Ramette) a1;
				pr.setInt(6, r.getGrammage());
				pr.setNull(7, Types.VARCHAR);
				pr.setString(8, TYPE_RAMETTE);
			}
			if (a1 instanceof Stylo) {
				Stylo s = (Stylo) a1;
				pr.setNull(6, Types.INTEGER);
				pr.setString(7, s.getCouleur());
				pr.setString(8, TYPE_STYLO);
			}
			int nbLigne = pr.executeUpdate();
			if (nbLigne == 1) {
				ResultSet rs = pr.getGeneratedKeys();
				if (rs.next()) {
					a1.setIdArticle(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException("Insertion Echouée", e);
		}
	}

	/************************************************SELECTBYID*************************************************************************/
	public Article selectById(int idArticle) throws DALException {
		
		Article article = null;

		try (Connection connect = JdbcTools.getConnection();
			PreparedStatement pr = connect.prepareStatement(SQL_SELECT_BY_ID);
				){
	        pr.setInt(1, idArticle);
	        ResultSet rs = pr.executeQuery();
	        if(rs.next()) {
	        	if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

					article = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					article = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
				}
	        }
		} catch (Exception e) {
			throw new DALException("Selection Echouée", e);
		}
		return article;
	}

	/************************************************SELECTAll*************************************************************************/
	public List<Article> selectAll() throws DALException {
		
		List<Article> liste = new ArrayList<>();
		Article article = null;

		try (Connection connect = JdbcTools.getConnection();
			Statement stmt = connect.createStatement();
				){
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {
					article = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					article = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
				}
	        	liste.add(article);
			}
		} catch (SQLException e) {
			throw new DALException("Selection Echouée", e);
		} 
		return liste;
	}
	
/************************************************UPDATE*************************************************************************/
	public void update(Article a1) throws DALException {
		
		try (Connection connect = JdbcTools.getConnection();
			PreparedStatement pr = connect.prepareStatement(SQL_UPDATE,Statement.RETURN_GENERATED_KEYS);
				){
			pr.setString(1, a1.getReference());
			pr.setString(2, a1.getMarque());
			pr.setString(3, a1.getDesignation());
			pr.setFloat(4, a1.getPrixUnitaire());
			pr.setInt(5, a1.getQteStock());
			if (a1 instanceof Ramette) {
				Ramette r = (Ramette) a1;
				pr.setInt(6, r.getGrammage());
				pr.setNull(7, Types.VARCHAR);
				pr.setString(8, TYPE_RAMETTE);
			}
			if (a1 instanceof Stylo) {
				Stylo s = (Stylo) a1;
				pr.setNull(6, Types.INTEGER);
				pr.setString(7, s.getCouleur());
				pr.setString(8, TYPE_STYLO);
			}
			pr.setInt(9, a1.getIdArticle());
			pr.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Modification Echouée", e);
		} 
	}

	/************************************************DELETE*************************************************************************/
	public void delete(int idArticle) throws DALException {
		
		try (Connection connect = JdbcTools.getConnection();
			PreparedStatement pr = connect.prepareStatement(SQL_DELETE);
				){
	        pr.setInt(1, idArticle);
	        pr.executeUpdate();

		} catch (Exception e) {
			throw new DALException("Suppression Echouée", e);
		}
	}
}
