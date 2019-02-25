package fr.eni.javaee.gestionlistescourses.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.eni.javaee.gestionlistescourses.messages.LecteurMessage;

/**
 * Application Lifecycle Listener implementation class LecteurMessageListener
 *
 */
@WebListener
public class LecteurMessageListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
		// Placer une instance de LecteurMessage dans le contexte application afin qu'elle 
		// soit acessible par les expressions E.L. dans toutes les pages
		LecteurMessage lecteur = new LecteurMessage();
		sce.getServletContext().setAttribute("lecteurMsg", lecteur);

    }
	
}
