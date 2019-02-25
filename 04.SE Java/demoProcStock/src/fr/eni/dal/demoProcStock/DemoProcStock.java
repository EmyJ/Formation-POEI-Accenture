package fr.eni.dal.demoProcStock;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
//import java.util.Date;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DemoProcStock {

	public static void main(String[] args) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String urlConnection = "jdbc:sqlserver://127.0.0.1;databasename=BDD_DEMO";
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try (Connection uneConnection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
				){
			
			System.out.println("Connexion réussie");
			String sql = "{call dbo.insertPersonne(?,?,?,?)}";
			CallableStatement callStm = uneConnection.prepareCall(sql);
			
			callStm.setString(1, "Nordine");
			callStm.setString(2, "Nateur");
			
//			Date laDate = null;
//			try {
//				laDate = sdf.parse("01/01/1972");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String laDate = "14/01/2019";
			LocalDate localdate = LocalDate.parse(laDate,formatter);
			
			//callStm.setDate(3,  new java.sql.Date(laDate.getTime()));
			callStm.setDate(3,  Date.valueOf(localdate));
			callStm.registerOutParameter(4, Types.INTEGER);
			
			callStm.execute();
			
			System.out.println("Id de la personne créée: " + callStm.getInt(4) );	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
