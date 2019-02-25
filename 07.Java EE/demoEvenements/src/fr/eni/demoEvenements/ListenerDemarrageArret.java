package fr.eni.demoEvenements;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerDemarrageArret implements ServletContextListener {



	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Arrêt de l'application");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Démarrage de l'application");
		sce.getServletContext().setAttribute("demarrage", new Date());
	}

}
