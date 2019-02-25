package fr.eni.fighters.servlets;

/**
 * Les codes disponibles sont entre 30000 et 39999
 */
public abstract class CodesResultatServlets {
	
	/**
	 * Format authentification incorrecte
	 */
	public static final int AUTHENTIFICATION_ERREUR=30000;
	/**
	 * Format login et mot de passe obligatoires
	 */
	public static final Integer LOGIN_OBLIGATOIRE = 30001;
	public static final Integer PWD_OBLIGATOIRE = 30002;
	public static final Integer EMAIL_OBLIGATOIRE = 30003;
	public static final Integer PWD_TAILLE = 30004;
	public static final Integer PSEUDO_OBLIGATOIRE = 30005;
	public static final Integer EMAIL_VALIDE = 30006;
	public static final Integer PAQUET_5_OBLIGATOIRE = 30007;
	public static final Integer COUT_PARTIE_INVALIDE = 30008;
	public static final Integer COUT_NULL = 30009;
	
	
	
}