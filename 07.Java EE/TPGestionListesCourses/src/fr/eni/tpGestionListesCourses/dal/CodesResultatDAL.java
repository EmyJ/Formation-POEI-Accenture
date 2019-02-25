package fr.eni.tpGestionListesCourses.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de la lecture des repas
	 */
	public static final int LECTURE_LISTE_ECHEC=10002;
	
	/**
	 * Echec général quand tentative de suppression un objet null
	 */
	public static final int DELETE_OBJET_NUL=10003;
	/**
	 * Echec général quand erreur non gérée à la suppression 
	 */
	public static final int DELETE_OBJET_ECHEC=10004;
}