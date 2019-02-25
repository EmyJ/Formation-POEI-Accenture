package fr.eni.demoServlet01.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/executeMaServlet")
public class MaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Dans la console*/
		System.out.println("Dans le doGet de MaServelt !!!!!");
		
		System.out.println("Protocole : " + request.getScheme());
		System.out.println("Serveur : " + request.getServerName());
		System.out.println("Port : " + request.getServerPort());
		System.out.println("Nom de l'application : " + request.getContextPath());
		System.out.println("Chemin : " + request.getServletPath());
		
		
		/*Sur le navigateur*/
//		PrintWriter pw = response.getWriter();
//		pw.write("Dans le doGet de MaServelt !!!!!");
		
		/*Sur le navigateur depuis une page HTML*/
//		RequestDispatcher view = request.getRequestDispatcher("pages/hello.html");
//		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("nom : " + req.getParameter("nom"));
		System.out.println("prenom : " + req.getParameter("prenom"));
	}
}
