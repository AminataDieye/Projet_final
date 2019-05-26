package com.projet.ui.eleve;

import java.net.URL;
import java.util.ResourceBundle;

import com.projet.dao.ClasseDB;
import com.projet.dao.EleveDB;
import com.projet.dao.IClasse;
import com.projet.dao.IEleve;
import com.projet.entities.Classe;
import com.projet.entities.Eleve;
import com.projet.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EleveController implements Initializable{
	@FXML
    private TextField nom_txt;

    @FXML
    private Button valider_bt;

    @FXML
    private Button annuler_bt;

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
    private TextField prenom_txt;

    @FXML
    private ComboBox<Classe> classe_cbx;



	    @FXML
	    void valider(ActionEvent event) {
	    	String nom = nom_txt.getText();
	    	String prenom = prenom_txt.getText();
	    	Classe cl = classe_cbx.getValue();
	    	is = new EleveDB();
	    	Eleve s = new Eleve();
	    	s.setNom(nom);
	    	s.setPrenom(prenom);
	    	s.setIdC(cl);
	    	if(is.add(s) != 0){
	    		Notification.NotifSucces("Info", "Données ajoutées !!");
	    	}else{
	    		Notification.NotifError("Erreur", "Données non ajoutées !!");
	    	}
	    }
	@FXML
	private IClasse icl;

	private void loadCombo() {
		icl = new ClasseDB();
		classe_cbx.setItems(icl.listeClasse());
	}
	IEleve is;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		loadCombo();
	}

}
