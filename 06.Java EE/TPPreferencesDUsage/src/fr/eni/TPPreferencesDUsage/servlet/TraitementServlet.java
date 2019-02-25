package fr.eni.TPPreferencesDUsage.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/TraitementServlet")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int compteur = 1;
	private ServletContext contexte;
	private HttpSession session;
	private Cookie cookieMot;

	@Override
	public void init() throws ServletException {
	    String chaineCouleurs = this.getServletContext().getInitParameter("COULEURS");
	    List<String> couleurs = Arrays.asList(chaineCouleurs.split(","));
	    this.getServletContext().setAttribute("couleurs", couleurs);
	    super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contexte = getServletContext();
		if (cookieMot == null) {
			cookieMot = new Cookie("cookieMot",String.valueOf(compteur));
			response.addCookie(cookieMot);
		}else {
			Cookie[] cookies = request.getCookies();
			if (cookies!=null) {
				for (int i=0;i<cookies.length;i++){
					if("cookieMot".equals(cookies[i].getName())) {
						cookies[i].setValue(String.valueOf(compteur++));
						response.addCookie(cookies[i]);
					} 
				} 
			} 
		}
		request.getRequestDispatcher("/WEB-INF/pages/accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getSession().setAttribute("couleurPreferee", request.getParameter("couleurChoisie"));
	    doGet(request, response);
	}

}
