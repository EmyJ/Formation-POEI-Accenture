/**
 * 
 */
package fr.eni.fighters.dal.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.dal.CarteDAO;
import fr.eni.fighters.dal.CodesResultatDAL;
import fr.eni.fighters.dal.ConnectionProvider;

/**
 * Classe en charge de faire les requetes SQL avec la BDD pour la TABLE CARTE
 * 
 * @author ejezeque2018
 * @version DigiFighters - V1.0
 * @date 12 févr. 2019 - 15:39:18
 */
public class CarteDAOsqlServerImpl implements CarteDAO {

    private static final String UPDATE_COCHE_CARTE = "UPDATE CARTE SET coche = 1 WHERE id = ?";
    private static final String UPDATE_DECOCHE_CARTE = "UPDATE CARTE SET coche = 0 WHERE id = ?";
    private static final String UPDATE_DECOCHE_CARTES = "UPDATE CARTE SET coche = 0 WHERE id_user = ?";
    private static final String SELECT_ALL = "SELECT id, cout, force, coche FROM CARTE WHERE id_user = ?";
    private static final String SELECT_COUNT_COCHE_CARTE = "SELECT count(coche) as coche from carte where id_user = ? and coche=1";
    private static final String SELECT_PAQUET = "SELECT id, cout, force, coche FROM CARTE WHERE id_user = ? and coche=1";

    /**
     * {@inheritDoc}
     * permet de cocher une carte de la colletion
     * @see fr.eni.fighters.dal.CarteDAO#cocherCarte(int)
     */
    @Override
    public void cocherCarte(int idCarte) throws BusinessException {
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(UPDATE_COCHE_CARTE);
	    pstmt.setInt(1, idCarte);
	    pstmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException(CodesResultatDAL.COCHE_CARTE_ERREUR);
	    throw businessException;
	}
    }

    /**
     * {@inheritDoc}
     * permet de décocher une carte de la colletion
     * @see fr.eni.fighters.dal.CarteDAO#decocherCarte(int)
     */
    @Override
    public void decocherCarte(int idCarte) throws BusinessException {
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(UPDATE_DECOCHE_CARTE);
	    pstmt.setInt(1, idCarte);
	    pstmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException(CodesResultatDAL.DECOCHE_CARTE_ERREUR);
	    throw businessException;
	}
    }

    /**
     * {@inheritDoc}
     * permet de cocher toutes les cartes de la collection
     * @see fr.eni.fighters.dal.CarteDAO#decocherToutLesCartes(int)
     */
    @Override
    public void decocherToutLesCartes(int idUser) throws BusinessException {
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(UPDATE_DECOCHE_CARTES);
	    pstmt.setInt(1, idUser);
	    pstmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException(CodesResultatDAL.DECOCHE_CARTES_ERREUR);
	    throw businessException;
	}
    }

    /**
     * {@inheritDoc}
     * permet de récupérer toutes les cartes de la collection
     * @see fr.eni.fighters.dal.CarteDAO#selectAll()
     */
    @Override
    public List<Carte> selectAll(int id) throws BusinessException {
	List<Carte> listesCartes = new ArrayList<>();
	Carte carte = null;
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
	    pstmt.setInt(1, id);
	    ResultSet rs = pstmt.executeQuery();
	    while (rs.next()) {
		carte = new Carte(rs.getInt("id"), rs.getInt("cout"), rs.getInt("force"), rs.getBoolean("coche"));
		listesCartes.add(carte);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException(CodesResultatDAL.DECOCHE_CARTES_ERREUR);
	    throw businessException;
	}
	return listesCartes;
    }

    /**
     * {@inheritDoc}
     * permet de compter le nombre de cartes cochées
     * @see fr.eni.fighters.dal.CarteDAO#countCocherCarte(int)
     */
    @Override
    public int countCocherCarte(int idUser) throws BusinessException {
	int nbCoche = 0;
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_COUNT_COCHE_CARTE);
	    pstmt.setInt(1, idUser);
	    ResultSet rs = pstmt.executeQuery();
	    while(rs.next()) {
		nbCoche = rs.getInt("coche");
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    BusinessException businessException = new BusinessException(CodesResultatDAL.DECOCHE_CARTES_ERREUR);
	    throw businessException;
	}
	return nbCoche;
    }
    
    @Override
    /*
     * permet de récupérer les cartes du paquet (5 cartes cochées)
     * (non-Javadoc)
     * @see fr.eni.fighters.dal.CarteDAO#selectPaquet(int)
     */
	public List<Carte> selectPaquet(int idUser) throws BusinessException {
		List<Carte> listesCartes = new ArrayList<>();
		Carte carte = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
		    PreparedStatement pstmt = cnx.prepareStatement(SELECT_PAQUET);
		    pstmt.setInt(1, idUser);
		    ResultSet rs = pstmt.executeQuery();
		    while (rs.next()) {
			carte = new Carte(rs.getInt("id"), rs.getInt("cout"), rs.getInt("force"), rs.getBoolean("coche"));
			listesCartes.add(carte);
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		    BusinessException businessException = new BusinessException(CodesResultatDAL.DECOCHE_CARTES_ERREUR);
		    throw businessException;
		}
		return listesCartes;
	}

}
