package com.projet.ui.classe;

import java.net.URL;
import java.util.ResourceBundle;

import com.projet.dao.ClasseDB;
import com.projet.dao.IClasse;
import com.projet.entities.Classe;
import com.projet.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DeleteController implements Initializable {

    @FXML
    private TableView<Classe> classe_table;

    @FXML
    private TableColumn<Classe, Integer> id_column;

    @FXML
    private TableColumn<Classe, String> nom_column;


    @FXML
    private Button supprimer_bt;


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
		supprimer_bt.setDisable(true);
		chargerTable();
	}
	private void desactiver(){
		supprimer_bt.setDisable(false);
	}
	private int id;
	 @FXML
    void table_click(MouseEvent event) {
		 desactiver();
		 Classe cl = classe_table.getSelectionModel().getSelectedItem();
		 id = cl.getIdC();
    }
	 @FXML
    void deleteClasse(ActionEvent event) {
		 icl = new ClasseDB();
		 if(icl.delete(id) != 0){
			 Notification.NotifSucces("Info", "Données supprimées avec succès!");
		 }else{
			 Notification.NotifError("Info", "Données non supprimées!");
		 }
		 activer();
    }
}
