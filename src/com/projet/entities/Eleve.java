package com.projet.entities;

public class Eleve {

	private int id;
	private String nom, prenom;
	private Classe idC;

	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}

	public Classe getIdC() {
		return idC;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setIdC(Classe idC) {
		this.idC = idC;
	}


}
