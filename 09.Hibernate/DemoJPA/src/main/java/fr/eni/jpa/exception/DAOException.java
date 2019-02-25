package fr.eni.jpa.exception;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 15:57:42
 */
public class DAOException extends Exception{

    private static final long serialVersionUID = 1L;

    public DAOException(String msg) {
	super(msg);
    }
}
