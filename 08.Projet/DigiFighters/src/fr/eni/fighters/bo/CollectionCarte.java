package fr.eni.fighters.bo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe en charge de gérer la collection de cartes du joueur/utilisateur
 * 
 * @author jaffani2018
 * @version DigiFighters - V1.0
 * @date 12 févr. 2019 - 11:51:19
 */
public class CollectionCarte implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -7447661521285080512L;
    private int id;
    private ArrayList<Carte> cartes =  new ArrayList<>();

    /**
     * Constructeur.
     */
    public CollectionCarte() {
	super();
    }

    /**
     * Constructeur.
     * 
     * @param id_user
     * @param cartes
     */
    public CollectionCarte(ArrayList<Carte> cartes) {
	super();
	this.cartes = cartes;
    }

    /**
     * Constructeur.
     * 
     * @param id
     * @param cartes
     */
    public CollectionCarte(int id, ArrayList<Carte> cartes) {
	this(cartes);
	this.id = id;
    }

    /**
     * Getter pour id.
     * 
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * Setter pour id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Getter pour carte.
     * 
     * @return the carte
     */
    public ArrayList<Carte> getCartes() {
	return cartes;
    }

    /**
     * Setter pour carte.
     * 
     * @param carte the carte to set
     */
    public void setCartes(ArrayList<Carte> cartes) {
	this.cartes = cartes;
    }

    // Méthodes
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("CollectionCarte: ");
	sb.append("id : ");
	sb.append(getId());
	sb.append(" liste de Cartes : ");
	sb.append(getCartes());

	return sb.toString();
    }

}
