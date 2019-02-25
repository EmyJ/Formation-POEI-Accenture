package fr.eni.tpGestionListesCourses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/testPoolConnexion")
public class TestPoolConnexionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Context context = new InitialContext();
			
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			Connection cnx = dataSource.getConnection();
			
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte"));
			cnx.close();
			
		} catch (NamingException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une erreur est survenue lors de l'acces à la base de données : " + e.getMessage());
		}
	}

}
