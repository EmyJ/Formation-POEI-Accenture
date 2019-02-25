package fr.eni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version GestionLivre - V1.0
 * @date 21 févr. 2019 - 14:14:02
 */
public class DAOUtil {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
	emf = Persistence.createEntityManagerFactory("Mysql_UP");
	em = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
	return em;
    }

    public static void close() {
	if (em != null) {
	    em.close();
	}
	if (emf != null) {
	    emf.close();
	}
    }
}
