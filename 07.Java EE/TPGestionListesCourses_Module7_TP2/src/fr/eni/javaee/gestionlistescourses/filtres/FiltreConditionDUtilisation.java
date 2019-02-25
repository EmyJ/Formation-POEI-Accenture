package fr.eni.javaee.gestionlistescourses.filtres;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class FiltreConditionDUtilisation
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST
		}
		, urlPatterns = { "/*" })
public class FiltreConditionDUtilisation implements Filter {

	private static final int COOKIE_CGU_DUREE = 60; // 1 minutes pour permettre la démonstration de la fonctionnalité
	private static final String COOKIE_CGU_NAME = "CGUAcceptees";

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Pas de traiteemnt spécifique
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Pas de traiteemnt spécifique
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Le cookie d'acceptation des CGU est il transmis ?
		boolean cguAceptees = false;
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(COOKIE_CGU_NAME)) {
					cguAceptees = true;
					break;
				}
			}
		}
		
		// L'utilisateur vient d'acepter les CGU
		boolean cguAcceptationEnCours = false;
		String paramCGUAcceptees =  httpRequest.getParameter("cgu");
		if (paramCGUAcceptees != null && "acceptees".equals(paramCGUAcceptees)) {
			cguAcceptationEnCours = true;
		}
				
		// Laisser passer la requete dans plusieurs cas:
		// 1- l'utilisateur vient d'accepter les CGU (la requete est issue de l'action d'acceptation)
		// 2- l'utilisateur a déjà acepté les CGU (lors d'une utilisation préédente de l'application)
		// 3- les ressources demandées ne necessitent pas l'acceptation des CGU (images, css, etc.)
		if( cguAcceptationEnCours || 
			cguAceptees ||
			httpRequest.getServletPath().startsWith("/css") ||
			httpRequest.getServletPath().startsWith("/vendor") 
			)
		{
			if (cguAcceptationEnCours) {
				Cookie cookieCGU = new  Cookie(COOKIE_CGU_NAME, "accepted");
				cookieCGU.setMaxAge(COOKIE_CGU_DUREE);
				httpResponse.addCookie(cookieCGU);
			}
			
			chain.doFilter(request, response);
		}
		// Rediriger vers la page des CGU en "se souvenant" de la page initialement demandée
		else
		{
			httpRequest.setAttribute("urlCible", httpRequest.getContextPath()+httpRequest.getServletPath());
			RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/conditionDUtilisation.jsp");
			rd.forward(httpRequest, httpResponse);
		}
		
	}

}
