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

@SuppressWarnings("serial")
public class RechercheLogements extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		
		AdresseBDD adresseBDD = new AdresseBDD();
		DisponibiliteBDD disponibiliteBDD = new DisponibiliteBDD();
		
		String ville = "";
		
		ArrayList<Adresse> lesVilles = adresseBDD.listerVilles();
		Adresse adresse = null;
		if (lesVilles.size() > 0) {
			adresse = (Adresse) lesVilles.get(0);
			ville = adresse.getVille();
		}
		
		request.setAttribute("villeLogement", ville);
		request.setAttribute("lesVilles", lesVilles);
		request.setAttribute("lesDisponibilites", disponibiliteBDD.getDisponibilites(ville));

		this.getServletContext().getRequestDispatcher("/jsp/rechercher.jsp").forward(request, response);
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		LogementBDD logementBDD = new LogementBDD();
		AdresseBDD adresseBDD = new AdresseBDD();
		DisponibiliteBDD disponibiliteBDD = new DisponibiliteBDD();
		
		String ville = request.getParameter("ville");
		String dateDispo = request.getParameter("dateDispo");
		String idDispo = request.getParameter("choix");
		
		if(idDispo != null) {
			int convertIdDispo = Integer.parseInt(idDispo);
			disponibiliteBDD.reserverLogement(convertIdDispo);
			request.setAttribute("logements", logementBDD.getLogementsComplets(ville,dateDispo));
		}
		
		request.setAttribute("villeLogement", ville);
		
		if (dateDispo != null) {
			request.setAttribute("logements", logementBDD.getLogementsComplets(ville,dateDispo));
			request.setAttribute("laDateDispo", dateDispo);
			System.out.println("date dispo Ok");
		}
		
		request.setAttribute("lesVilles", adresseBDD.listerVilles());
		request.setAttribute("lesDisponibilites", disponibiliteBDD.getDisponibilites(ville));

		this.getServletContext().getRequestDispatcher("/jsp/rechercher.jsp").forward(request, response);
		
	}
}
