package fr.eni.jpa.servlet.film;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.service.GestionFilm;

/**
 * Servlet implementation class ListeFilmsServlet
 */
@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean ok = false;
		try {
			int id = Integer.parseInt(request.getParameter("index"));
			GestionFilm gf = new GestionFilm();
			Film f = gf.trouverFilm(id);
			if (f != null){
				ok = true;
				request.setAttribute("film", f);
			}
		} catch (Exception e) {
		}

		if (ok){
			RequestDispatcher rd = request.getRequestDispatcher("afficherFilm.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("lister");
		}
	}

}
