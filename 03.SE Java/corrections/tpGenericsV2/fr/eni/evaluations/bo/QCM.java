package fr.eni.evaluations.bo;

public class QCM extends Evaluation{

	private int nbQuestion;

	public int getNbQuestion() {
		return nbQuestion;
	}

	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}

	public QCM(int noEvaluation, String nom, int duree,int nbQuestion) {
		super(noEvaluation, nom, duree);
		this.nbQuestion = nbQuestion;
	}

	@Override
	public String toString() {
		return "QCM ["+ super.toString()+"nbQuestion = " + nbQuestion +"]"; //+ ", NoEvaluation = " + getNoEvaluation() + ", Nom = " + getNom()
		//		+ ", Duree = " + getDuree() + "]";
	}

	

	
	
	
}
