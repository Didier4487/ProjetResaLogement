package fr.resaLogement.bdd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.resaLogement.beans.TypeLogement;

public class TypeLogementBDD {

	public ArrayList<TypeLogement> getAllTypeLogement() {
		
		ArrayList<TypeLogement> lesTypesLogements = new ArrayList<TypeLogement>();

		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM typelogement";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				TypeLogement unTypeLogement = new TypeLogement();
				
				unTypeLogement .setIdTypeLogement(resultat.getInt(1));
				unTypeLogement.setTypeLogement(resultat.getString(2));
				unTypeLogement.setDescriptionType(resultat.getString(3));		
				
				lesTypesLogements.add(unTypeLogement);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lesTypesLogements;
	}
	
public TypeLogement getOneTypeLogement(int id) {
		
		TypeLogement leTypeLogement = new TypeLogement();
		
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();
			Statement stmt = connexionBDD.seConnecter();
			
			String maRequete = "SELECT * FROM typelogement";
			
			ResultSet resultat = stmt.executeQuery(maRequete);
			
			while (resultat.next()) {
				
				if (id == resultat.getInt(1)) {
					leTypeLogement .setIdTypeLogement(resultat.getInt(1));
					leTypeLogement.setTypeLogement(resultat.getString(2));
					leTypeLogement.setDescriptionType(resultat.getString(3));				
					
					System.out.println(resultat.getInt(1) + resultat.getString(2) + resultat.getString(3));
				}
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return leTypeLogement;
	}

public void modifierLogement(int id,String typeLogement, String descriptionType) {
	
	try {
		ConnexionBDD connexionBDD = new ConnexionBDD();
		Statement stmt = connexionBDD.seConnecter();
		
		String maRequete = "UPDATE typelogement SET typeLogement = '" + typeLogement + "', descriptionType = '" + descriptionType + "' "
				+ "WHERE idTypeLogement = " + id + ";"; 
		
		stmt.executeUpdate(maRequete);
		stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
	
	public void setTypeLogement(String typeLogement,String descriptionType) {
			
			try {
				ConnexionBDD connexionBDD = new ConnexionBDD();
				Statement stmt = connexionBDD.seConnecter();
				
				String maRequete = "INSERT INTO typelogement(typeLogement, descriptionType)"
											+ " VALUES('" + typeLogement +"', '" + descriptionType +"');";
				
				stmt.executeUpdate(maRequete);
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}

