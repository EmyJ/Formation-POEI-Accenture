package fr.eni.jpa.servlet.film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Acteur;
import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Realisateur;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionFilm;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/editer")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			GestionStyle gs = new GestionStyle();
			request.setAttribute("listeStyles", gs.listeStyles());
			GestionFilm gf = new GestionFilm();
			Film f = gf.trouverFilm(Integer.parseInt(request.getParameter("index").substring(1)));
			request.setAttribute("film", f);
			RequestDispatcher rd = request.getRequestDispatcher("/editerFilm.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("lister");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestionStyle gs = new GestionStyle();
			GestionFilm gf = new GestionFilm();
			Style s = gs.trouverStyle(Integer.parseInt(request.getParameter("style")));
			int index = Integer.parseInt(request.getParameter("id"));
			Film f = gf.trouverFilm(index);
			f.setTitre(request.getParameter("titre"));
			f.setAnnee(Integer.parseInt(request.getParameter("annee")));
			f.setStyle(s);
			Realisateur r = new Realisateur();
			r.setNom(request.getParameter("real.nom"));
			r.setPrenom(request.getParameter("real.prenom"));
			f.setReal(r);
			f.setDuree(request.getParameter("duree"));
			f.setVu(Boolean.parseBoolean(request.getParameter("vu")));
			f.setSynopsis(request.getParameter("synopsis"));
			List<Acteur> listeA = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				String nom = request.getParameter("nom"+i).trim();
				String prenom = request.getParameter("prenom"+i).trim();
				if (!nom.equals("") || !prenom.equals(""))
					listeA.add(new Acteur(nom, prenom));
			}
			f.setActeurs(listeA);
			
			gf.modifierFilm(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("lister");
	}
	
	
	

}
