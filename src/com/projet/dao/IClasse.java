package com.projet.dao;

import com.projet.entities.Classe;

import javafx.collections.ObservableList;

public interface IClasse {

	public int add(Classe cl);
	public int delete(int idC);
	public int update(Classe cl);
	public ObservableList<Classe> listeClasse();
	public Classe getClasseById(int idC);
}
