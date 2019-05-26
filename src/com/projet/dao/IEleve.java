package com.projet.dao;

import com.projet.entities.Eleve;

import javafx.collections.ObservableList;

public interface IEleve {

	public int add(Eleve elv);
	public ObservableList<Eleve> listeEleve();
	public Eleve getEleveById(int id);
}
