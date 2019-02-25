package fr.eni.TPSuiviDesRepas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/accueil")
public class accueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public accueilServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request,response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn").equals("add")){
            request.getRequestDispatcher("/WEB-INF/pages/Ajout.jsp").forward(request, response);
        }else if (request.getParameter("btn").equals("lst")){
            request.getRequestDispatcher("/WEB-INF/pages/Historique.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request,response);
        }
	}

}
