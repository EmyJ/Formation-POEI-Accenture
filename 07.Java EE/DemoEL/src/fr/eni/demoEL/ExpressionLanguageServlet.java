package fr.eni.demoEL;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demoEL")
public class ExpressionLanguageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		if(random.nextBoolean()){
			Voiture voiture = new Voiture("RENAULT","ZOE","AA123BB",5236);
			request.setAttribute("voiture", voiture);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ExpressionLanguage.jsp");
		rd.forward(request, response);

	}
	
}
