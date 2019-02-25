package fr.eni.javaee.preferencesdusage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGestionPreference
 */
@WebServlet("/ServletGestionPreference")
public class ServletGestionPreference extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public void init() throws ServletException {
		/*Liste écrite en dur*/
		/*List<String> couleurs = new ArrayList<String>();
		couleurs.add("rouge");
		couleurs.add("bleu");
		couleurs.add("vert");
		couleurs.add("noir");*/
		
		/*Ou liste écrite dans le fichier web.xml*/
		String chaineCouleurs = this.getServletContext().getInitParameter("COULEURS");
		List<String> couleurs = Arrays.asList(chaineCouleurs.split(","));
		
		/*Ou liste stockée en base de données*/
		/*A vous de jouer...*/
		
		this.getServletContext().setAttribute("couleurs", couleurs);
		super.init();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionPreference() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookieNbAcces=null;
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				if(c.getName().equals("nbAcces"))
				{
					cookieNbAcces=c;
					int valeur = Integer.parseInt(cookieNbAcces.getValue())+1;
					cookieNbAcces.setValue(String.valueOf(valeur));
					break;
				}
			}
		}
		
		if(cookieNbAcces==null)
		{
			cookieNbAcces=new Cookie("nbAcces", "1");
		}
		
		cookieNbAcces.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(cookieNbAcces);
		
		request.setAttribute("cookieNbAcces", cookieNbAcces);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("couleurPreferee", request.getParameter("couleurChoisie"));
		doGet(request, response);
	}

}










