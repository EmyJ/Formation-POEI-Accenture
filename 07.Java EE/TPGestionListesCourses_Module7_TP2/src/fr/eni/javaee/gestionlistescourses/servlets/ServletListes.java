package fr.eni.javaee.gestionlistescourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.gestionlistescourses.BusinessException;
import fr.eni.javaee.gestionlistescourses.bll.ListeCourseManager;
import fr.eni.javaee.gestionlistescourses.bo.ListeCourse;
import fr.eni.javaee.gestionlistescourses.messages.LecteurMessage;


@WebServlet("/listes")
public class ServletListes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListeCourseManager listeCourseManager = new ListeCourseManager();
	
		try {
			request.setAttribute("listesCourse", listeCourseManager.selectionnerListes());
		} catch (BusinessException be) {
			be.printStackTrace();
			request.setAttribute("listeCodesErreur", be.getListeCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listes.jsp");
		rd.forward(request, response);
	}

}

