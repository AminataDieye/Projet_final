package com.projet.entities;

public class Classe {

	private int idC;
	private String nomC;


	public int getIdC() {
		return idC;
	}
	public String getNomC() {
		return nomC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}

	@Override
	public String toString(){
		return this.nomC;
	}

}
