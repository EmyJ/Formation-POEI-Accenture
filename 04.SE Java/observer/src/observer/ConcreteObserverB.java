package observer;

public class ConcreteObserverB implements Observateur  {

	@Override
	public void update() {
		System.out.println("ConcreteObserverB a reçu l'evenement.");
	}

}
