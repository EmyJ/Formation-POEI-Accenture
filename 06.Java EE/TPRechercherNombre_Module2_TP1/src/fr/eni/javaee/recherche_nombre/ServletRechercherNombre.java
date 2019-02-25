package fr.eni.javaee.recherche_nombre;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class ServletRechercherNombre
 */

@WebServlet(
		urlPatterns="/ServletRechercherNombre",
		initParams= {
						@WebInitParam(name="BORNE_MIN",value="0"),
						@WebInitParam(name="BORNE_MAX",value="10")
					}
		)

public class ServletRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int nombreATrouver;
	private boolean win;
	private int Min;
	private int Max;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherNombre() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	//On recherche entre 0 inclus et la différence max-min+1 (car valeur max exclue)
    	//On ajoute ensuite borneMin pour arriver dans la plage ([borneMin;borneMax])
    	String BORNE_MAX = this.getInitParameter("BORNE_MAX");
    	String BORNE_MIN = this.getInitParameter("BORNE_MIN");
    	this.Max = Integer.parseInt(BORNE_MAX);
    	this.Min = Integer.parseInt(BORNE_MIN);
    	this.nombreATrouver=new Random().nextInt(Max-Min+1)+Min;
    	this.win=false;
    	System.out.println(this.nombreATrouver);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer la valeur
		String nombreSaisie = request.getParameter("nombre");
		if(nombreSaisie.equals(String.valueOf(this.nombreATrouver)) && !this.win)
		{
			response.sendRedirect("succes.html");
			this.win=true;
		}
		else
		{
			response.sendRedirect("echec.html");
		}
	}

}















