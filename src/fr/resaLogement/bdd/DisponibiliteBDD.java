package fr.resaLogement.bdd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.resaLogement.beans.Disponibilite;

public class DisponibiliteBDD {
	
	public ArrayList<Disponibilite> getDisponibilites(String ville) {
		ArrayList<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
		
		try {			
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();						
			
			String maRequete =  "SELECT DISTINCT disponibilite.dateDispo, disponibilite.disponibilite, proprietaire.nom, "
											+ "proprietaire.prenom, adresse.numRue, adresse.nomRue, adresse.codePostal, "
											+ "adresse.ville, logement.description "
											+ "FROM disponibilite "
											+ "JOIN logement "
											+ "ON disponibilite.logement_idLogement = logement.idLogement "
											+ "JOIN adresse "
											+ "ON adresse.idAdresse = logement.adresse_IdAdresse "
											+ "JOIN proprietaire "
											+ "ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire "
											+ "WHERE disponibilite.disponibilite = false AND adresse.ville = '" + ville + "';";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Disponibilite disponibilite = new Disponibilite();
					
				disponibilite.setDateDispo(resultat.getString(1));
				disponibilite.setDisponibilite(resultat.getString(2));
				
				disponibilites.add(disponibilite);								
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return disponibilites;
	}
	
	public ArrayList<Disponibilite> getDateDisponibilites(String ville) {
		ArrayList<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
		
		try {			
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();						
			
			String maRequete =  "SELECT DISTINCT dateDispo "
											+ "FROM disponibilite "
											+ "JOIN logement "
											+ "ON disponibilite.logement_idLogement = logement.idLogement "
											+ "JOIN adresse "
											+ "ON adresse.idAdresse = logement.adresse_IdAdresse "
											+ "JOIN proprietaire "
											+ "ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire "
											+ "WHERE disponibilite = false AND adresse.ville = '" + ville + "'"
											+ "ORDER BY dateDispo;";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Disponibilite disponibilite = new Disponibilite();
					
				disponibilite.setDateDispo(resultat.getString(1));
				
				disponibilites.add(disponibilite);								
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return disponibilites;
	}
	
	public void reserverLogement(int idDispo) {

		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "UPDATE disponibilite SET disponibilite = 1 WHERE idDisponibilite = " + idDispo + ";";
				
			stmt.executeUpdate(maRequete);				
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void creerPlanning(int idLogement) {

		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
					
			for (int i = 1; i < 32; i++) {
				String jour = "" + i;
				if (jour.length() == 1) {
					jour = "0" + i;
				}
				String maRequete = "INSERT INTO disponibilite (dateDispo, disponibilite, logement_idLogement) VALUES('2017/07/" + jour +"', false, " + idLogement + ");";
				
				stmt.executeUpdate(maRequete);
		
			}		
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Disponibilite> getDisponibilitesLogement(String ville, String description) {
		ArrayList<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
		
		try {			
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();						
			
			String maRequete =  "SELECT DISTINCT disponibilite.dateDispo, disponibilite.disponibilite "
											+ " FROM disponibilite "
											+ " JOIN logement ON disponibilite.logement_idLogement = logement.idLogement "
											+ " JOIN adresse ON adresse.idAdresse = logement.adresse_IdAdresse "
											+ " JOIN proprietaire ON proprietaire.idProprietaire = logement.proprietaire_idProprietaire "
											+ " WHERE logement.description = '" + description + "' AND adresse.ville = '" + ville + "';";
			ResultSet resultat = stmt.executeQuery(maRequete);
						
			while (resultat.next()) {
				Disponibilite disponibilite = new Disponibilite();
				
				disponibilite.setDateDispo(resultat.getString(1));
				if (resultat.getString(2).contentEquals("0")) {
					disponibilite.setDisponibilite("DISPONIBLE");
				}else{
					disponibilite.setDisponibilite("XXXXXXXXXX");
				}
				
				disponibilites.add(disponibilite);								
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return disponibilites;
	}
	
}

