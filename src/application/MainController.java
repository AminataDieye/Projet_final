package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController {

@FXML
private Button button;

@FXML
private AnchorPane rootPane;

@FXML
    public void showClassePage(ActionEvent event) throws IOException {

    AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/classe/AddClasse.fxml"));
    rootPane.getChildren().setAll(pane);
}



@FXML
public void showListerClasse(ActionEvent event) throws IOException {

AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/lister/ListerClasse.fxml"));
rootPane.getChildren().setAll(pane);
   }

@FXML
public void showElevePage(ActionEvent event) throws IOException {

AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/eleve/Eleve.fxml"));
rootPane.getChildren().setAll(pane);
   }

@FXML
public void showListerEleve(ActionEvent event) throws IOException {

AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/lister/ListerEleve.fxml"));
rootPane.getChildren().setAll(pane);
   }


@FXML
public void showUpdateClasse(ActionEvent event) throws IOException {

AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/classe/UpdateClasse.fxml"));
rootPane.getChildren().setAll(pane);
   }

@FXML
public void showDeleteClasse(ActionEvent event) throws IOException {

AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/projet/ui/classe/DeleteClasse.fxml"));
rootPane.getChildren().setAll(pane);
   }
}