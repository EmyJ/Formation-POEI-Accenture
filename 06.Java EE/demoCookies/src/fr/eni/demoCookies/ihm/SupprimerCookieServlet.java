package fr.eni.demoCookies.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/supprimerCookie")
public class SupprimerCookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();
		
		Cookie ck = new Cookie("monCookie", "");
		ck.setMaxAge(0);		
		resp.addCookie(ck);
		
		resp.setContentType("text/html");
		out.println("<p>monCookie supprimé</p>");
		out.close();

	}

		
}
