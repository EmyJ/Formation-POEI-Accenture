package fr.eni.fighters.bo;

import java.io.Serializable;

public class Jeu implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = -4101176920133598581L;
	/*
	 * Attributs
	 */
	private int pointsAreneA;
	private int pointsAreneB;
	private int idPartie;
	private Bataille batailleUser;
	private Bataille batailleInvite;
	private int id_vainqueur;
	private boolean toutLeMondeGagne;
	
	/*
	 * Constructeurs
	 */
	public Jeu() {
	}
	
	public Jeu(int idPartie, int pointsAreneA, int pointsAreneB) {
		this.idPartie=idPartie;
		this.pointsAreneA=pointsAreneA;
		this.pointsAreneB=pointsAreneB;
	}
	
	public Jeu(int idPartie, int pointsAreneA, int pointsAreneB, Bataille batailleUser, Bataille batailleInvite ) {
		this(idPartie, pointsAreneA, pointsAreneB);
		this.batailleUser=batailleUser;
		this.batailleInvite=batailleInvite;
	}
	
	public Jeu(int idPartie, int pointsAreneA, int pointsAreneB, Bataille batailleUser, Bataille batailleInvite, int id_vainqueur ) {
		this(idPartie, pointsAreneA, pointsAreneB, batailleUser, batailleInvite );
		this.id_vainqueur=id_vainqueur;
	}
	
	public Jeu(int idPartie, int pointsAreneA, int pointsAreneB, Bataille batailleUser, Bataille batailleInvite, int id_vainqueur, boolean toutLeMondeGagne ) {
		this(idPartie, pointsAreneA, pointsAreneB, batailleUser, batailleInvite, id_vainqueur );
		this.toutLeMondeGagne=toutLeMondeGagne;
	}

	//Getters Setters
	/*
	 * 
	 */
	public int getPointsAreneA() {
		return pointsAreneA;
	}
	/*
	 * 
	 */
	public void setPointsAreneA(int pointsAreneA) {
		this.pointsAreneA = pointsAreneA;
	}
	/*
	 * 
	 */
	public int getPointsAreneB() {
		return pointsAreneB;
	}
	/*
	 * 
	 */
	public void setPointsAreneB(int pointsAreneB) {
		this.pointsAreneB = pointsAreneB;
	}
	/*
	 * 
	 */
	public int get() {
		return idPartie;
	}
	/*
	 * 
	 */
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	
	/*
	 * 
	 */
	public int getIdPartie() {
		return idPartie;
	}
	
	public Bataille getBatailleUser() {
		return batailleUser;
	}

	public void setBatailleUser(Bataille batailleUser) {
		this.batailleUser = batailleUser;
	}

	public Bataille getBatailleInvite() {
		return batailleInvite;
	}

	public void setBatailleInvite(Bataille batailleInvite) {
		this.batailleInvite = batailleInvite;
	}

	public int getId_vainqueur() {
		return id_vainqueur;
	}

	public void setId_vainqueur(int id_vainqueur) {
		this.id_vainqueur = id_vainqueur;
	}
	
	public boolean isToutLeMondeGagne() {
		return toutLeMondeGagne;
	}

	public void setToutLeMondeGagne(boolean toutLeMondeGagne) {
		this.toutLeMondeGagne = toutLeMondeGagne;
	}

	@Override
	public String toString() {
	    
	    StringBuilder sb = new StringBuilder("User: ");
		sb.append("pointsAreneA : ");
		sb.append(getPointsAreneA());
		sb.append(" pointsAreneB : ");
		sb.append(getPointsAreneB());
		sb.append(" idPartie : ");
		sb.append(getIdPartie());
		sb.append(" batailleUser : ");
		sb.append(getBatailleUser());
		sb.append(" batailleInvite : ");
		sb.append(getBatailleInvite());
		sb.append(" id_vainqueur : ");
		sb.append(getId_vainqueur());
		sb.append(" toutLeMondeGagne : ");
		sb.append(isToutLeMondeGagne());

		return sb.toString();
	}
}
