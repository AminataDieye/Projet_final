package com.projet.tools;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Tools {

	public static void showMessage(String titre, String msg) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(titre);
		a.setContentText(msg);
		a.showAndWait();
	}

	private void loadPage(ActionEvent event, String url) throws IOException{

		((Node) event.getSource()).getScene().getWindow().hide();

		Parent root = FXMLLoader.load(getClass().getResource(url));
		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Page");
		stage.show();
	}
	public static void myLoadpage(ActionEvent event, String url) throws IOException{
		(new Tools()).loadPage(event, url);
	}
}
