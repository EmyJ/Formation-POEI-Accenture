package observer;

public class ConcreteObserverA implements Observateur{

	@Override
	public void update() {
		System.out.println("ConcreteObserverA a re�u un evenement.");
	}

}
