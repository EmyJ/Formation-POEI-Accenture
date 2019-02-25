/**
 * 
 */
package fr.eni.editeur.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bmartin
 *
 */
public class Commande {
    private Date dateCde;

    //attributs d'association
    private Client client; 	// relation 1..1 vers Client (unidirectionnelle)
    private Livre[] livres; // relation 1..* vers Livre (unidirectionnelle)

    //variables de gestion du tableau de Livres
    private int position = 0;
    private final int MAX = 10;

    public Client getClient() {
    	return client;
    }
    public void setClient(Client client) throws Exception {
        if (client == null)
            throw new Exception("La référence a un client est obligatoire !");
        this.client = client;
    }


    public double getMontant() {
        double montant = 0;
        for (Livre livre : livres) {
            if (livre != null)
                montant += livre.getPrix();
            else
                break;
		}
        return montant;
    }

    
    /**
     * surcharge du constructeur (respecter la règle 1 client, 1 livre au minimum)
     * @param client
     * @param livre
     * @throws Exception 
     */
    public Commande(Client client, Livre livre) throws Exception {
        //stocker la ref. du client
        this.client = client;
        //stocker la ref. du livre dans les livres commandés
        livres = new Livre[MAX];
        Add(livre);
        //dater la commande
        dateCde = new Date();
    }


    /**
     * Ajouter un livre à la commande dans la limite du tableau
     * @param livre
     * @throws Exception 
     */
    public void Add(Livre livre) throws Exception {
        if (livre == null)
            throw new Exception("Une ref. de livre est attendue !");

        if (position < MAX) {
            livres[position] = livre;
            position++;
        } else
            throw new Exception(
                String.format("La commande est complète ! Le livre %s n'a pas été ajouté à la commande !",
                livre.getTitre()));
    }

 
    /**
     * Génerer le bon de commande
     * @return
     * @throws Exception 
     */
    public String GetCommandeToString() throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String bon = String.format("Client : %s \nCommande : %s\nDétail :\n",
                        client.GetClientToString(),
                        sdf.format(dateCde));
        for (Livre livre : livres) {
            if (livre != null)
                bon += String.format("%s\n", livre.GetLivreToString());
            else
                break;
		}
        bon += String.format("Montant : %6.2f", this.getMontant());
        return bon;
    }
}
