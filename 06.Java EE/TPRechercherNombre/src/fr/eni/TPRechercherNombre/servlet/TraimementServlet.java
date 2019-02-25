package fr.eni.TPRechercherNombre.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/TraimementServlet",
			initParams= {@WebInitParam(description= "valeur min", name="BORNE_MIN",value="0"),
						@WebInitParam(description= "valeur max",name="BORNE_MAX",value="10")})
public class TraimementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private int nombreATrouver;
	private boolean win;
	private int Min;
	private int Max;
       
   @Override
   public void init() throws ServletException {
	   	String BORNE_MAX = this.getInitParameter("BORNE_MAX");
   		String BORNE_MIN = this.getInitParameter("BORNE_MIN");
   		this.Max = Integer.parseInt(BORNE_MAX);
   		this.Min = Integer.parseInt(BORNE_MIN);
   		this.nombreATrouver = new Random().nextInt(Max-Min+1)+Min;
   		this.win = false;
   		System.out.println("nombre aléatoire : " + this.nombreATrouver);
   	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nombreSaisie = Integer.parseInt(request.getParameter("nombre"));
		
		if (nombreATrouver == nombreSaisie && !this.win) {
			response.sendRedirect("/TPRechercherNombre/pages/victoire.html");
			this.win = true;
			this.init();
		}else {
			response.sendRedirect("/TPRechercherNombre/pages/echec.html");
		}
	}

}
