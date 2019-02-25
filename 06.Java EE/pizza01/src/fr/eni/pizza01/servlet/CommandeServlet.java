package fr.eni.pizza01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/faireSaPizza")
public class CommandeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doPost(request, response);
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "/pizza01/pages/page.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Récupere les information dans la console*/
		String nom = request.getParameter("nom");
		String base = request.getParameter("base");
		String[] ingredients = request.getParameterValues("ingredients");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>\n<html>\n<head>\n<title>Votre pizza</title>\n</head>");
		sb.append("<body>");
		sb.append("\nNom de votre pizza : ");
		sb.append(nom);
		sb.append("<br>");
 		sb.append("\nBase : ");
 		sb.append(base);
 		sb.append("<br>");
 		sb.append("\nIngrédients : ");
		for (int i = 0; i < ingredients.length; i++) {
			sb.append(ingredients[i]);
			if (i < ingredients.length - 1) {
				sb.append(", ");
			}
	     }	
		sb.append("<br>");
		sb.append("\nQuantité commandée : ");
		sb.append(quantite);
		sb.append("\n</body>\n</html>");
		System.out.println(sb.toString());
		
		/*Afficher les informations sur une page html*/
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();
	}

}
