package com.projet.ui.classe;

import java.net.URL;
import java.util.ResourceBundle;

import com.projet.dao.ClasseDB;
import com.projet.dao.IClasse;
import com.projet.entities.Classe;
import com.projet.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddController{
    @FXML
    private TextField nom_txt;

    @FXML
    private TableView<Classe> classe_table;

    @FXML
    private TableColumn<Classe, Integer> id_column;

    @FXML
    private TableColumn<Classe, String> nom_column;

    @FXML
    private Button valider_bt;

	public void initialize(URL arg0, ResourceBundle arg1) {

		id_column.setCellValueFactory(new PropertyValueFactory<>("idC"));
		nom_column.setCellValueFactory(new PropertyValueFactory<>("nomC"));
		activer();
	}
	private IClasse icl;

	private void activer(){
		valider_bt.setDisable(false);
		nom_txt.setText("");
	}


    @FXML
    void addClasse(ActionEvent event) {
    	String noms = nom_txt.getText();
    	if(noms.equals(""))
    	{
    		Notification.NotifError("Erreur", "Veuillez remplir tous les champs !!");
	    	    	}
    	else{
	    	    		icl = new ClasseDB();
	    		    	Classe s = new Classe();
	    		    	s.setNomC(noms);
	    		    	if(icl.add(s) != 0){
	    		    		Notification.NotifSucces("Info", "Données ajoutés !!");
	    		    	}else{
	    		    		Notification.NotifError("Erreur", "Données non ajoutés !!");
	    		    	}
	    		    	activer();
    	}
    }

}
