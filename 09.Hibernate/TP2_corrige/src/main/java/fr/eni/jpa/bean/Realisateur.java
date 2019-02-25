package fr.eni.jpa.bean;
import javax.persistence.Entity;

@Entity
public class Realisateur extends Personne {

	public Realisateur() {
		super();
	}

	public Realisateur(int id, String nom, String prenom) {
		super(id, nom, prenom);
	}

	public Realisateur(String nom, String prenom) {
		super(nom, prenom);
	}

}
