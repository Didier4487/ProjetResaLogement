package fr.resaLogement.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.resaLogement.bdd.TypeLogementBDD;
import fr.resaLogement.beans.TypeLogement;

@SuppressWarnings("serial")
public class ValiderModifTypeLogement extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		TypeLogementBDD typeLogementBDD = new TypeLogementBDD();
		
		String action = request.getParameter("action");
		String typeLogement = request.getParameter("typeLogement");
		String descriptionType = request.getParameter("descriptionType");
		String idInit = request.getParameter("idTypeLogement");
		
		int id = Integer.parseInt(idInit);
		
		if (action.equals("m")) {
			typeLogementBDD.modifierLogement(id, typeLogement, descriptionType);
		}else{
			typeLogementBDD.supprimerLogement(id);
		}
		
		ArrayList<TypeLogement> lesTypeLogement = typeLogementBDD.getAllTypeLogement();
		request.setAttribute("lestypeslogements", lesTypeLogement);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/typeLogement.jsp").forward(request, response);
		
	}
}
