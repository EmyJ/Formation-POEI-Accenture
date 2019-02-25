package editeur;

public class TestLivre {

	public static void main(String[] args) {
		
		 Livre monLivre = new Livre("Le monde merveilleux",2,(long)3);
		 monLivre.setAnnee(2012);
		 Individu ama =new Individu("Aurélien","Martineau");
		 monLivre.setAuteur(ama);
		 monLivre.setPrix(12.5f);
		 System.out.println(monLivre);
		 Livre livreb =new Livre(monLivre);
		 livreb.setIsbn((long)2);
		 livreb.setAuteur(new Individu("Noémie","Martineau"));
		 System.out.println(livreb);
		 //2) Créer le code du programme principal qui crée l'individu Stephen Hawking, puis crée un livre qui
		 // a pour titre Petite Histoire de l'Univers qui contient 162 pages.
		 Individu sh =new Individu("Stephen","Hawking");
		 Livre livrec =new Livre("Petite histoire de l'univers",162,9782352888062l);
		 livrec.setAuteur(sh);
		 System.out.println(livrec);
	}


}
