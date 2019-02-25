package fr.eni.DemoInitParams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/DemoInitParams",
		initParams={@WebInitParam(name="NOM_PARAMETRE", value="VALEUR_PARAMETRE"),
		@WebInitParam(name="NO_PARAMETRE", value="VALEU_PARAMETRE")})

public class DemoInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    @Override
    public void init() throws ServletException {
    	System.out.println(this.getInitParameter("NOM_PARAMETRE"));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write(this.getInitParameter("NOM_PARAMETRE"));
		out.close();
		
		System.out.println(this.getInitParameter("NOM_PARAMETRE"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
