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
public class InsererTypeLogement extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		TypeLogementBDD typeLogementBDD = new TypeLogementBDD();
				
		ArrayList<TypeLogement> lesTypeLogement = typeLogementBDD.getAllTypeLogement();
		
		request.setAttribute("lestypeslogements", lesTypeLogement);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/typeLogement.jsp").forward(request, response);
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		TypeLogementBDD typeLogementBDD = new TypeLogementBDD();
		
		String typeLogement = request.getParameter("typeLogement");
		String descriptionType = request.getParameter("descriptionType");
		
		System.out.println(typeLogement +  " " + descriptionType);
		
		if (typeLogement.length()>1){
			typeLogementBDD.setTypeLogement(typeLogement, descriptionType);			
		}
		
		ArrayList<TypeLogement> lesTypeLogement = typeLogementBDD.getAllTypeLogement();
		request.setAttribute("lestypeslogements", lesTypeLogement);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/typeLogement.jsp").forward(request, response);
		
	}
}
