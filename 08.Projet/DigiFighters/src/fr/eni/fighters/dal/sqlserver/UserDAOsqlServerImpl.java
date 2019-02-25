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

import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.User;
import fr.eni.fighters.dal.ConnectionProvider;
import fr.eni.fighters.dal.DALException;
import fr.eni.fighters.dal.UserDAO;

/**
 * Classe pour
 * 
 * @author agrimonp2018
 * @date 11 févr. 2019
 */
public class UserDAOsqlServerImpl implements UserDAO {

    private static final String INSERT_USER = "INSERT INTO UTILISATEUR (pseudo, email, motDePasse) VALUES (?, ?, ?)";
    private static final String INSERT_CARTES_INIT = "INSERT INTO CARTE (cout, force, coche, id_user) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT id, pseudo, email, motDePasse, points FROM UTILISATEUR";
    private static final String DELETE = "DELETE FROM UTILISATEUR WHERE id=?";
    private static final String SELECT_BY_ID = "SELECT id, pseudo, email, motDePasse, points FROM UTILISATEUR WHERE id=? ";
    private static final String UPDATE_USER = "UPDATE UTILISATEUR SET email=?, motDePasse=?, points=? WHERE id = ?";
    
    /*
     * permet d'insérer un nouvel utilisateur
     * (non-Javadoc)
     * @see fr.eni.fighters.dal.UserDAO#insert(fr.eni.fighters.bo.User)
     */
    public void insert(User user) throws DALException {
	try (Connection conn = ConnectionProvider.getConnection()) {
	    try {
		conn.setAutoCommit(false);
		// Préparer la requete
		PreparedStatement stmt = conn.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user.getPseudo());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getPassword());
		// Executer la requete
		stmt.executeUpdate();
		// Recupérer l'identifiant créé
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
		    user.setId(rs.getInt(1));
		}
		stmt.close();
		rs.close();
		
		//Insérer les dix cartes de base dans la table CARTE
		stmt = conn.prepareStatement(INSERT_CARTES_INIT, PreparedStatement.RETURN_GENERATED_KEYS);
		//REQUETE POUR LA TABLE ARTICLE
		for (Carte carte : user.getCollectionCarte().getCartes()) {
			stmt.setInt(1, carte.getCout());
			stmt.setInt(2, carte.getForce());
			stmt.setBoolean(3, carte.isCoche());
			stmt.setInt(4, user.getId());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				carte.setId(rs.getInt(1));
			}
		}
		
		conn.commit();
	    } catch (SQLException e) {
		conn.rollback();
		e.printStackTrace();
	    }
	} catch (SQLException e) {
	    throw new DALException("Erreur insert", e);
	}
    }

    /**
     * {@inheritDoc}
     * permet de sélectionner tous les utilisateurs
     * @see fr.eni.fighters.dal.UserDAO#selectAll()
     */
    @Override
    public List<User> selectAll() throws DALException {
	List<User> listesUser = new ArrayList<>();
	User user = null;
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
	    ResultSet rs = pstmt.executeQuery();
	    while (rs.next()) {
		user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("pseudo"),
			rs.getString("motDePasse"), rs.getInt("points"));
		listesUser.add(user);
	    }

	} catch (SQLException e) {
	    throw new DALException("Selection Echouée", e);
	}
	return listesUser;
    }

    /**
     * {@inheritDoc} Méthode qui supprime un Utilisateur
     * 
     * @see fr.eni.fighters.dal.UserDAO#delete(int)
     */
    @Override
    public void delete(int id) throws DALException {
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(DELETE);
	    pstmt.setInt(1, id);
	    pstmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    DALException dalException = new DALException();
	    // dalException.ajouterErreur(CodesResultatDAL.SUPPRESSION_UTILISATEUR_ERREUR);
	    throw dalException;
	}
    }

    /**
     * {@inheritDoc}
     * permet de sélectionner un utilisateur par id
     * @see fr.eni.fighters.dal.UserDAO#selectById(int)
     */
    @Override
    public User selectById(int id) throws DALException {

	User user = new User();
	try (Connection cnx = ConnectionProvider.getConnection()) {
	    PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
	    pstmt.setInt(1, id);
	    ResultSet rs = pstmt.executeQuery();
	    boolean premiereLigne = true;
	    while (rs.next()) {
		if (premiereLigne) {
		    user.setId(rs.getInt("id"));
		    user.setEmail(rs.getString("email"));
		    user.setPseudo(rs.getString("pseudo"));
		    user.setPassword(rs.getString("motDePasse"));
		    user.setPoints(rs.getInt("points"));
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    DALException dalException = new DALException();
	    // businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
	    throw dalException;
	}
	if (user.getId() == 0) {
	    DALException dalException = new DALException();
	    // businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
	    throw dalException;
	}
	return user;
    }


    /*
     * (non-Javadoc)
     * Méthode pour modifier un utilisateur dans la BDD
     * @see fr.eni.fighters.dal.UserDAO#update(fr.eni.fighters.bo.User)
     */
    public void update(User user) throws DALException {

	try (Connection conn = ConnectionProvider.getConnection()) {
	    try {
		conn.setAutoCommit(false);
		// Préparer la requete
		PreparedStatement stmt = conn.prepareStatement(UPDATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user.getEmail());
		stmt.setString(2, user.getPassword());
		stmt.setInt(3, user.getPoints());
		stmt.setInt(4, user.getId());
		// Executer la requete
		stmt.executeUpdate();
		conn.commit();
	    } catch (SQLException e) {
		conn.rollback();
		e.printStackTrace();
	    }
	} catch (SQLException e) {
	    throw new DALException("Erreur update", e);
	}

    }
}
