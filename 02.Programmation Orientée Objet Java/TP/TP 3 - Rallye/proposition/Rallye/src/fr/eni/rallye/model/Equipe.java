/**
 * 
 */
package fr.eni.rallye.model;

/**
 * @author bmartin
 *
 */
public class Equipe {
	private String nom;
	private String nationalite;
	private Boolean constructeur;
	
	private Equipage[] equipages;
	private int equipageIndex = 0;
	/**
	 * @param nom
	 * @param nationalite
	 * @param constructeur
	 */
	public Equipe(String nom, String nationalite, Boolean constructeur) {
		this.nom = nom;
		this.nationalite = nationalite;
		this.constructeur = constructeur;
		
		equipages = new Equipage[3];
	}
	
	public void ajouterEquipage(Equipage equipage) throws IndexOutOfBoundsException{
		equipages[equipageIndex] = equipage;
		equipageIndex++;
	}

	public String infosEquipe() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String
				.format("Equipe [nom=%s, nationalite=%s, constructeur=%s]\n",
						nom, nationalite, constructeur));
		for (Equipage equipage : equipages) {
			if (equipage !=null){
				buffer.append(String.format("\t%s", equipage.infosEquipage()));
			}
		}
		return buffer.toString();
	}
	
	public Equipage getEquipage(int dossard){
		Equipage find = null;
		for (Equipage equipage : equipages) {
			if (equipage != null && equipage.getDossard()==dossard){
				find = equipage;
				break;
			}
		}
		return find;
	}
	
	
}
