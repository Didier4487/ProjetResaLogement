package fr.resaLogement.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.resaLogement.bdd.AdresseBDD;
import fr.resaLogement.bdd.DisponibiliteBDD;
import fr.resaLogement.bdd.LogementBDD;
import fr.resaLogement.beans.Adresse;
import fr.resaLogement.beans.Logement;

@SuppressWarnings("serial")
public class AfficherPlanning extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		AdresseBDD adresseBDD = new AdresseBDD();
		DisponibiliteBDD disponibiliteBDD = new DisponibiliteBDD();
		LogementBDD logementBDD = new LogementBDD();
		
		String ville = "";
		String laDescription = "";
		
		ArrayList<Adresse> lesVilles = adresseBDD.listerVilles();
		Adresse adresse = null;
		if (lesVilles.size() > 0) {
			adresse = (Adresse) lesVilles.get(0);
			ville = adresse.getVille();
		}
		
		ArrayList<Logement> lesLogements = logementBDD.getLogementsVille(ville);
		Logement logement = null;
		
		if (lesLogements.size() > 0) {
			logement = (Logement) lesLogements.get(0);
			laDescription = logement.getDescription();
		}
		
		request.setAttribute("villeLogement", ville);
		request.setAttribute("descriptionLogement", laDescription);
		request.setAttribute("lesLogements", lesLogements);
		request.setAttribute("lesVilles", lesVilles);
		request.setAttribute("lesDisponibilites", disponibiliteBDD.getDisponibilites(ville));

		this.getServletContext().getRequestDispatcher("/jsp/planning.jsp").forward(request, response);
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		LogementBDD logementBDD = new LogementBDD();
		AdresseBDD adresseBDD = new AdresseBDD();
		DisponibiliteBDD disponibiliteBDD = new DisponibiliteBDD();
		
		String ville = request.getParameter("ville");
		String logement = request.getParameter("logement");
		
		request.setAttribute("descriptionLogement", logement);
		request.setAttribute("villeLogement", ville);
		request.setAttribute("lesLogements", logementBDD.getLogementsVille(ville));
		request.setAttribute("lesVilles", adresseBDD.listerVilles());
		request.setAttribute("lesDisponibilites", disponibiliteBDD.getDisponibilitesLogement(ville, logement));

		this.getServletContext().getRequestDispatcher("/jsp/planning.jsp").forward(request, response);
		
	}
}
