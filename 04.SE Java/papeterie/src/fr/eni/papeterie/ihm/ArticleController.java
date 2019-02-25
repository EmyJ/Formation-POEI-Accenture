package fr.eni.papeterie.ihm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController {
	
	private EcranArticle ecrArticle ;
	
	private static Logger loggerArticleController = LoggerFactory.getLogger("fr.eni.papeterie.ihm.ArticleController"); 
	
	//Attributs
	private int indexCatalogue;
	
	private CatalogueManager mger;
	
	private List<Article> catalogue;
	
	private static ArticleController instance;
	
	//Constructeur
	private ArticleController(){
		try {
			mger = new CatalogueManager();
			
			//Initialisation du catalogue en mémoire
			catalogue = mger.getCatalogue();
			
			
		} catch (BLLException e) {
			loggerArticleController.error(e.getMessage());
		}
	}
	
	//Méthodes
	public static synchronized ArticleController get(){
		if(instance == null){
			instance = new ArticleController();
		}
		return instance;
	}
	
	public void startApp(){
		ecrArticle = new EcranArticle();
		
		afficherPremierArticle();
		ecrArticle.setVisible(true);
	}
	
	public void afficherPremierArticle(){
		if(catalogue.size()>0){
			indexCatalogue = 0;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}else{
			indexCatalogue = -1;
			ecrArticle.afficherNouveau();
		}

	}

	public void precedent(){
		if(indexCatalogue > 0){
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}
		
	}

	public void suivant() {
		if(indexCatalogue < catalogue.size()-1){
			indexCatalogue++;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}

	}

	public void nouveau() {
		indexCatalogue = catalogue.size();
		ecrArticle.afficherNouveau();
		
	}

	public void enregistrer() {
		Article articleAffiche = ecrArticle.getArticle();
		
		try {
			if(articleAffiche.getIdArticle()==null){
				mger.addArticle(articleAffiche);
				System.out.println("article: " + articleAffiche);
				catalogue.add(articleAffiche);
				ecrArticle.afficherArticle(articleAffiche);
			}else{
				mger.updateArticle( articleAffiche);
				catalogue.set(indexCatalogue, articleAffiche);
			}
		} catch (BLLException | NumberFormatException e1) {
			ecrArticle.infoErreur("Erreur : Les champs sont obligatoire.");
			loggerArticleController.error(e1.getMessage());
		}
		
	}

	public void supprimer() {
		
		try {
			mger.removeArticle(catalogue.get(indexCatalogue));
			catalogue.remove(indexCatalogue);
		} catch (BLLException e) {
			ecrArticle.infoErreur("Erreur suppression.");
			loggerArticleController.error(e.getMessage());
		}		

		if (indexCatalogue < catalogue.size() ) {
			// Afficher l'article suivant
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else if (indexCatalogue > 0) {
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			ecrArticle.afficherNouveau();
		}
		
	}


}
