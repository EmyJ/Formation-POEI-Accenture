package fr.eni.module04.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.module04.bll.AvisMger;
import fr.eni.module04.bll.BLLException;
import fr.eni.module04.bo.Avis;

@WebServlet("/ajouterNote")
public class GestionNoteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/gestion_avis.jsp");
			rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean erreur = false;
		String description = "";
		int note=0;
		if(req.getParameter("description")!=null && req.getParameter("description").trim().length() > 0 ) {
			description = req.getParameter("description");
		}else {
			erreur = true;
		}
		if(req.getParameter("note")!=null ) {
				
			try {				
				note= Integer.parseInt(req.getParameter("note"));
				if(note<0 || note >5) {
					erreur = true;
				}
			}catch(NumberFormatException nfe) {
				erreur = true;
			}
		}
		if(erreur) {
			req.setAttribute("erreur", "Saisie incorrecte");
		}else {
			Avis avis = new Avis(description, note);
			AvisMger avisMger = new AvisMger();
			try {
				avisMger.ajouterAvis(avis);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/gestion_avis.jsp");
		rd.forward(req, resp);
				
	}

}
