package fr.eni.papeterie.bo;


public abstract class Article {
	//Attributs d'instance
	private Integer idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;
	private int version=1;

	//Constructeur
	public Article(){
		
	}
	
	public Article( Integer idArticle, String marque, String ref, String designation, float pu, int qte, int version)  {
		this(  marque, ref, designation, pu, qte, version);
		setIdArticle(idArticle);

	}

	
	public Article( String marque, String ref, String designation, float pu, int qte, int version)  {
		
		setMarque(marque);
		setReference(ref);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setQteStock(qte);
		setVersion(version);

	}
	

	//Getters et Setters
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference)  {
		this.reference = reference;
	}

	/// *MARQUE*///
	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque)  {

		this.marque = marque;
	}

	/// *DESIGNATION*///
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation)  {

		this.designation = designation;

	}

	/// *PRIX UNITAIRE*///
	/**
	 * @return the prixUnitaire
	 */
	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	/**
	 * @param prixUnitaire
	 *            the prixUnitaire to set
	 */
	public void setPrixUnitaire(float prixUnitaire)  {
		this.prixUnitaire = prixUnitaire;

	}

	/// *QUANTITE STOCK*///
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * @param qteStock
	 *            the qteStock to set
	 */
	public void setQteStock(int qteStock) {

		this.qteStock = qteStock;
	}


	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [idArticle="+ idArticle +", reference=" + reference + ", marque=" + marque + ", designation=" + designation
				+ ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]";
	}


}
