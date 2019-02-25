package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {
	
	void insert(Article a) throws DALException;
	Article selectById(int id) throws DALException;
	List<Article> selectAll() throws DALException;
	void update(Article a) throws DALException;
	void delete(int id) throws DALException;

}
