
public class Test {

	public static void main(String[] args) {
		Voiture v = new Voiture("Mercedes", "A", "verte", 152153);
		
		Voiture v2 = new Voiture("Mercedes", "B", "rouge");
		
		
		v.setMarque("Renault");
		
		
		System.out.println(v2.getMarque() + " " + v2.getModele());
		
		v2.Demarrer();
		
		
		
		

	}

}

