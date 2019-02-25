package eni.fr.game;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author 
 *
 */
public class Pendu {

	//Variables globales : Compteur d'erreur et scanner saisie
	static int CptErreur = 0;
	
	private static Scanner saisie;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//variable de saisie
		saisie = new Scanner(System.in);
		
        //définir les variables de stockage 
        char[] MotMystereTab;
        char[] MotAfficheTab;

        //saisir le mot mystere
        MotMystereTab = SaisieMotMystere();

        //Initialiser le motAfficheTab (On cache les caractères sauf '-', ''', ' ')
        MotAfficheTab = new char[MotMystereTab.length];
        for (int i = 0; i < MotAfficheTab.length; i++)
        {
            if (MotMystereTab[i] == '-' || MotMystereTab[i] == '\''
                || MotMystereTab[i] == ' ')
                MotAfficheTab[i] = MotMystereTab[i];
            else
                MotAfficheTab[i] = '_';
        }

        //afficher le mot masqué
        Afficher(MotAfficheTab);

        //traiter les caractères saisis
        //int CptErreur = 0;
        CptErreur = Jouer(MotMystereTab, MotAfficheTab);

        //fin du jeu, exprimer le résultat
        if (CptErreur == 5)
        {
            System.out.println("Perdu !");
            Afficher(MotMystereTab);
        }
        else
        	System.out.println("Gagné !");

        System.out.println("Appuyez sur entrée pour terminer le jeu...");
        saisie.nextLine();


	}
	
    //ici, on gère la partie en cours
    private static int Jouer(char[] MotMystereTab, char[] MotAfficheTab)
    {
        //int CptErreur = 0;
        do
        {
            //drapeau indiquant si le caractère saisi fait parti du mot
            //mystere
            Boolean trouve = false;

            char caractere;
            System.out.print("votre lettre : ");
            caractere = saisie.nextLine().charAt(0);
            //rechercher le caractère dans le motMystere
            for (int i = 0; i < MotMystereTab.length; i++)
            {
                if (MotMystereTab[i] == caractere)
                {
                    MotAfficheTab[i] = MotMystereTab[i];
                    trouve = true;
                }
            }
            if (!trouve)
                CptErreur++;

            //Console.Clear();
            //afficher les vies
            System.out.println(String.format("%d/5 erreur(s)", CptErreur));

            //afficher le mot masqué
            Afficher(MotAfficheTab);
        } while (CptErreur < 5 & !aGagne(MotMystereTab, MotAfficheTab));
        return CptErreur;
    }

    //comparer les deux tableaux et exprimer si le joueur à  gagner
    private static Boolean aGagne(char[] MotMystereTab, char[] MotAfficheTab)
    {
        for (int i = 0; i < MotMystereTab.length; i++)
        {
            if (MotMystereTab[i] != MotAfficheTab[i])
                return false;
        }
        return true;
    }

    //fournir un mot mystere au jeu
    private static char[] SaisieMotMystere()
    {
        System.out.println("Saisir le mot à découvrir :");
        String MotMystere = saisie.nextLine();
        //transformer la chaine en tableau de char
        return MotMystere.toCharArray();
    }

    //afficher le mot caché et son état d'avancement
    private static void Afficher(char[] MotAfficheTab)
    {
    	//Utilisation du foreach
    	for (char c : MotAfficheTab) {
    		System.out.print(c + " ");
		}
    	
    	//ou
    	
    	//Utilisation boucle for
//        for(int i = 0; i < MotAfficheTab.length; i++){
//        	System.out.print(MotAfficheTab[i] + " ");
//        }
        System.out.println();
    }
    
//	private static String recupMot(){
//		try{
//			InputStream flux=new FileInputStream("test.txt"); 
//			InputStreamReader lecture=new InputStreamReader(flux);
//			BufferedReader buff=new BufferedReader(lecture);
//			String ligne;
//			while ((ligne=buff.readLine())!=null){
//				System.out.println(ligne);
//			}
//			buff.close(); 
//			}		
//			catch (Exception e){
//			System.out.println(e.toString());
//			}
//	}

}
