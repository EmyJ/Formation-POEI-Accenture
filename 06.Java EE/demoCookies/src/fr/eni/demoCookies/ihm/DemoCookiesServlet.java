package fr.eni.demoCookies.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/creerCookie")
public class DemoCookiesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		PrintWriter out =resp.getWriter();

		resp.setContentType("text/html");
		Cookie ck = new Cookie("monCookie", "ma_valeur");
		System.out.println("age = " + ck.getMaxAge());
		resp.addCookie(ck);
		out.println("<h1>COOKIE monCookie créé !</h1>");
		out.close();
	}
	
}
