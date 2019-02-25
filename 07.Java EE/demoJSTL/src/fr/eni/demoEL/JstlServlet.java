package fr.eni.demoEL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demoJstl")
public class JstlServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		if(random.nextBoolean())
		{
			Voiture voiture = new Voiture("RENAULT","ZOE","AA123BB",5236);
			request.setAttribute("voiture", voiture);
		}
		
		List<Voiture> voitures = new ArrayList<>();
		voitures.add(new Voiture("AUDI","RS6","AZ456QS",46634));
		voitures.add(new Voiture("MERCEDES","CLASSE C","ER789DF",5319));
		voitures.add(new Voiture("PEUGEOT","308","CV345TY",134567));
		
		request.setAttribute("voitures", voitures);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageBalisesJSTL.jsp");
		rd.forward(request, response);

		
	}
	
}
