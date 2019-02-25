/**
 * 
 */
package fr.eni.fighters.dal;

import java.util.List;

import fr.eni.fighters.bo.User;

/**
 * Interface pour l'implémentation des utilisateurs
 * @author agrimonp2018
 * @date 11 févr. 2019
 */
public interface UserDAO {
	public void insert(User user) throws DALException;
	public List<User> selectAll() throws DALException;
	public void delete(int id) throws DALException;
	public User selectById(int id) throws DALException;
	public void update(User user) throws DALException;
	
}
