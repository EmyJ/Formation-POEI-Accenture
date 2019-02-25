/**
 * 
 */
package fr.eni.fighters.bo;

import java.io.Serializable;

/**
 * Classe en charge gérer les parties de jeu de l'application
 * @author ejezeque2018
 * @version DigiFighters - V1.0
 * @date 13 févr. 2019 - 11:34:05
 */
public class Partie implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 9069146518960958521L;
    private int id;
    private int nbPoint;
    private String type;
    private String etat;
    private int id_user;
    private int id_invite;
    /**
     * Constructeur.
     */
    public Partie() {
    }
   
    /**
     * Constructeur.
     * @param nbPoint
     * @param type
     */
    public Partie(int nbPoint, String type) {
	this.nbPoint = nbPoint;
	this.type = type;
    }

    /**
     * Constructeur.
     * @param nbPoint
     * @param type
     * @param etat
     */
    public Partie(int nbPoint, String type, String etat) {
	this(nbPoint, type);
	this.etat = etat;
    }

    /**
     * Constructeur.
     * @param nbPoint
     * @param type
     * @param etat
     * @param id_user
     */
    public Partie(int nbPoint, String type, String etat, int id_user) {
	this(nbPoint, type, etat);
	this.id_user = id_user;
    }

    /**
     * Constructeur.
     * @param id
     * @param nbPoint
     * @param type
     * @param etat
     * @param id_user
     */
    public Partie(int id, int nbPoint, String type, String etat, int id_user) {
	this(nbPoint, type, etat, id_user);
	this.id = id;
    }
    
    /*
     * Constructeur.
     * @param id
     * @param nbPoint
     * @param type
     * @param etat
     * @param id_user
     * @param id_invite
     */
    public Partie(int id, int nbPoint, String type, String etat, int id_user, int id_invite) {
    	this(id, nbPoint, type, etat, id_user);
    	this.id_invite = id_invite;
        }
    

    /**
     * Getter pour id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pour id.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pour nbPoint.
     * @return the nbPoint
     */
    public int getNbPoint() {
        return nbPoint;
    }

    /**
     * Setter pour nbPoint.
     * @param nbPoint the nbPoint to set
     */
    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }

    /**
     * Getter pour typeIA.
     * @return the typeIA
     */
    public String getType() {
        return type;
    }

    /**
     * Setter pour typeIA.
     * @param typeIA the typeIA to set
     */
    public void setType(String typeIA) {
        this.type = typeIA;
    }

    /**
     * Getter pour etat.
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Setter pour etat.
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * Getter pour id_user.
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * Setter pour id_user.
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    /**
     * Getter pour id_user.
     * @return the id_user
     */
    public int getId_invite() {
        return id_invite;
    }

    /**
     * Setter pour id_user.
     * @param id_user the id_user to set
     */
    public void setId_invite(int id_invite) {
        this.id_invite = id_invite;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("Partie: ");
	sb.append("id : ");
	sb.append(getId());
	sb.append(" coutPartie : ");
	sb.append(getNbPoint());
	sb.append(" type : ");
	sb.append(getType());
	sb.append(" Etat : ");
	sb.append(getEtat());
	sb.append(" id_user : ");
	sb.append(getId_user());

	return sb.toString();
	
    }
    
    
    
}
