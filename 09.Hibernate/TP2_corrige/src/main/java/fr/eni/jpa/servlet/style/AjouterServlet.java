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
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/ajouterStyle")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
//		if (libelle != null && !libelle.trim().equals("")){
		Style s = new Style(libelle);
		GestionStyle gs = new GestionStyle();
		try {
			gs.ajoutStyle(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	}
		
		response.sendRedirect("listerStyle");
	}

}
