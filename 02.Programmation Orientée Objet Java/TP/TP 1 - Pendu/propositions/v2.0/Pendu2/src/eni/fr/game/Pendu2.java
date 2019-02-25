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
	
    //on d�finit quelques r�gles importantes pour le jeu...
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
		
        //d�finir les variables de stockage 
        char[] MotMystereTab;
        char[] MotAfficheTab;

        //TODO Maintenance �volutive : prise en charge de la gestion des exceptions
        //*************************************************************************
        try
        {
	        //saisir le mot mystere ou r�cuperer un mot mystere dans le dictionnaire
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
	
	        //afficher le mot masqu�
	        Afficher(MotAfficheTab);
	
	        //traiter les caract�res saisis
	        int CptErreur = 0;
	        CptErreur = Jouer(MotMystereTab, MotAfficheTab);
	
	        //fin du jeu, exprimer le résultat
	        if (CptErreur == 5)
	        {
	            System.out.println("Perdu !");
	            Afficher(MotMystereTab);
	        }
	        else
	        	System.out.println("Gagn� !");
	
	        System.out.println("Appuyez sur entr�e pour terminer le jeu...");
	        saisie.nextLine();
        }
        catch (Exception e)
        {
        	System.out.println("Erreur grave : Arret du Jeu");
        	System.out.println("appuyez sur entr�e pour sortir....");
        	saisie.nextLine();
        }
	}
	
    //ici, on g�re la partie en cours
    private static int Jouer(char[] MotMystereTab, char[] MotAfficheTab)
    {
        int CptErreur = 0;
        
        //TODO Maintenance �volutive : affichage du pendu
        AfficherPendu(CptErreur);

        do
        {
            //drapeau indiquant si le caract�re saisi fait parti du mot
            //mystere
            Boolean trouve = false;

            char caractere;
            System.out.print("votre lettre : ");
            caractere = saisie.nextLine().charAt(0);
            //rechercher le caract�re dans le motMystere
            for (int i = 0; i < MotMystereTab.length; i++)
            {
                //TODO Maintenance �volutive : affiner la comparaison des caracrt�res (Maj/Min, caract�res accentu�s)
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

            //afficher le mot masqu�
            Afficher(MotAfficheTab);
            
            //TODO Maintenance �volutive : affichage du pendu
            AfficherPendu(CptErreur);
            
        } while (CptErreur < 5 & !aGagne(MotMystereTab, MotAfficheTab));
        return CptErreur;
    }

    //comparer les deux tableaux et exprimer si le joueur � gagner
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
        
        //TODO Maintenance �volutive : le mot myst�re est piocher dans un dictionnaire
        //****************************************************************************
        String motAlea = null;
        int nbMots = 22739;
        //selection al�atoire d'un indice
        Random r = new Random();
        int indice = r.nextInt(nbMots);
        //Ouverture du fichier ou sont stock�s les mots
        BufferedReader buff=null;
        try{
			InputStream flux=new FileInputStream(FICHIER_MOTS); 
			InputStreamReader lecture=new InputStreamReader(flux);
			buff=new BufferedReader(lecture);
			String ligne;
			int position = 0;
            //On se d�place dans le dictionnaire jusqu'au n� de ligne tir� au sort
			while ((ligne=buff.readLine())!=null & position < indice){
				motAlea = ligne;
				position++;
			}
		}		
		catch (Exception e){
            //En cas de probl�me d'acc�s au fichier
            System.out.println("Probl�me de lecture du fichier !");
            System.out.println("Appuyez sur une touche pour continuer...");
            //on propage l'erreur, arret du jeu si pas de mot myst�re...
            throw e;
        }
        finally
        {
            //Dans tous les cas, on ferme le flux vers le fichier
            if (buff != null)
            	buff.close();
        }
        //retour de ce tableau de caract�re contenant un mot choisi al�atoirement dans la liste
        //de mots
		return motAlea.toCharArray();
		
    }
    
    //afficher le mot cach� et son �tat d'avancement
    private static void Afficher(char[] MotAfficheTab)
    {
        for (char item : MotAfficheTab)
        {
            switch (item)
            {
                case '�':
                	System.out.print("ae");
                    break;
                case '�':
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
    // TODO Maintenance �volutive : prise en charge de l'affichage du pendu
    // Affiche un dessin d'un pendu plus ou moins avanc� en fonction du nombre d'erreurs commises
    private static void AfficherPendu(int nbErreurs)
    {
    	System.out.println("nombre erreurs : " + nbErreurs + "/" + NB_MAX_ERREURS);
        //Premi�re ligne
        if (nbErreurs < 2)
        	System.out.println();
        else
        	System.out.println("   _____");
        //Deuxi�me ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 1)
        	System.out.print("/");
        if (nbErreurs > 2)
        	System.out.print("  |");
        System.out.println();
        //Troisi�me ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 2)
        	System.out.print("   o");
        System.out.println();
        //Quatri�me ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 3)
        	System.out.print("  /X\\");
        System.out.println();
        //Cinqui�me ligne
        if (nbErreurs > 0)
        	System.out.print("   |");
        if (nbErreurs > 4)
        	System.out.print("  / \\");
        System.out.println();
        //Sixi�me ligne
        if (nbErreurs == 0)
        	System.out.print("_____________");
        else
        	System.out.print("___|_________");
        System.out.println();
    }


    // TODO Maintenance �volutive : prise en compte des caract�res sp�ciaux
    // Cette m�thode retourne le caract�re sans accents, tr�ma ou c�dille et s�pare les oe en oe
    // et les ae en ae
    private static String CaracSimple(char carac)
    {
        String ret;
        switch (carac)
        {
            case '�':
            case '�':
                ret = "a";
                break;
            case '�':
                ret = "c";
                break;
            case '�':
            case '�':
            case '�':
            case '�':
                ret = "e";
                break;
            case '�':
            case '�':
                ret = "i";
                break;
            case '�':
                ret = "o";
                break;
            case '�':
            case '�':
            case '�':
                ret = "u";
                break;
            case '�':
                ret = "ae";
                break;
            case '�':
                ret = "oe";
                break;
            default:
                ret = String.valueOf(carac);
                break;
        }
        return ret;
    }
    

}
