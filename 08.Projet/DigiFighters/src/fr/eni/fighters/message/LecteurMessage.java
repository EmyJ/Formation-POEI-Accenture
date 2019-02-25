package fr.eni.fighters.message;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * Cette classe permet de lire le contenu du fichier messages_erreur.properties
 * où sont listés les erreurs par code d'erreur
 */
public class LecteurMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private static ResourceBundle rb;

    static {
	try {
	    rb = ResourceBundle.getBundle("fr.eni.fighters.message.messages_erreur");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * @param code
     * @return
     */
    public static String getMessageErreur(int code) {
	String message = "";
	try {
	    if (rb != null) {
		message = rb.getString(String.valueOf(code));
	    } else {
		message = "Problème à la lecture du fichier contenant les messages";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    message = "Une erreur inconnue est survenue";
	}
	return message;
    }
}