package fr.eni.jpa.servlet.style;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/supprimerStyle")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			GestionStyle gs = new GestionStyle();
			gs.supprimerStyle(Integer.parseInt(request.getParameter("index")));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listerStyle");
	}

}
