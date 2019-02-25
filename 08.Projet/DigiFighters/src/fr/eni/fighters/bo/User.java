/**
 * 
 */
package fr.eni.fighters.bo;

import java.io.Serializable;

/**
 * Classe pour
 * 
 * @author agrimonp2018
 * @date 11 févr. 2019
 */
public class User implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -9127951580670054995L;
    // Attributs de la classe
    private int id;
    private String email;
    private String pseudo;
    private String password;
    private int points;
    private CollectionCarte collectionCarte;

    /*
     * Constructeur.
     */
    public User() {

    }
    
    /*
     * Constructeur.
     * @param email
     * @param password
     */
    public User(String email, String password) {
	this.email = email;
	this.password = password;
    }
    
    /*
     * Constructeur.
     * @param email
     * @param pseudo
     * @param password
     */
    public User(String email, String pseudo, String password) {
	this(email, password);
	this.pseudo = pseudo;
    }
    
    /*
     * Constructeur.
     * @param email
     * @param pseudo
     * @param password
     * @param points
     */
    public User(String email, String pseudo, String password, int points) {
	this(email, password);
	this.pseudo = pseudo;
	this.points = points;
    }
    
    /*
     * Constructeur.
     * @param email
     * @param pseudo
     * @param password
     * @param collectionCarte
     */
    public User(String email, String pseudo, String password, CollectionCarte collectionCarte) {
	this(email, pseudo, password);
	this.collectionCarte = collectionCarte;
    }
    
    /*
     * Constructeur.
     * @param email
     * @param pseudo
     * @param password
     * @param points
     * @param collectionCarte
     */
    public User(String email, String pseudo, String password, int points, CollectionCarte collectionCarte) {
	this(email, pseudo, password, points);
	this.collectionCarte = collectionCarte;
    }
    
    /*
     * Constructeur.
     * @param id
     * @param email
     * @param pseudo
     * @param password
     * @param points
     */
    public User(int id, String email, String pseudo, String password, int points) {
	this(email, pseudo, password, points);
	this.id = id;
    }
    
    /*
     * Constructeur.
     * @param id
     * @param email
     * @param pseudo
     * @param password
     * @param points
     * @param collectionCarte
     */
    public User(int id, String email, String pseudo, String password, int points, CollectionCarte collectionCarte) {
	this(email, pseudo, password, points, collectionCarte);
	this.id = id;
    }

    // Getters Setters
    
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
     * Getter pour email.
     * @return the email
     */
    public String getEmail() {
	return email;
    }
    
    /**
     * Setter pour email.
     * @param nbPoint the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }
    
    /**
     * Getter pour pseudo.
     * @return the pseudo
     */
    public String getPseudo() {
	return pseudo;
    }
    
    /**
     * Setter pour pseudo.
     * @param typeIA the pseudo to set
     */
    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }
    
    /**
     * Getter pour password.
     * @return the password
     */
    public String getPassword() {
	return password;
    }
    
    /**
     * Setter pour password.
     * @param typeIA the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }
    
    /**
     * Getter pour points.
     * @return the points
     */
    public int getPoints() {
	return points;
    }
    
    /**
     * Setter pour points.
     * @param etat the points to set
     */
    public void setPoints(int points) {
	this.points = points;
    }

    /**
     * Getter pour collectionCarte.
     * 
     * @return the collectionCarte
     */
    public CollectionCarte getCollectionCarte() {
	return collectionCarte;
    }

    /**
     * Setter pour collectionCarte.
     * 
     * @param collectionCarte
     *            the collectionCarte to set
     */
    public void setCollectionCarte(CollectionCarte collectionCarte) {
	this.collectionCarte = collectionCarte;
    }

    // Méthodes
    @Override
    public String toString() {

	StringBuilder sb = new StringBuilder();
	sb.append(" id user : ");
	sb.append(getId());
	sb.append(" email : ");
	sb.append(getEmail());
	sb.append(" pseudo : ");
	sb.append(getPseudo());
	sb.append(" password : ");
	sb.append(getPassword());
	sb.append(" points : ");
	sb.append(getPoints());
	sb.append(" collection de cartes : ");
	sb.append(getCollectionCarte());

	return sb.toString();
    }

}
