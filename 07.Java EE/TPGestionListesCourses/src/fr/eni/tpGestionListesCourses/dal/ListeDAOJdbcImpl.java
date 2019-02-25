/**
 * 
 */
package fr.eni.tpGestionListesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bo.Article;
import fr.eni.tpGestionListesCourses.bo.Liste;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 4 févr. 2019 - 17:03:52
 */
public class ListeDAOJdbcImpl implements ListeDAO {

    private static final String INSERT_LISTE = "INSERT INTO liste(nom) VALUES(?)";
    private static final String INSERT_ARTICLE = "INSERT INTO article(nomArticle, idListe) VALUES(?,?)";
    private static final String SELECT_ALL = "SELECT idliste, nom FROM liste";
    private static final String SELECT_ID = "SELECT l.idListe as idliste,l.nom, a.idArticle as idArticle , "+
	    					"a.nomArticle as nomArticle FROM liste l " + 
	    					"LEFT JOIN article a on l.idListe = a.idListe " + 
	    					"WHERE l.idListe=?";
    private static final String DELETE_LISTE = "DELETE FROM liste WHERE idListe = ? ";
    
    /**
     * {@inheritDoc}
     * 
     * @see fr.eni.tpGestionListesCourses.dal.ListeDAO#insert(fr.eni.tpGestionListesCourses.bo.Liste)
     */
    @Override
    public void insert(Liste liste) throws BusinessException {
	if (liste == null) {
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
	    throw businessException;
	}

	try (Connection cnx = ConnectionProvider.getConnection()) {
	    try {
		cnx.setAutoCommit(false);
		PreparedStatement stmt = cnx.prepareStatement(INSERT_LISTE, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, liste.getNom());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
		    liste.setIdentifiant(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		stmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
		for (Article article : liste.getArticles()) {
		    stmt.setString(1, article.getNom());
		    stmt.setInt(2, liste.getIdentifiant());
		    stmt.executeUpdate();
		    rs = stmt.getGeneratedKeys();
		    if (rs.next()) {
			article.setIdentifiant(rs.getInt(1));
		    }
		    rs.close();
		}
		stmt.close();
		cnx.commit();
	    } catch (Exception e) {
		e.printStackTrace();
		cnx.rollback();
		throw e;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
	    throw businessException;
	}

    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.eni.tpGestionListesCourses.dal.ListeDAO#select()
     */
    @Override
    public List<Liste> select() throws BusinessException {
	List<Liste> listeListe = new ArrayList<>();
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
	    ResultSet rs = pstmt.executeQuery();
	    Liste ListeCourant = new Liste();
	    while (rs.next()) {
		ListeCourant = listeBuilder(rs);
		listeListe.add(ListeCourant);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
	    throw businessException;
	}
	return listeListe;
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.eni.tpGestionListesCourses.dal.ListeDAO#select(java.lang.String)
     */
    @Override
    public List<Liste> selectId(int id) throws BusinessException {
	List<Liste> listeListe = new ArrayList<>();
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_ID);
	    pstmt.setInt(1, id);
	    ResultSet rs = pstmt.executeQuery();
	    Liste listeCourant = new Liste();
	    while (rs.next()) {
		if (rs.getInt("idListe") != listeCourant.getIdentifiant()) {
		    listeCourant = listeBuilder(rs);
		    listeListe.add(listeCourant);
		}
		Article article = articleBuilder(rs);
		listeCourant.getArticles().add(article);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
	    throw businessException;
	}
	return listeListe;
    }
    /** 
     * {@inheritDoc}
     * @see fr.eni.tpGestionListesCourses.dal.ListeDAO#delete(int)
     */
    @Override
    public void delete(int id) throws BusinessException {
	if (id == 0) {
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
	    throw businessException;
	}
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement stmt = cnx.prepareStatement(DELETE_LISTE);
	    stmt.setInt(1, id);
	    stmt.executeUpdate();
	    stmt.close();
	} catch (Exception e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException();
	    businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
	    throw businessException;
	}
	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see fr.eni.tpGestionListesCourses.dal.ListeDAO#update(fr.eni.tpGestionListesCourses.bo.Liste)
     */
    @Override
    public void update(Liste liste) throws BusinessException {
	// TODO Auto-generated method stub

    }

    private Article articleBuilder(ResultSet rs) throws SQLException {
	Article article = new Article(rs.getInt("idArticle"), rs.getString("nomArticle"));
	return article;
    }

    private Liste listeBuilder(ResultSet rs) throws SQLException {
	Liste ListeCourant;
	ListeCourant = new Liste();
	ListeCourant.setIdentifiant(rs.getInt("idListe"));
	ListeCourant.setNom(rs.getString("nom"));
	return ListeCourant;
    }
}
