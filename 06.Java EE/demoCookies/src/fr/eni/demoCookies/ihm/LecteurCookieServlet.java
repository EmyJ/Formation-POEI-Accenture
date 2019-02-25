package fr.eni.demoCookies.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecteurCookies")
public class LecteurCookieServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		PrintWriter out =resp.getWriter();
		
		resp.setContentType("text/html");
		for(Cookie ck: cookies) {
			if(ck.getName().equals("monCookie")) {
				//Traitement du cookie
			}
			out.println("<p>" + ck.getName() + " : " + ck.getValue() + "</p>");
		}
		out.close();
	
	}

}
