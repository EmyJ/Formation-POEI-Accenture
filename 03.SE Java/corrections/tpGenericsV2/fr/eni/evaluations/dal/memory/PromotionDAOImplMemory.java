package fr.eni.evaluations.dal.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.evaluations.bo.Promotion;
import fr.eni.evaluations.dal.DAO;

public class PromotionDAOImplMemory implements DAO<Promotion> {


	private int max_no_promotion = 1;
	private Map<Integer, Promotion> promotions = new HashMap<>(); 
	
	@Override
	public void insert(Promotion data) throws Exception {
		max_no_promotion++;
		promotions.put(max_no_promotion, data);

	}

	@Override
	public void update(Promotion data) throws Exception {
		Promotion p = promotions.get(data.getNoPromo());
		p.setNomPromo(data.getNomPromo());
	}

	@Override
	public void delete(Promotion data) throws Exception {
		promotions.remove(data.getNoPromo());

	}

	@Override
	public Promotion selectById(int id) throws Exception {
		return promotions.get(id);
	}

	@Override
	public List<Promotion> selectAll() throws Exception {
		List<Promotion> promotions = new ArrayList<>(this.promotions.values());
		return promotions;
	}

}
