package fr.eni.evaluations.bo;

public class EpreuveOrale extends Evaluation{

	public EpreuveOrale() {
		super();
	}

	public EpreuveOrale(int noEvaluation, String nom, int duree) {
		super(noEvaluation, nom, duree);
	}

	@Override
	public String toString() {
		return "Epreuve Orale "+super.toString() + "]";
	}

	
	
}
