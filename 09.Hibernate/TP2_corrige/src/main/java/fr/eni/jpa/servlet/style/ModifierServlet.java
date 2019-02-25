package fr.eni.jpa.servlet.style;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/modifStyle")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			GestionStyle gs = new GestionStyle();
			Style s = gs.trouverStyle(Integer.parseInt(request.getParameter("id")));
			s.setLibelle(request.getParameter("libelle"));
			gs.modifierStyle(s);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listerStyle");
	}

}
