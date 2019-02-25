package fr.eni.javaee.gestionlistescourses.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.eni.javaee.gestionlistescourses.messages.LecteurMessage;

/**
 * Application Lifecycle Listener implementation class LecteurMessage
 *
 */
@WebListener
public class LecteurMessageListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LecteurMessageListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
	LecteurMessage lecteurMessage = new LecteurMessage();
	sce.getServletContext().setAttribute("lecteurMsg", lecteurMessage);
    }
	
}
