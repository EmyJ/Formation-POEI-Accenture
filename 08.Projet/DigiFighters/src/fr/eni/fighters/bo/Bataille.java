/**
 * 
 */
package fr.eni.fighters.bo;

import java.io.Serializable;

/**
 * Classe pour gérer les infos de jeu perso pour un joueur pour une partie donnée
 * @author agrimonp2018
 * @date 15 févr. 2019
 */
public class Bataille implements Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1050510750006725475L;
	private int id_joueur;
	private Carte carte0;
	private Carte carte1;
	private Carte carte2;
	
	private String case0;
	private String case1;
	private String case2;
	
	private boolean vainqueurA;
	private boolean vainqueurB;
	
	private int pointsArene;
	
	public Bataille() {
		
	}
	
	public Bataille(int id_joueur, Carte carte0, Carte carte1, Carte carte2 ) {
		this.id_joueur = id_joueur;
		this.carte0 = carte0;
		this.carte1 = carte1;
		this.carte2 = carte2;
	}

	public Bataille(int id_joueur, Carte carte0, Carte carte1, Carte carte2, String case0, String case1, String case2) {
		this(id_joueur, carte0, carte1, carte2);
		this.case0 = case0;
		this.case1 = case1;
		this.case2 = case2;
	}
	
	public Bataille(int id_joueur, Carte carte0, Carte carte1, Carte carte2, String case0, String case1, String case2, boolean vainqueurA, boolean vainqueurB) {
		this(id_joueur, carte0, carte1, carte2, case0, case1, case2);
		this.vainqueurA = vainqueurA;
		this.vainqueurB = vainqueurB;
	}
	
	public Bataille(int id_joueur, Carte carte0, Carte carte1, Carte carte2, String case0, String case1, String case2, boolean vainqueurA, boolean vainqueurB, int pointsArene) {
		this(id_joueur, carte0, carte1, carte2, case0, case1, case2, vainqueurA, vainqueurB);
		this.pointsArene = pointsArene;
	}
	
	

	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public Carte getCarte0() {
		return carte0;
	}

	public void setCarte0(Carte carte0) {
		this.carte0 = carte0;
	}

	public Carte getCarte1() {
		return carte1;
	}

	public void setCarte1(Carte carte1) {
		this.carte1 = carte1;
	}

	public Carte getCarte2() {
		return carte2;
	}

	public void setCarte2(Carte carte2) {
		this.carte2 = carte2;
	}

	public String getCase0() {
		return case0;
	}

	public void setCase0(String case0) {
		this.case0 = case0;
	}

	public String getCase1() {
		return case1;
	}

	public void setCase1(String case1) {
		this.case1 = case1;
	}

	public String getCase2() {
		return case2;
	}

	public void setCase2(String case2) {
		this.case2 = case2;
	}
	
	public boolean isVainqueurA() {
		return vainqueurA;
	}

	public void setVainqueurA(boolean vainqueurA) {
		this.vainqueurA = vainqueurA;
	}

	public boolean isVainqueurB() {
		return vainqueurB;
	}

	public void setVainqueurB(boolean vainqueurB) {
		this.vainqueurB = vainqueurB;
	}
	
	public int getPointsArene() {
		return pointsArene;
	}

	public void setPointsArene(int pointsArene) {
		this.pointsArene = pointsArene;
	}

	@Override
	public String toString() {
		    
		    StringBuilder sb = new StringBuilder("User: ");
			sb.append("id_joueur : ");
			sb.append(getId_joueur());
			sb.append(" carte0 : ");
			sb.append(getCarte0());
			sb.append(" carte1 : ");
			sb.append(getCarte1());
			sb.append(" carte2 : ");
			sb.append(getCarte2());
			sb.append(" case0 : ");
			sb.append(getCase0());
			sb.append(" case1 : ");
			sb.append(getCase1());
			sb.append(" case2 : ");
			sb.append(getCase2());
			sb.append(" vainqueurA : ");
			sb.append(isVainqueurA());
			sb.append(" vainqueurB : ");
			sb.append(isVainqueurB());
			sb.append(" pointsArene : ");
			sb.append(getPointsArene());

			return sb.toString();
		
	}	
	
}
