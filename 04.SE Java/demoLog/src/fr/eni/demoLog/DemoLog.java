package fr.eni.demoLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class DemoLog {

	private static Logger loggerA= LoggerFactory.getLogger("fr.eni.demoLog.DemoLog");
	private static Logger loggerB= LoggerFactory.getLogger("fr.eni.demoLog.DemoLog.B");
	
	public static void mainXX(String[] args) {

		((ch.qos.logback.classic.Logger)loggerA).setLevel(Level.INFO);
		
		loggerA.debug("Message de niveau DEBUG");
		loggerA.info("Message de niveau INFO ");
		loggerA.warn("Message de niveau WARN ");
		loggerA.error("Message de niveau ERROR ");
		
		loggerB.debug("Message de niveau DEBUG");
		loggerB.info("Message de niveau INFO ");
		loggerB.warn("Message de niveau WARN ");
		loggerB.error("Message de niveau ERROR ");
	}
	
	public static void main(String[] args) {
		
		MaClasse m = new MaClasse();
		m.maMethode();

	}
}
