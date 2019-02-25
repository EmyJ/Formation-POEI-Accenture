package fr.eni.TPSuiviDesRepas.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repas {

	private int idRepas;
	private Date date;
	private List<Aliment> aliments = new ArrayList<>();

	public Repas() {
		
	}
	
	public Repas(Date date, List<Aliment> aliments) {
		this.date = date;
		this.aliments = aliments;
	}
	
	public int getIdRepas() {
		return idRepas;
	}

	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Aliment> getAliments() {
		return aliments;
	}

	public void setAliments(List<Aliment> aliments) {
		this.aliments = aliments;
	}

	@Override
	public String toString() {
		return "Repas [idRepas=" + idRepas + ", date=" + date + ", aliments=" + aliments + "]";
	}
	
}
