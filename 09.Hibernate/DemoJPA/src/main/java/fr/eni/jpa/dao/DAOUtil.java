package fr.eni.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 13:34:05
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
