package com.projet.ui.lister;

import java.net.URL;
import java.util.ResourceBundle;

import com.projet.dao.EleveDB;
import com.projet.dao.IEleve;
import com.projet.entities.Eleve;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListerEleve implements Initializable{

    @FXML
    private TableView<Eleve> eleve_table;

    @FXML
    private TableColumn<Eleve, Integer> id_column;

    @FXML
    private TableColumn<Eleve, String> nom_column;

    @FXML
    private TableColumn<Eleve, String> prenom_column;

    @FXML
    private TableColumn<Eleve, String> classe_column;

    @FXML
    void table_click(MouseEvent event) {

    }
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		nom_column.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom_column.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		classe_column.setCellValueFactory(new PropertyValueFactory<>("idC"));
		loadTable();
	}

	IEleve is;
	public void loadTable(){
		is = new EleveDB();
		eleve_table.setItems(is.listeEleve());
	}

}