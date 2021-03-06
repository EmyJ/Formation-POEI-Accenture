package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

public class AppliTestDAL {

	public static void main(String[] args) {

		//D�claration et instanciation de la DAO
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		//ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl();

		//Instanciation du jeu d'essai 
		Article a1 = new Stylo("Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette("Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo("Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");

		try {
			System.out.println("Ajout des articles... ");
			articleDAO.insert(a1);
			System.out.println("Article ajout�  : " + a1.toString() );
			articleDAO.insert(a2);
			System.out.println("Article ajout�  : " + a2.toString() );
			articleDAO.insert(a3);
			System.out.println("Article ajout�  : " + a3.toString() );


			//S�lection de l'article par id
			Article a = articleDAO.selectById(a2.getIdArticle());
			System.out.println("\nS�lection de l'article par id  : " + a.toString() );

			//Selection de tous les articles
			List<Article> articles = articleDAO.selectAll();
			System.out.println("\nS�lection de tous les articles  : "  );
			afficherArticles(articles);

			//Modification d'un article
			System.out.println("\nModification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			articleDAO.update(a1);
			System.out.println("Article apr�s modification  : " + a1.toString() );
			
			
			//Suppression d'un article
			System.out.println("\nSuppression de l'article  : " + a1.toString());
			articleDAO.delete(a1.getIdArticle());
			articles = articleDAO.selectAll();
			System.out.println("Liste des articles apr�s suppression : "  );
			afficherArticles(articles);
			System.out.println("---------------------------------------------------------------");

			
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	
	private static void afficherArticles(List<Article> articles){
		StringBuffer sb = new StringBuffer();
		for(Article art: articles){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
