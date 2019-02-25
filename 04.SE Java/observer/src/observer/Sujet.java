package observer;

import java.util.ArrayList;
import java.util.List;

public class Sujet {

	private List<Observateur> ObserverCollection = new ArrayList<>();

	public void evenement() {
		System.out.println("Emission evenement...");
		notifyObservers();
	}

	public void registerObserver(Observateur observer) {
		ObserverCollection.add(observer);
	}

	public void removeObservers(Observateur observer) {
		ObserverCollection.remove(observer);
	}

	public void notifyObservers() {
		for (Observateur observer : ObserverCollection) {
			observer.update();
		}
	}

	public void addObserver(Observateur observer) {
		registerObserver(observer);
	}
}
