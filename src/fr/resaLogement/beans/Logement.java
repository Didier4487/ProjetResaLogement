package fr.resaLogement.beans;

public class Logement {
	
	private int idLogement;
	private String description;
	private int proprietaire_idProprietaire;
	private int adresse_idAdresse;
	private Adresse adresse;
	private Proprietaire proprietaire;
	private String dateDispo;
	private int idDisponibilite;
	private Boolean disponibilite;
	private String prenomNom;
	private String adresseComplete;
	private String ville;

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresseComplete() {
		return adresseComplete;
	}
	public void setAdresseComplete(String adresseComplete) {
		this.adresseComplete = adresseComplete;
	}
	
	public String getPrenomNom() {
		return prenomNom;
	}
	public void setPrenomNom(String prenomNom) {
		this.prenomNom = prenomNom;
	}
	
	public Boolean getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
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
	public int getIdLogement() {
		return idLogement;
	}
	public void setIdLogement(int idLogement) {
		this.idLogement = idLogement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProprietaire_idProprietaire() {
		return proprietaire_idProprietaire;
	}
	public void setProprietaire_idProprietaire(int proprietaire_idProprietaire) {
		this.proprietaire_idProprietaire = proprietaire_idProprietaire;
	}
	public int getAdresse_idAdresse() {
		return adresse_idAdresse;
	}
	public void setAdresse_idAdresse(int adresse_idAdresse) {
		this.adresse_idAdresse = adresse_idAdresse;
	}	
	
}
