package fr.eni.TPSuiviDesRepas.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TPSuiviDesRepas.bll.RepasMger;
import fr.eni.TPSuiviDesRepas.bo.Aliment;
import fr.eni.TPSuiviDesRepas.bo.Repas;
import fr.eni.TPSuiviDesRepas.bll.BLLException;


@WebServlet("/ajoutRepas")
public class ajoutRepasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ajoutRepasServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/Ajout.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("add").equals("stop")) {
            request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
		}
		
        Repas r = new Repas();
        
        String dat = request.getParameter("date");
        String tim = request.getParameter("time");
        String dattim = dat +" "+ tim;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            r.setDate(sdf.parse(dattim));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
       System.out.println(r.getDate());
       
       List <Aliment> aliment = new ArrayList<>();
       String alim = request.getParameter("aliment");
       String[] tabalim = alim.trim().split(",");
       for (String elment:tabalim) {
       		aliment.add(new Aliment(elment));
       }
       r.setAliments(aliment);
       RepasMger repasMger = new RepasMger();
		try {
			repasMger.ajouterRepas(r);
		} catch (BLLException e) {
			e.printStackTrace();
		}
       
        
	}
}
