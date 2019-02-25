/**
 * 
 */
package fr.eni.centreculturel.model;

/**
 * @author bmartin
 *
 */
public class Catalogue {
	private int indexCatalogue = 0;
	private Produit[] produits;

	/**
	 * 
	 */
	public Catalogue() {
		super();
		produits = new Produit[50];
	}
	
	public void add(Produit produit) throws ArrayIndexOutOfBoundsException{
		//on ne s'occupe pas ici des potentiels doublons dans le catalogue.....
		produits[indexCatalogue] = produit;
		indexCatalogue++;
	}
	
	public Produit get(int index) throws ArrayIndexOutOfBoundsException {
		return produits[index];
	}
	
	public Produit[] extract(){
		return produits;
	}
	
	public Produit[] extract(Produit sample){
		Produit[] extrait = null;
		int index = 0;
		if (sample==null) return null;
		for (Produit produit : produits) {
			if (produit == null) break;
			if (produit.getClass().equals(sample.getClass())){
				if (extrait==null) extrait = new Produit[50];
				extrait[index] = produit;
				index++;
			}
		}
		return extrait;
	}
	
	
	//en s'appuyant sur les génériques (abordés plus tard dans le cours)
	public <T extends Produit> Produit[] extract(Class<T> type){
		Produit[] extrait = null;
		int index = 0;
		
		if (type==null) return null;
		//instancier un objet de type T afin de connaitre son type réel
		//On ne connait la nature d'un type générique qu'après génération du byte code
		Type<T> t = new Type<T>(type);
		
		for (Produit produit : produits) {
			if (produit == null) break;
			if (produit.getClass().equals(t.getType())){
				if (extrait==null) extrait = new Produit[50];
				extrait[index] = produit;
				index++;
			}
		}
		return extrait;
	}
	
	//classe permettant de récupérer le type associé au parametre generique
	private class Type<T>{
		private Class<T> type;
		public Type(Class<T> type){
			this.type = type;
		}
		public Class<T> getType() {
			return type;
		}
	}
	
}
