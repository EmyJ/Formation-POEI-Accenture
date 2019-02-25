package observer;

public class TestPatternObserver {

	
	public static void main(String[] args) {
		
		//Instanciation du sujet
		Sujet sujet = new Sujet();
		
		//Test avant inscription des observateurs
		System.out.println("Test avant inscription des observateurs:");
		sujet.evenement(); //Doit afficher "Emission evenement..."
		
		
		//Inscription des observateurs
		Observateur obsA = new ConcreteObserverA();
		sujet.addObserver(obsA);
		
		Observateur obsB = new ConcreteObserverB();
		sujet.addObserver(obsB);
		
		//Test apr�s inscription des observateurs
		System.out.println("\nTest apr�s inscription des observateurs: ");
		
		sujet.evenement(); //Doit afficher "Emission evenement..."
						   //              "ConcreteObserverA a re�u un evenement."
		                   //              "ConcreteObserverB a re�u un evenement."
		
	}

	
	
}
