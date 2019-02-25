package fr.eni.jpa.servlet.style;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class ListeFilmsServlet
 */
@WebServlet("/listerStyle")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GestionStyle gs = new GestionStyle();
		List<Style> listeS = gs.listeStyles();
		
		Style style = new Style(); 
		request.setAttribute("listeS", listeS);
		request.setAttribute("style", style);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listeStyles.jsp");
		rd.forward(request, response);
		
	}

}
