package fr.eni.TPSuiviDesRepas.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TPSuiviDesRepas.bll.BLLException;
import fr.eni.TPSuiviDesRepas.bll.RepasMger;
import fr.eni.TPSuiviDesRepas.bo.Repas;

@WebServlet("/historiqueRepas")
public class visualisationRepasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("dateFiltre")!=null && !request.getParameter("dateFiltre").equals("")) {
			SimpleDateFormat formater = null;
			formater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			System.out.println(formater.format(request.getParameter("dateFiltre")));
		}
		
	
		RepasMger repasManager = new RepasMger();
		List<Repas> listeRepas=null;
		try {
			listeRepas = repasManager.selectionRepas();
			
			System.out.println(listeRepas);
			request.setAttribute("listeRepas", listeRepas);
			
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/pages/Historique.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
