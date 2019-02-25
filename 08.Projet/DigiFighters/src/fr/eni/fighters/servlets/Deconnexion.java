package fr.eni.fighters.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deconnexion
 */
@WebServlet("/private/deconnexion")
public class Deconnexion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/include/deconnexion.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unused")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession(true);
	String id = null;
	try {
	    id = session.getId();
	} catch (NullPointerException e) {
	    id = "Aucun identifiant de session présent";
	}

	response.setContentType("text/plain");
	request.getSession().invalidate();
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/authentification.jsp");
	rd.forward(request, response);
    }

}
