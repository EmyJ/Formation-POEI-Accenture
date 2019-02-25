package fr.eni.fighters.bo;

import java.io.Serializable;

/**
 * Classe en charge de créer et gérer les objets de type Carte, qui constituent la collection de cartes du joueur/utilisateur
 * 
 * @author jaffani2018
 * @version DigiFighters - V1.0
 * @date 12 févr. 2019 - 11:46:07
 */
public class Carte implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 9056256710701766764L;
    private int id;
    private int cout;
    private int force;
    private boolean coche;

    /**
     * Constructeur.
     * 
     * @param id
     * @param cout
     * @param force
     */

    public Carte() {
	super();
    }

    public Carte(int cout, int force) {
	this.cout = cout;
	this.force = force;
    }

    public Carte(int cout, int force, boolean coche) {
	this(cout, force);
	this.coche = coche;
    }

    public Carte(int id, int cout, int force, boolean coche) {
	this(cout, force, coche);
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
     * Getter pour cout.
     * 
     * @return the cout
     */
    public int getCout() {
	return cout;
    }

    /**
     * Setter pour cout.
     * 
     * @param cout
     *            the cout to set
     */
    public void setCout(int cout) {
	this.cout = cout;
    }

    /**
     * Getter pour force.
     * 
     * @return the force
     */
    public int getForce() {
	return force;
    }

    /**
     * Setter pour force.
     * 
     * @param force
     *            the force to set
     */
    public void setForce(int force) {
	this.force = force;
    }

    /**
     * Getter pour coche.
     * 
     * @return the coche
     */
    public boolean isCoche() {
	return coche;
    }

    /**
     * Setter pour coche.
     * 
     * @param coche
     *            the coche to set
     */
    public void setCoche(boolean coche) {
	this.coche = coche;
    }

    // Méthodes
    @Override
    public String toString() {

	StringBuilder sb = new StringBuilder("Carte: ");
	sb.append("id : ");
	sb.append(getId());
	sb.append(" cout : ");
	sb.append(getCout());
	sb.append(" force : ");
	sb.append(getForce());
	sb.append(" fait partie d'un deck : ");
	sb.append(isCoche());
	return sb.toString();
    }
}
