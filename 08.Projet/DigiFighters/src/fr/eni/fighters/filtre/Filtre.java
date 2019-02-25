package fr.eni.fighters.filtre;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtre les pages pour la sécurité
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/private/*" })
public class Filtre implements Filter {
    public static final String ACCES_CONNEXION = "/authentification";
    public static final String ATT_SESSION_USER = "login";

    /**
     * Default constructor.
     */
    public Filtre() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	
	/* Récupération de la session depuis la requête */
        HttpSession session = httpRequest.getSession();

        /**
         * Si l'objet login n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher( ACCES_CONNEXION ).forward( httpRequest, httpResponse );
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( httpRequest, httpResponse );
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
