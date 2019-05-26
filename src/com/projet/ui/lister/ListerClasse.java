package com.projet.ui.lister;

import java.net.URL;
import java.util.ResourceBundle;

import com.projet.dao.ClasseDB;
import com.projet.dao.IClasse;
import com.projet.entities.Classe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListerClasse implements Initializable{

    @FXML
    private TableView<Classe> classe_table;

    @FXML
    private TableColumn<Classe, Integer> id_column;

    @FXML
    private TableColumn<Classe, String> nom_column;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		id_column.setCellValueFactory(new PropertyValueFactory<>("idC"));
		nom_column.setCellValueFactory(new PropertyValueFactory<>("nomC"));
		activer();

	}

	private IClasse icl;
	private void chargerTable(){
		icl = new ClasseDB();
		classe_table.setItems(icl.listeClasse());
	}

	private void activer(){
		chargerTable();
	}
}
