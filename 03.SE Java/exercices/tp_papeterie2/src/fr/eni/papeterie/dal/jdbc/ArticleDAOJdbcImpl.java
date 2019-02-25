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
import fr.eni.papeterie.dal.DALException;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl {

	/************************************************insert*************************************************************************/
	public void insert(Article a1) throws DALException {
		Connection connect = connect();
		PreparedStatement pr = null;
		try {
			String sql = "INSERT INTO Articles (reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type) VALUES (?,?,?,?,?,?,?,?)";
			pr = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pr.setString(1, a1.getReference());
			pr.setString(2, a1.getMarque());
			pr.setString(3, a1.getDesignation());
			pr.setFloat(4, a1.getPrixUnitaire());
			pr.setInt(5, a1.getQteStock());
			if (a1 instanceof Ramette) {
				pr.setInt(6, ((Ramette) a1).getGrammage());
			} else {
				pr.setNull(6, Types.INTEGER);
			}
			if (a1 instanceof Stylo) {
				pr.setString(7, ((Stylo) a1).getCouleur());
			} else {
				pr.setNull(7, Types.NVARCHAR);
			}
			if (a1 instanceof Ramette) {
				pr.setString(8, ((Ramette) a1).getClass().getSimpleName());
			} else if (a1 instanceof Stylo) {
				pr.setString(8, ((Stylo) a1).getClass().getSimpleName());
			}

			int nbLigne = pr.executeUpdate();
			
			if (nbLigne == 1) {
				ResultSet rs = pr.getGeneratedKeys();
				if (rs.next()) {
					a1.setIdArticle(rs.getInt(1));
				}
			}
			
			if (nbLigne > 0) {
				System.out.println("Insertion réussie");
			} else {
				System.out.println("Aucunes Insertion");
			}

		} catch (Exception e) {
			throw new DALException("Insertion Echouée", e);
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (connect != null) {
					connect.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}

	}

	/************************************************selectById*************************************************************************/
	public Article selectById(Integer idArticle) throws DALException {
		Connection connect = connect();
		PreparedStatement pr = null;
		Article article = null;

		try {
			String sql = "SELECT * FROM Articles WHERE idArticle =?";
			pr = connect.prepareStatement(sql);
	        pr.setInt(1, idArticle);
	        ResultSet rs = pr.executeQuery();
	        
	        while(rs.next()) {
	        	if (rs.getString("Type").trim().equals("Ramette")) {
	        		article = new Ramette();
						article.setIdArticle(rs.getInt(1));
						article.setReference(rs.getString("reference"));
						article.setMarque(rs.getString("marque"));
						article.setDesignation(rs.getString("designation"));
						article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
						article.setQteStock(rs.getInt("qteStock"));
						if (article instanceof Ramette) {
							((Ramette) article).setGrammage(rs.getInt("grammage"));
						}
					
				} else if (rs.getString("Type").trim().equals("Stylo")) {
					article = new Stylo();
						article.setIdArticle(rs.getInt(1));
						article.setReference(rs.getString("reference"));
						article.setMarque(rs.getString("marque"));
						article.setDesignation(rs.getString("designation"));
						article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
						article.setQteStock(rs.getInt("qteStock"));
						if (article instanceof Stylo) {
							((Stylo) article).setCouleur(rs.getString("couleur"));
						}
				}
	          
	        }

		} catch (Exception e) {
			throw new DALException("Selection Echouée", e);
		}finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (connect != null) {
					connect.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}
		return article;
	}

	/************************************************selectAll*************************************************************************/
	public List<Article> selectAll() throws DALException {
		Connection connect = connect();
		Statement stmt = null;
		List<Article> liste = new ArrayList<>();
		Article article = null;

		try {
			// Création de la requete de selection
			stmt = connect.createStatement();
			String sql = "SELECT * FROM Articles";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
	        	if (rs.getString("Type").trim().equals("Ramette")) {
	        		article = new Ramette();
						article.setIdArticle(rs.getInt(1));
						article.setReference(rs.getString("reference"));
						article.setMarque(rs.getString("marque"));
						article.setDesignation(rs.getString("designation"));
						article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
						article.setQteStock(rs.getInt("qteStock"));
						if (article instanceof Ramette) {
							((Ramette) article).setGrammage(rs.getInt("grammage"));
						}
					
				} else if (rs.getString("Type").trim().equals("Stylo")) {
					article = new Stylo();
						article.setIdArticle(rs.getInt(1));
						article.setReference(rs.getString("reference"));
						article.setMarque(rs.getString("marque"));
						article.setDesignation(rs.getString("designation"));
						article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
						article.setQteStock(rs.getInt("qteStock"));
						if (article instanceof Stylo) {
							((Stylo) article).setCouleur(rs.getString("couleur"));
						}
				}
	        	liste.add(article);

			}
			// affiche les articles
			for (Article a : liste) {
				System.out.println(a);
			}

		} catch (SQLException e) {
			throw new DALException("Selection Echouée", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}

		}
		return liste;
	}
	
/************************************************UPDATE*************************************************************************/
	public void update(Article a1) throws DALException {
		Connection connect = connect();
		PreparedStatement pr = null;

		try {
			String sql = "UPDATE Articles set reference=?, marque=?,  designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=? Where idArticle=? ";
			pr = connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pr.setString(1, a1.getReference());
			pr.setString(2, a1.getMarque());
			pr.setString(3, a1.getDesignation());
			pr.setFloat(4, a1.getPrixUnitaire());
			pr.setInt(5, a1.getQteStock());
			if (a1 instanceof Ramette) {
				pr.setInt(6, ((Ramette) a1).getGrammage());
			} else {
				pr.setNull(6, Types.INTEGER);
			}
			if (a1 instanceof Stylo) {
				pr.setString(7, ((Stylo) a1).getCouleur());
			} else {
				pr.setNull(7, Types.NVARCHAR);
			}
			if (a1 instanceof Ramette) {
				pr.setString(8, ((Ramette) a1).getClass().getSimpleName());
			} else if (a1 instanceof Stylo) {
				pr.setString(8, ((Stylo) a1).getClass().getSimpleName());
			}
			
			pr.setInt(9, a1.getIdArticle());
			
			int nbLigne = pr.executeUpdate();
			
			if (nbLigne == 1) {
				ResultSet rs = pr.getGeneratedKeys();
				if (rs.next()) {
					a1.setIdArticle(rs.getInt(1));
				}
			}
			
			if (nbLigne > 0) {
				System.out.println("Modification réussie");
			}

		} catch (SQLException e) {
			throw new DALException("Modification Echouée", e);
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (connect != null) {
					connect.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}
	}

	/************************************************delete*************************************************************************/
	public void delete(Integer idArticle) throws DALException {
		Connection connect = connect();

	}

	/************************************************connect*************************************************************************/
	public Connection connect() throws DALException {
		Connection con = null;
		try {
			con = JdbcTools.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur Impossible de se connecter à la BDD");
			// } finally {
			// if (con != null) {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// e.printStackTrace();
			// }
			// }
		}
		return con;
	}

}
