package fr.resaLogement.bdd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.resaLogement.beans.Proprietaire;

public class ProprietaireBDD {

	public ArrayList<Proprietaire> getProprietaires() {
		
		ArrayList<Proprietaire> proprietaires = new ArrayList<Proprietaire>();

		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM proprietaire";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				Proprietaire proprietaire = new Proprietaire();
				
				proprietaire.setIdProprietaire(resultat.getInt(1));
				proprietaire.setNom(resultat.getString(2));
				proprietaire.setPrenom(resultat.getString(3));		
				
				proprietaire.setTelephone(convertirTelephone(resultat.getString(4)));
				proprietaire.setEmail(resultat.getString(5));
				
				proprietaires.add(proprietaire);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proprietaires;
	}
	

	public Proprietaire getProprietaire(int id) {
		Proprietaire proprietaire = null;
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM proprietaire WHERE idProprietaire = " + id;
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				proprietaire = new Proprietaire();
				
				proprietaire.setIdProprietaire(resultat.getInt(1));
				proprietaire.setNom(resultat.getString(2));
				proprietaire.setPrenom(resultat.getString(3));
				proprietaire.setTelephone(resultat.getString(4));
				proprietaire.setEmail(resultat.getString(5));
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proprietaire;
	}
	
	
	public void setProprietaire(String nom,String prenom, String telephone, String email) {
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "INSERT INTO proprietaire(nom, prenom, telephone, email) VALUES('";
			maRequete += nom +"', '" + prenom +"', '" + telephone + "', '"  + email + "');";
			
			stmt.executeUpdate(maRequete);
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String convertirTelephone(String telephone) {
		
		telephone = telephone.substring(0,2) + "." + telephone.substring(2,4) + "." + telephone.substring(4, 6) + "." + telephone.substring(6, 8) + "." + telephone.substring(8, 10);	
		return telephone;
	}
}

