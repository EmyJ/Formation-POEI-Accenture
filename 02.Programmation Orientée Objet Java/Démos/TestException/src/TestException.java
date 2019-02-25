
public class TestException {

	public static void main(String[] args) {
		
		//declencheException();
		
		//gererException();
		
		try {
			propagerException();
		}catch (Exception e) {
			System.out.println("Traitement de l'exception de Main " + e.getMessage());
		}
		
		
		System.out.println("Fin de la méthode Main");

	}

	private static void propagerException() throws Exception{
		System.out.println("Début de propagerException");
		
		try {
			declencheException();
			System.out.println("Fin de propagerException");
		}catch (Exception e) {
			System.out.println("Traitement de Exception de propagerException");
			
			//Création Exception
			Exception ex = new Exception("Nouvel objet Exception de propagerException");
			throw ex;
			
			//ou
			//throw new Exception("Nouvel objet Exception de propagerException");
			
		}finally {
			System.out.println("Traitement final (finally)de propagerException");
		}
		
	}

	private static void gererException() {
		System.out.println("Debut de gererException");
		try {
			declencheException();
			System.out.println("Fin de gererException");
		}catch (Exception e){
			System.out.println("Traitement de l'Exception de gererException : L'erreur est de ...");
		}finally {
			//Code qui sera exécuté obligatoirement avant la sortie de la méthode
			//Qu'une erreur ait été levée ou non
			System.out.println("Traitement finally de la méthode gererException");
		}
		
	}

	private static void declencheException() {
		String s = null;
		s.concat("chaine");
		System.out.println("Fin de méthode declencheException");
		
	}

}
