package fr.eni.demoLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaClasse {

	private static Logger loggerA = LoggerFactory.getLogger("fr.eni.demoLog.MaClasse"); 
	
	public void maMethode() {
		
		loggerA.debug("Message de niveau DEBUG, je suis dans la méthode");
		try {
			loggerA.warn("Message de niveau WARN, je suis dans le try ");
			Integer.parseInt("toto");
		} catch (Exception e) {
			loggerA.error("Message de niveau ERROR, ERREUR : " + e.getMessage());
		}finally {
			loggerA.info("Message de niveau INFO, je suis dans le finally ");
		}
		
		
		
	}
}
