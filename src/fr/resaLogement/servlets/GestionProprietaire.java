package fr.resaLogement.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.resaLogement.bdd.ProprietaireBDD;
import fr.resaLogement.beans.Proprietaire;

@SuppressWarnings("serial")
public class GestionProprietaire extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		ProprietaireBDD proprietaireBDD = new ProprietaireBDD();
				
		ArrayList<Proprietaire> proprietaires = proprietaireBDD.getProprietaires();
		
		request.setAttribute("proprietaires", proprietaires);

		this.getServletContext().getRequestDispatcher("/jsp/proprietaire.jsp").forward(request, response);
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			
		ProprietaireBDD proprietaireBDD = new ProprietaireBDD();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		proprietaireBDD.setProprietaire(nom, prenom, telephone, email);
		
		request.setAttribute("proprietaires", proprietaireBDD.getProprietaires());

		this.getServletContext().getRequestDispatcher("/jsp/proprietaire.jsp").forward(request, response);
		
	}
}
