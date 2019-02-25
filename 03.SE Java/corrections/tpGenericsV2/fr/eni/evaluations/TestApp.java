package fr.eni.evaluations;

import java.util.List;

import fr.eni.evaluations.bo.EpreuveOrale;
import fr.eni.evaluations.bo.Evaluation;
import fr.eni.evaluations.bo.Promotion;
import fr.eni.evaluations.bo.QCM;
import fr.eni.evaluations.bo.Stagiaire;
import fr.eni.evaluations.dal.DAO;
import fr.eni.evaluations.dal.memory.EvaluationDAOImplMemory;
import fr.eni.evaluations.dal.memory.PromotionDAOImplMemory;
import fr.eni.evaluations.dal.memory.StagiaireDAOImplMemory;

public class TestApp {

	public static void main(String[] args) {
		DAO<Stagiaire> dao1 = new StagiaireDAOImplMemory();
		//StagiaireDAO dao = new StagiaireDAOImplMemory();
		Stagiaire s1 = null;
		
		for(int i=1;i<=10;i++){
			s1 = new Stagiaire("p"+i, "n"+i, "e"+i, "mp"+i);
			try {
				dao1.insert(s1);
			} catch (Exception ex) {
				ex.printStackTrace();
				ex.getMessage();
			}
		}
		List<Stagiaire> lesStagiaires = null;
		try {
			lesStagiaires = dao1.selectAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		for(Stagiaire s: lesStagiaires){
			System.out.println(s);
		}
		
		/****************Evaluation**********************************************/
		System.out.println("/****************************Evaluations*******************************/");
		DAO<Evaluation> evaluations = new EvaluationDAOImplMemory();
		Evaluation e1 = null;
		Evaluation e2 = null;
		Evaluation e3 = null;
		Evaluation e4 = null;
		Evaluation e5 = null;
		
		
		e1 = new QCM(1,"QCMenJava", 1, 20);
		e2 = new QCM(2,"QCMenAlgo", 1, 20);
		e3 = new QCM(3,"QCMenSQL", 1, 20);
		e4 = new EpreuveOrale(4,"OrauxAnglais", 1);
		e5 = new EpreuveOrale(5,"orauxProjet", 1);
		
			try {
				evaluations.insert(e1);
				evaluations.insert(e2);
				evaluations.insert(e3);
				evaluations.insert(e4);
				evaluations.insert(e5);
			} catch (Exception ex) {
				ex.printStackTrace();
				ex.getMessage();
			}
		
		List<Evaluation> lesEvaluations = null;
		try {
			lesEvaluations = evaluations.selectAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		for(Evaluation e: lesEvaluations){
			System.out.println(e);
		}
		
		
		/**************Promotion******************/
		System.out.println("/****************************Promotions*******************************/");
		DAO<Promotion> promotions = new PromotionDAOImplMemory();
		
		Promotion p1 = null;
		Promotion p2 = null;
		Promotion p3 = null;
		
		p1 = new Promotion(1,"POEC1");
		p2 = new Promotion(2,"DL1");
		p3 = new Promotion(3,"CDI1");
		
		try {
			promotions.insert(p1);
			promotions.insert(p2);
			//promotions.insert(p3);
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
	
		List<Promotion> lesPromotions = null;
		try {
			lesPromotions = promotions.selectAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		for(Promotion p: lesPromotions){
			System.out.println(p);
		}
		
	}

}
