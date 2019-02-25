package fr.eni.jpa.service;

import java.util.List;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.dao.GenericDao;
import fr.eni.jpa.dao.GenericDaoImpl;

public class GestionFilm {

	GenericDao<Film, Integer> dao;
	
	public GestionFilm(){
		dao = new GenericDaoImpl<>();
	}
	
	public List<Film> listeFilms(){
		return dao.findAll(Film.class);
	}
	
	public Film trouverFilm(int id){
		return dao.findById(Film.class, id);
	}
	
	
	public void ajoutFilm(Film f) throws Exception{
		dao.add(f);
	}
	
	public void modifierFilm(Film f) throws Exception{
		dao.update(f);
	}
	
	public void supprimerFilm(Film f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerFilm(int id) throws Exception{
		dao.delete(trouverFilm(id));
	}

	public List<Film> trier(String par) {
		List<Film> liste = null;
		
		switch (par) {
		default : liste = dao.findAll(Film.class);

		}
		
		return liste;
	}
	
	
	
}
