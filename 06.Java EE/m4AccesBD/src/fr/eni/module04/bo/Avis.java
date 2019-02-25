package fr.eni.module04.bo;

public class Avis {

	private int identifiant;
	
	private String description;
	
	private int note;
	
	public Avis( String description, int note) {
		this.description = description;
		this.note = note;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
}
