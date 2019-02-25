package fr.eni.evaluation.dal.jdbc;

import java.util.Properties;

public class Settings {

	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible de charger le ficher");
		}
	}
	
	public static String getProperty(String cle) {
		String parametre = properties.getProperty(cle);
		return parametre;
	}
}
