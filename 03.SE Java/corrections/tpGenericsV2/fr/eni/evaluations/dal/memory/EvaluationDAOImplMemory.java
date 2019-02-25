package fr.eni.evaluations.dal.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.evaluations.bo.Evaluation;
import fr.eni.evaluations.dal.DAO;

public class EvaluationDAOImplMemory implements DAO<Evaluation> {


	private int max_no_evaluation = 1;
	private Map<Integer, Evaluation> evaluations = new HashMap<>(); 
	
	@Override
	public void insert(Evaluation data) throws Exception {
		max_no_evaluation++;
		evaluations.put(max_no_evaluation, data);

	}

	@Override
	public void update(Evaluation data) throws Exception {
		Evaluation e = evaluations.get(data.getNoEvaluation());
		e.setNom(data.getNom());
		e.setDuree(data.getDuree());
	}

	@Override
	public void delete(Evaluation data) throws Exception {
		evaluations.remove(data.getNoEvaluation());

	}

	@Override
	public Evaluation selectById(int id) throws Exception {
		return evaluations.get(id);
	}

	@Override
	public List<Evaluation> selectAll() throws Exception {
		List<Evaluation> evaluations = new ArrayList<>(this.evaluations.values());
		return evaluations;
	}

}
