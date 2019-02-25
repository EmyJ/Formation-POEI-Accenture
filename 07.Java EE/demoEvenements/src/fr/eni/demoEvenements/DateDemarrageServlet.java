package fr.eni.demoEvenements;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dateDemarrage")
public class DateDemarrageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		out.println("La date du dernier démarrage est le : ");
		out.println(req.getServletContext().getAttribute("demarrage"));
		//out.println(sdf.format(ListenerDemarrageArret.getDateDemarrage()));
		out.close();
	
	}

}
