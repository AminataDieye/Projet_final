package com.projet.dao;

import java.sql.ResultSet;

import com.projet.entities.Classe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClasseDB implements IClasse {

	private DB db;
	private ResultSet rs;
	private int ok;

	@Override
	public int add(Classe cl) {
		String sql = "INSERT INTO classe VALUES(NULL, ?)";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setString(1, cl.getNomC());
			ok = db.executeMAJ();
			rs = db.getPstm().getGeneratedKeys();
			while(rs.next()){
				ok = rs.getInt(1);
			}
			db.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int idC) {
		String sql = "DELETE FROM classe WHERE idC = ?";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setInt(1, idC);

			ok = db.executeMAJ();
			db.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(Classe cl) {
		String sql = "UPDATE classe SET nomC = ? WHERE idC = ?";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setString(1, cl.getNomC());
			db.getPstm().setInt(2, cl.getIdC());

			ok = db.executeMAJ();
			db.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public ObservableList<Classe> listeClasse() {
		ObservableList<Classe> l_classe = FXCollections.observableArrayList();
		String sql = "SELECT * FROM classe";
		try {
			db = new DB();
			db.initPrepare(sql);

			rs = db.executeSELECT();
			while(rs.next()){
				Classe cl = new Classe();
				cl.setIdC(rs.getInt(1));
				cl.setNomC(rs.getString(2));

				l_classe.add(cl);
			}
			db.closeConnexion();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l_classe;
	}

	@Override
	public Classe getClasseById(int idC) {
		Classe cl = null;
		String sql = "SELECT * FROM classe WHERE idC = ?";
		try {
			db = new DB();
			db.initPrepare(sql);
			db.getPstm().setInt(1, idC);
			rs = db.executeSELECT();
			while(rs.next()){
				cl = new Classe();
				cl.setIdC(rs.getInt(1));
				cl.setNomC(rs.getString(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;
	}



}
