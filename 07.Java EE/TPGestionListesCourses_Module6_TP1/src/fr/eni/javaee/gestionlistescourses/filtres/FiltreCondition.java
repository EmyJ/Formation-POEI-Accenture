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

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * Servlet Filter implementation class FiltreCondition
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" }, servletNames = {"Filtre"})
public class FiltreCondition implements Filter {

    /**
     * Default constructor.
     */
    public FiltreCondition() {
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
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	Boolean ck = false;
	
	// lecture du cookie
	Cookie[] cookies = httpRequest.getCookies();

	if(cookies != null) {
        	for (Cookie cookie : cookies) {
        	    if ("monCookie".equals(cookie.getName())) {
        		if(cookie.getValue().equals("true")) {
        		    ck = true;
        		} 
        	    }
        	}
	}
	if(ck==true){
	    chain.doFilter(request, response);
	}else {
	    RequestDispatcher rd = httpRequest.getRequestDispatcher("/Filtre");
	    rd.forward(httpRequest, httpResponse);
	}
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
