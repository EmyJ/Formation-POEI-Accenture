package fr.eni.fighters.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Assure la connection entre le programme et la BDD
 */
public abstract class ConnectionProvider {

    private static DataSource dataSource;

    static {
	try {
	    Context context = new InitialContext();
	    dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
	} catch (NamingException e) {
	    e.printStackTrace();
	    throw new RuntimeException("Impossible d'accéder à la base de données");
	}

    }

    public static Connection getConnection() throws SQLException {

	return dataSource.getConnection();
    }

}
