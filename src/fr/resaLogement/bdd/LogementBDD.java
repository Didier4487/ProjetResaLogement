package fr.resaLogement.bdd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.resaLogement.beans.Adresse;
import fr.resaLogement.beans.Logement;
import fr.resaLogement.beans.Proprietaire;

public class LogementBDD {
	
	public ArrayList<Logement> getLogementsComplets(String ville, String dateDispo) {
		ArrayList<Logement> logements = new ArrayList<Logement>();
		
		try {			
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
									
			String maRequete =  "SELECT nom, prenom, description, numRue, nomRue, codePostal, ville, dateDispo, idDisponibilite, disponibilite FROM proprietaire ";
			maRequete += "JOIN logement ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire ";
			maRequete += "JOIN adresse ON adresse.idAdresse = logement.adresse_IdAdresse ";
			maRequete += "JOIN disponibilite ON disponibilite.logement_idLogement = logement.idLogement ";
			maRequete += "WHERE ville = '" + ville + "' AND disponibilite = " + false + " AND dateDispo = '" + dateDispo + "';";						
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Logement logement = new Logement();
				
					Proprietaire proprietaire = new Proprietaire();
					
					proprietaire.setNom(resultat.getString(1));
					proprietaire.setPrenom(resultat.getString(2));
										
				logement.setProprietaire(proprietaire);				
				logement.setDescription(resultat.getString(3));
				
					Adresse adresse = new Adresse();
					
					adresse.setNumRue(resultat.getString(4));
					adresse.setNomRue(resultat.getString(5));
					adresse.setCodePostal(resultat.getString(6));
					adresse.setVille(resultat.getString(7));
				
				logement.setAdresse(adresse);
				logement.setDateDispo(dateDispo);
				logement.setIdDisponibilite(resultat.getInt(9));
				logement.setDisponibilite(resultat.getBoolean(10));								
				
				logements.add(logement);
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logements;
	}
	
	public ArrayList<Logement> getLogements() {
		ArrayList<Logement> logements = new ArrayList<Logement>();

		try {	
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete =  "SELECT nom, prenom, description, numRue, nomRue, codePostal, ville ";
			maRequete += " FROM proprietaire JOIN logement ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire";
			maRequete += "  JOIN adresse ON adresse.idAdresse = logement.adresse_IdAdresse;";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Logement logement = new Logement();
				
				logement.setPrenomNom(resultat.getString(2) + " " + resultat.getString(1));
				logement.setDescription(resultat.getString(3));
				logement.setAdresseComplete(resultat.getString(4) + " " + resultat.getString(5));
				logement.setVille(resultat.getString(7));
				
				logements.add(logement);
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logements;
	}

	public Logement getLogement(int id) {
		Logement logement = null;
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM logement WHERE idLogement = " + id;
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				logement = new Logement();
				
				logement.setIdLogement(resultat.getInt(1));
				logement.setDescription(resultat.getString(2));
				logement.setProprietaire_idProprietaire(resultat.getInt(3));
				logement.setAdresse_idAdresse(resultat.getInt(4));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logement;
	}
	
	public void setLogement(String description, int idProprietaire, int idAdresse) {

		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "INSERT INTO logement(description, proprietaire_idProprietaire, adresse_idAdresse) VALUES('" + description +"', '" + idProprietaire + "', '" + idAdresse + "');";
			
			stmt.executeUpdate(maRequete);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int retournerIdLogementCree() {
		
		int id = 0;
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT MAX(idLogement) FROM logement;";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				id = resultat.getInt(1);
			}	
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<Logement> getLogementsVille(String ville) {
		ArrayList<Logement> logements = new ArrayList<Logement>();

		try {	
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete =  "SELECT nom, prenom, description, numRue, nomRue, codePostal, ville ";
			maRequete += " FROM proprietaire JOIN logement ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire";
			maRequete += "  JOIN adresse ON adresse.idAdresse = logement.adresse_IdAdresse ";
			maRequete += " WHERE ville = '" + ville + "';";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Logement logement = new Logement();
				
				logement.setPrenomNom(resultat.getString(2) + " " + resultat.getString(1));
				logement.setDescription(resultat.getString(3));
				logement.setAdresseComplete(resultat.getString(4) + " " + resultat.getString(5));
				logement.setVille(resultat.getString(7));
				
				logements.add(logement);
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logements;
	}
	
}

