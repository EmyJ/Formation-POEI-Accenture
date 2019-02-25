package eni.fr.game;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author bmartin
 *
 */
public class Pendu {

	private static Scanner saisie;
	
    //on définit quelques règles importantes pour le jeu...
    private static final int NB_MAX_ERREURS = 5;

    private static final char CARAC_VISIBLE_TIRET = '-';
    private static final char CARAC_VISIBLE_APO = '\'';
    private static final char CARAC_VISIBLE_BLANC = ' ';
    private static final char CARAC_VISIBLE_INCONNU = '_';

    //l'emplacement du dictionnaire
    private static final String FICHIER_MOTS = "dictionnaire.txt";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//variable de saisie
		saisie = new Scanner(System.in);
		
        //définir les variables de stockage 
        char[] MotMystereTab;
        char[] MotAfficheTab;

        //TODO Maintenance évolutive : prise en charge de la gestion des exceptions
        //*************************************************************************
        try
        {
	        //saisir le mot mystere ou récuperer un mot mystere dans le dictionnaire
	        MotMystereTab = SaisieMotMystere();
	
	        //Initialiser le motAfficheTab
	        MotAfficheTab = new char[MotMystereTab.length];
	        for (int i = 0; i < MotAfficheTab.length; i++)
	        {
	            if (MotMystereTab[i] == CARAC_VISIBLE_TIRET || MotMystereTab[i] == CARAC_VISIBLE_APO
	                || MotMystereTab[i] == CARAC_VISIBLE_BLANC)
	                MotAfficheTab[i] = MotMystereTab[i];
	            else
	                MotAfficheTab[i] = CARAC_VISIBLE_INCONNU;
	        }
	
	        //afficher le mot masqué
	        Afficher(MotAfficheTab);
	
	        //traiter les caractères saisis
	        int CptErreur = 0;
	        CptErreur = Jouer(MotMystereTab, MotAfficheTab);
	
	        //fin du jeu, exprimer le rÃ©sultat
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
        catch (Exception e)
        {
        	System.out.println("Erreur grave : Arret du Jeu");
        	System.out.println("appuyez sur entrée pour sortir....");
        	saisie.nextLine();
        }
	}
	
    //ici, on gère la partie en cours
    private static int Jouer(char[] MotMystereTab, char[] MotAfficheTab)
    {
        int CptErreur = 0;
        
        //TODO Maintenance évolutive : affichage du pendu
        AfficherPendu(CptErreur);

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
                //TODO Maintenance évolutive : affiner la comparaison des caracrtères (Maj/Min, caractères accentués)
                if (CaracSimple(Character.toLowerCase(MotMystereTab[i])).equals(CaracSimple(Character.toLowerCase(caractere))))
                {
                    MotAfficheTab[i] = MotMystereTab[i];
                    trouve = true;
                    
                }
            }
            if (!trouve)
                CptErreur++;

            //Console.Clear();
            //afficher les vies
            //System.out.println(String.format("%d/5 erreur(s)", CptErreur));

            //afficher le mot masqué
            Afficher(MotAfficheTab);
            
            //TODO Maintenance évolutive : affichage du pendu
            AfficherPendu(CptErreur);
            
        } while (CptErreur < 5 & !aGagne(MotMystereTab, MotAfficheTab));
        return CptErreur;
    }

    //comparer les deux tableaux et exprimer si le joueur à gagner
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
    private static char[] SaisieMotMystere() throws Exception
    {
        
        //TODO Maintenance évolutive : le mot mystère est piocher dans un dictionnaire
        //****************************************************************************
        String motAlea = null;
        int nbMots = 22739;
        //selection aléatoire d'un indice
        Random r = new Random();
        int indice = r.nextInt(nbMots);
        //Ouverture du fichier ou sont stockés les mots
        BufferedReader buff=null;
        try{
			InputStream flux=new FileInputStream(FICHIER_MOTS); 
			InputStreamReader lecture=new InputStreamReader(flux);
			buff=new BufferedReader(lecture);
			String ligne;
			int position = 0;
            //On se déplace dans le dictionnaire jusqu'au n° de ligne tiré au sort
			while ((ligne=buff.readLine())!=null & position < indice){
				motAlea = ligne;
				position++;
			}
		}		
		catch (Exception e){
            //En cas de problème d'accès au fichier
            System.out.println("Problème de lecture du fichier !");
            System.out.println("Appuyez sur une touche pour continuer...");
            //on propage l'erreur, arret du jeu si pas de mot mystère...
            throw e;
        }
        finally
        {
            //Dans tous les cas, on ferme le flux vers le fichier
            if (buff != null)
            	buff.close();
        }
        //retour de ce tableau de caractère contenant un mot choisi aléatoirement dans la liste
        //de mots
		return motAlea.toCharArray();
		
    }
    
    //afficher le mot caché et son état d'avancement
    private static void Afficher(char[] MotAfficheTab)
    {
        for (char item : MotAfficheTab)
        {
            switch (item)
            {
                case 'æ':
                	System.out.print("ae");
                    break;
                case 'œ':
                	System.out.print("oe");
                    break;
                default:
                	System.out.print(String.format("%s ", item));
                    break;
            }
        }
        System.out.println();
    }

    /***
     * 
     * @param nbErreurs
     */
    // TODO Maintenance évolutive : prise en charge de l'affichage du pendu
    // Affiche un dessin d'un pendu plus ou moins avancé en fonction du nombre d'erreurs commises
    private static void AfficherPendu(int nbErreurs)
    {
    	System.out.println("nombre erreurs : " + nbErreurs + "/" + NB_MAX_ERREURS);
        //Première ligne
        if (nbErreurs < 2)
        	System.out.println();
        else
        	System.out.println("   _____");
        //Deuxième ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 1)
        	System.out.print("/");
        if (nbErreurs > 2)
        	System.out.print("  |");
        System.out.println();
        //Troisième ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 2)
        	System.out.print("   o");
        System.out.println();
        //Quatrième ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 3)
        	System.out.print("  /X\\");
        System.out.println();
        //Cinquième ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 4)
        	System.out.print("  / \\");
        System.out.println();
        //Sixième ligne
        if (nbErreurs == 0)
        	System.out.print("_____________");
        else
        	System.out.print("___|_________");
        System.out.println();
    }


    // TODO Maintenance évolutive : prise en compte des caractères spéciaux
    // Cette méthode retourne le caractère sans accents, tréma ou cédille et sépare les oe en oe
    // et les ae en ae
    private static String CaracSimple(char carac)
    {
        String ret;
        switch (carac)
        {
            case 'à':
            case 'â':
                ret = "a";
                break;
            case 'ç':
                ret = "c";
                break;
            case 'é':
            case 'è':
            case 'ê':
            case 'ë':
                ret = "e";
                break;
            case 'î':
            case 'ï':
                ret = "i";
                break;
            case 'ô':
                ret = "o";
                break;
            case 'û':
            case 'ù':
            case 'ü':
                ret = "u";
                break;
            case 'æ':
                ret = "ae";
                break;
            case 'œ':
                ret = "oe";
                break;
            default:
                ret = String.valueOf(carac);
                break;
        }
        return ret;
    }
    

}
