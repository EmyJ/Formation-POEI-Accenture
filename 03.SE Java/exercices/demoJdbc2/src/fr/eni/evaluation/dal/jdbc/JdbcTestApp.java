package fr.eni.evaluation.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import fr.eni.evaluation.bo.Stagiaire;

public class JdbcTestApp {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pr = null;

		try {
			con = JdbcTools.getConnection();

			afficheStagiaires();
			supprimeStagiaire(2);
			upadateStagiaire("Emilie",6);
			afficheStagiaires();
			insertStagiaire("toto","titi","toto.titi@eni.fr","trouver4");
			afficheStagiaires();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à la BDD");
		} finally {
			try {
				if (pr !=null) {
					pr.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}

	}
	
	private static void insertStagiaire(String prenom, String nom, String email, String password) {
		Connection con = null;
		PreparedStatement pr = null;

		try {
			con = JdbcTools.getConnection();
			
			String sql = "INSERT INTO Stagiaire (prenom,nom,email,password) VALUES (?,?,?,?)";
			pr = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pr.setString(1, prenom);
			pr.setString(2, nom);
			pr.setString(3, email);
			pr.setString(4, password);
			int nbLigne = pr.executeUpdate();
			if (nbLigne > 0) {
				System.out.println("Insertion réussie");
			} else {
				System.out.println("Aucunes Insertion");
			}
			
			ResultSet rsCle = pr.getGeneratedKeys();
			if (rsCle.next()) {
				System.out.println("N° du stagiaire généré :"  + rsCle.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à la BDD");
		} finally {
			try {
				if (pr !=null) {
					pr.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}
	}

	private static void upadateStagiaire(String prenom, int id) {
		Connection con = null;
		PreparedStatement pr = null;

		try {
			con = JdbcTools.getConnection();

			afficheStagiaires();
			supprimeStagiaire(2);

			// Création de la requete de Update
			String sql = "UPDATE dbo.Stagiaire set prenom=? Where idStagiaire=? ";
			pr = con.prepareStatement(sql);
			pr.setString(1, prenom);
			//pr.setNull(1, Types.NVARCHAR);
			pr.setInt(2, id);
			int nbLigne = pr.executeUpdate();
			if (nbLigne > 0) {
				System.out.println("Modification réussie");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à la BDD");
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}

	}

	private static void supprimeStagiaire(int id) {

		Connection con = null;
		PreparedStatement pr = null;

		try {
			con = JdbcTools.getConnection();

			// Creation de la requete de Delete
			String sql = "DELETE FROM Stagiaire WHERE idStagiaire =?";
			pr = con.prepareStatement(sql);
			int numero = id;
			pr.setInt(1, numero);
			int nbLigne = pr.executeUpdate();
			if (nbLigne > 0) {
				System.out.println("Suppression réussie");
			} else {
				System.out.println("Aucunes Suppression");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à la BDD");
		} finally {
			try {
				if (pr != null) {
					pr.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}
	}

	private static void afficheStagiaires() {

		Connection con = null;
		Statement stmt = null;
		List<Stagiaire> liste = new ArrayList<>();

		try {
			con = JdbcTools.getConnection();
			// Création de la requete de selection
			stmt = con.createStatement();
			String sql = "SELECT * FROM Stagiaire";
			ResultSet rs = stmt.executeQuery(sql);
			Stagiaire st = null;
			while (rs.next()) {
				st = new Stagiaire();
				st.setNoStagiaire(rs.getInt("idStagiaire"));
				st.setNom(rs.getString("nom"));
				st.setPrenom(rs.getString("prenom"));
				st.setEmail(rs.getString("email"));
				st.setMotDePasse(rs.getString("password"));
				liste.add(st);
			}
			// affiche les stagiaire
			for (Stagiaire s : liste) {
				System.out.println(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à la BDD");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Impossible de fermer la connexion");
			}
		}
	}

}
