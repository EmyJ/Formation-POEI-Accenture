/**
 * 
 */
package fr.eni.demoLog;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * @author sgobin
 *
 */
public class DemoLog01 {
	private static Logger loggerA = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.eni.demoLog.DemoLog");
	
	public static void main(String[] args) {
		
		ch.qos.logback.classic.Logger loggerA = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.eni.demoLog.DemoLog");
		//loggerA.setLevel(Level.ERROR); //Level.TRACE
		ch.qos.logback.classic.Logger loggerB = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.eni");
		//loggerB.setLevel(Level.TRACE); //Level.TRACE
		
		loggerA.trace("Message 1 - loggerA - trace.");
		loggerA.debug("Message 2 - loggerA - debug.");
		loggerA.info("Message 3 - loggerA - info.");
		loggerA.warn("Message 4 - loggerA - warn.");
		loggerA.error("Message 5 - loggerA - error.");
		
		maMethode();
	}

	private static void maMethode() {
		loggerA.info("Je rentre dans maMethode");
		
		try {
			Class.forName("classe.qui.nexiste.pas");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			loggerA.error("Erreur: la classe n'existe pas !!!");
		}
		
		
		loggerA.info("Je sort de maMethode");
		
	}
}
