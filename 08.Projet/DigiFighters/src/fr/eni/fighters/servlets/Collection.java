package fr.eni.fighters.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bll.CarteMger;
import fr.eni.fighters.bll.UserMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.User;

/**
 * Servlet pour gérer la collection et le paquet
 */
@WebServlet("/private/collection")
public class Collection extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    UserMger userMger = UserMger.getUSerMger();
    CarteMger carteMger = CarteMger.getCarteMger();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	// Je lis les paramètres cocher, pas cocher
	cocherDecocher(request, response);
	int idUser = userCourant.getId();
	try {

	    List<Carte> collection = carteMger.selectAll(userCourant.getId());
	    session.setAttribute("listeCarte", collection);
	    session.setAttribute("id_user", idUser);
	} catch (BusinessException e) {
	    e.printStackTrace();
	    e.getMessage();
	}
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/collection.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    /******************************************************************************
     *			Méthode Private
     *******************************************************************************/

    /**
     * 
     * Méthode en charge modifier en base de donnee la valeur cocher, pas cocher
     * @param request
     * @param response
     */
    private void cocherDecocher(HttpServletRequest request, HttpServletResponse response) {
	if (request.getParameter("id_carte") != null) {
	    try {
		int idCarte = Integer.parseInt(request.getParameter("id_carte"));
		if (request.getParameter("coche") != null) {
		    carteMger.cocherCarte(idCarte);
		} else {
		    carteMger.decocherCarte(idCarte);
		}
	    } catch (BusinessException e) {
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    }
	} else if (request.getParameter("clear") != null) {
	    try {
		int idUser = Integer.parseInt(request.getParameter("id_user"));
		carteMger.decocherToutLesCartes(idUser);
	    } catch (BusinessException e) {
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    }
	}

    }
}
