package fr.eni.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DemoJdbc {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		//Etape 1 chargement du driver JDBC
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur pendant le chargement du driver");
		}
		
		//Etape2 connexion à la base de donnée
		String url = "jdbc:sqlserver://127.0.0.1;databasename=EVAL_DB";
		try {
			con = DriverManager.getConnection(url,"sa","Pa$$w0rd");
			//System.out.println("Connexion ok");
			//Etape 3 créer la requete au travers du statement
			stmt = con.createStatement();
			//Etape4 executer une requete sql
			String sql = "SELECT idStagiaire, nom, prenom, email, password FROM  dbo.Stagiaire";
			ResultSet rs = stmt.executeQuery(sql);
			//Etape 5 traiter le resultat
			StringBuffer retour = new StringBuffer();
			while (rs.next()) {
				
				retour.append(rs.getInt("idStagiaire") + " ");
				retour.append(rs.getString("nom") + " ");
				retour.append(rs.getString("prenom") + " ");
				retour.append(rs.getString("email") + " ");
				retour.append(rs.getString("password") + "\n");
			}
			System.out.println(retour.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur pendant la connexion à la base de donnée");
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erreur");
			}
		}
	}

}
