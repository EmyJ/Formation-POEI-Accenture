package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;


public class GestionStyle {

	private GenericDao<Style, Integer> dao;
	
	public GestionStyle(){
		dao = new GenericDaoImpl<>();
	}
	
	public List<Style> listeStyles(){
		return dao.findAll(Style.class);
	}
	
	
	public Style trouverStyle(int id){
		return dao.findById(Style.class, id);
	}

	public void ajoutStyle(Style s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new Exception("...");
	}
	
	public void modifierStyle(Style s) throws Exception{
		dao.update(s);
	}
	
	public void supprimerStyle(Style s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		Style s = dao.findById(Style.class, id);
		dao.delete(s);
	}
	
	public List<Style> trier(String type){
		List<Style> liste = null;
		switch (type){
		default : liste = dao.findAll(Style.class);
		}
		return liste;
	}
	
}
