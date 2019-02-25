
public class TestComportment {

	public static void main(String[] args) {

		Cheval tornado = new Cheval();
		tornado.communiquer();
		tornado.dormir();
		tornado.galoper();

		Humain zorro = new Humain();
		zorro.communiquer();
		zorro.dormir();
		zorro.siffler();

		// DECOMMENTER POUR LA QUESTION 6
		Oiseau titi = new Oiseau();
		titi.siffler();
		titi.communiquer();
		titi.dormir();

		Animal anonyme1 = tornado;
		// Anonyme1.communiquer();
		Animal anonyme2 = zorro;
		// Anonyme2.communiquer();

		Humain inconnu = (Humain) anonyme2;
		inconnu.siffler();
		Centaure c = new Centaure();
		c.communiquer();
		c.siffler();
		c.galoper();

	}

}
