package fr.resaLogement.bdd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.resaLogement.beans.Adresse;

public class AdresseBDD {
	
	public ArrayList<Adresse> getAdresses() {
		ArrayList<Adresse> adresses = new ArrayList<Adresse>();
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM adresse";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Adresse adresse = new Adresse();
				
				adresse.setIdAdresse(resultat.getInt(1));
				adresse.setNumRue(resultat.getString(2));
				adresse.setNomRue(resultat.getString(3));
				adresse.setCodePostal(resultat.getString(4));
				adresse.setVille(resultat.getString(5));
				
				adresses.add(adresse);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adresses;
	}

	public Adresse getAdresse(int id) {
		Adresse adresse = null;				
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM adresse WHERE idAdresse = " + id;
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				adresse = new Adresse();
				
				adresse.setIdAdresse(resultat.getInt(1));
				adresse.setNumRue(resultat.getString(2));
				adresse.setNomRue(resultat.getString(3));
				adresse.setCodePostal(resultat.getString(4));
				adresse.setVille(resultat.getString(5));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adresse;
	}
	
	public void setAdresse(String numRue,String nomRue, String codePostal, String ville) {
			
			try {
				ConnexionBDD connexionBDD = new ConnexionBDD();
				Statement stmt = connexionBDD.seConnecter();
				
				String maRequete = "INSERT INTO adresse(numRue, nomRue, codePostal, ville) VALUES('" + numRue +"', '" + nomRue + "', '" + codePostal + "', '"  + ville + "');";
				
				int resultat = stmt.executeUpdate(maRequete);
				System.out.println(resultat);
				
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int retournerIdAdresseCree() {
		
		int id = 0;
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT MAX(idAdresse) FROM adresse;";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				id=resultat.getInt(1);
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public ArrayList<Adresse> listerVilles() {
		ArrayList<Adresse> lesVilles = new ArrayList<Adresse>();
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "select distinct ville from adresse join logement on adresse.idAdresse = logement.adresse_idAdresse order by ville;";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Adresse ville = new Adresse();
				
				ville.setVille(resultat.getString(1));
				lesVilles.add(ville);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lesVilles;
	}
	
}

