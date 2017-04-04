package fr.resaLogement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.resaLogement.bdd.AdresseBDD;
import fr.resaLogement.bdd.DisponibiliteBDD;
import fr.resaLogement.bdd.LogementBDD;
import fr.resaLogement.bdd.ProprietaireBDD;

@SuppressWarnings("serial")
public class GestionLogement extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		
		LogementBDD logementBDD = new LogementBDD();
		ProprietaireBDD proprietaireBDD = new ProprietaireBDD();
		
		request.setAttribute("logements", logementBDD.getLogements());
		request.setAttribute("proprietaires", proprietaireBDD.getProprietaires());

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/logement.jsp").forward(request, response);
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
						
		LogementBDD logementBDD = new LogementBDD();
		AdresseBDD adresseBDD = new AdresseBDD();
		DisponibiliteBDD disponibiliteBDD = new DisponibiliteBDD();
		ProprietaireBDD proprietaireBDD = new ProprietaireBDD();
		
		String description = request.getParameter("description");
		String idProprietaire = request.getParameter("idProprietaire");
	
		String numRue = request.getParameter("numRue");
		String nomRue = request.getParameter("nomRue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		adresseBDD.setAdresse(numRue, nomRue, codePostal, ville);
	
		int convIdProprietaire = Integer.parseInt(idProprietaire);
		int idAdresse = adresseBDD.retournerIdAdresseCree();
		
		logementBDD.setLogement(description,convIdProprietaire,idAdresse);
		
		int idLogement = logementBDD.retournerIdLogementCree();
		
		disponibiliteBDD.creerPlanning(idLogement);
		
		request.setAttribute("logements", logementBDD.getLogements());
		request.setAttribute("proprietaires", proprietaireBDD.getProprietaires());

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/logement.jsp").forward(request, response);
			
		}
	}
