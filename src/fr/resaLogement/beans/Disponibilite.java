package fr.resaLogement.beans;

public class Disponibilite {
	
	private int idDisponibilite;
	private String dateDispo;
	private String disponibilite;
	private String logement_idLogement;
	private Adresse adresse;
	private Proprietaire proprietaire;
	private Logement logement;
	
	public Logement getLogement() {
		return logement;
	}
	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public int getIdDisponibilite() {
		return idDisponibilite;
	}
	public void setIdDisponibilite(int idDisponibilite) {
		this.idDisponibilite = idDisponibilite;
	}
	public String getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(String dateDispo) {
		this.dateDispo = dateDispo;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getLogement_idLogement() {
		return logement_idLogement;
	}
	public void setLogement_idLogement(String logement_idLogement) {
		this.logement_idLogement = logement_idLogement;
	}
			
}
