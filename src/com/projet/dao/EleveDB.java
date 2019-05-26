package com.projet.dao;

import java.sql.ResultSet;

import com.projet.entities.Classe;
import com.projet.entities.Eleve;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EleveDB implements IEleve {

	private DB db;
	private ResultSet rs;
	private int ok;
	@Override
	public int add(Eleve elv) {
		String sql = "INSERT INTO eleve VALUES(null, ?, ?, ?)";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setString(1, elv.getNom());
			db.getPstm().setString(2, elv.getPrenom());
			db.getPstm().setInt(3, elv.getIdC().getIdC());
			ok = db.executeMAJ();
			rs = db.getPstm().getGeneratedKeys();
			while(rs.next()){
				ok =  rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}



	@Override
	public ObservableList<Eleve> listeEleve() {
		ObservableList<Eleve> l_eleve = FXCollections.observableArrayList();
		String sql = "SELECT * FROM eleve";
		try {
			db = new DB();
			db.initPrepare(sql);

			rs = db.executeSELECT();
			while(rs.next()){
				Eleve s = new Eleve();
				s.setId(rs.getInt(1));
				s.setNom(rs.getString(2));
				s.setPrenom(rs.getString(3));

				IClasse icl = new ClasseDB();
				Classe cl = icl.getClasseById(rs.getInt(4));
				s.setIdC(cl);

				l_eleve.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l_eleve;
	}



	@Override
	public Eleve getEleveById(int id) {
		Eleve s = null;
		String sql = "SELECT * FROM eleve WHERE id = ?";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setInt(1, id);

			rs = db.executeSELECT();
			while(rs.next()){
				s = new Eleve();
				s.setId(rs.getInt(1));
				s.setNom(rs.getString(2));
				s.setPrenom(rs.getString(3));

				Classe sv = new Classe();
				sv.setIdC(rs.getInt(6));
				s.setIdC(sv);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
