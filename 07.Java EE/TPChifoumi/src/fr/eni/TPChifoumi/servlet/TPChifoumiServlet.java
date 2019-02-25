package fr.eni.TPChifoumi.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TPChifoumiServlet")
public class TPChifoumiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TPChifoumiServlet() {
	super();
    }

    public void init(ServletConfig config) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (request.getParameter("choix") != null) {
	    this.doPost(request, response);
	} else {
	    HttpSession session = request.getSession();
	    request.setAttribute("urlC", request.getContextPath());
	    session.setAttribute("lang", "fr");
	    if (request.getParameter("fr") != null) {
		session.setAttribute("lang", "fr");
	    }
	    if (request.getParameter("en") != null) {
		session.setAttribute("lang", "en");
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
	    rd.forward(request, response);
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	int choixJoueur = Integer.parseInt(request.getParameter("choix"));
	int choixServeur = new Random().nextInt(3) + 1;
	int resultat;

	if (choixJoueur == choixServeur) {
	    resultat = 0;
	} else if ((choixJoueur == 1 && choixServeur == 3) || (choixJoueur == 2 && choixServeur == 1)
		|| (choixJoueur == 3 && choixServeur == 2)) {
	    resultat = 1;
	} else {
	    resultat = -1;
	}

	request.setAttribute("resultat", resultat);
	request.setAttribute("choixServeur", choixServeur);
	request.setAttribute("choixJoueur", choixJoueur);

	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/resultat.jsp");
	if (rd != null) {
	    rd.forward(request, response);
	} else {
	    response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
    }

}
