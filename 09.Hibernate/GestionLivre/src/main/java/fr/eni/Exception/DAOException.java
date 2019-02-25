package fr.eni.Exception;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version GestionLivre - V1.0
 * @date 21 févr. 2019 - 14:14:14
 */
public class DAOException extends Exception{

    private static final long serialVersionUID = 1L;

    public DAOException(String msg) {
	super(msg);
    }
}
