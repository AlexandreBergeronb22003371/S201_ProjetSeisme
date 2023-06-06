package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private HBox accueilHbox;
    @FXML
    private HBox statistiquesHbox;
    @FXML
    private HBox mapHbox;
    @FXML
    private Button accueilButton;
    @FXML
    private Button statistiquesButton;
    @FXML
    private Button mapButton;

    @FXML
    public void mapButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("map-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }
    @FXML
    public void accueilButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("accueil-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }
    @FXML
    public void statsButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("statistiques-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }

    @FXML
    public void mouseEnterAccueil() {
        accueilHbox.setStyle("-fx-background-color: #A2F5FF; -fx-border-color: grey;");
        accueilButton.setStyle("-fx-background-color: #A2F5FF");
    }

    @FXML
    public void mouseExitAccueil() {
        accueilHbox.setStyle("-fx-background-color: #34EAFF; -fx-border-color: grey;");
        accueilButton.setStyle("-fx-background-color: #34EAFF");
    }

    @FXML
    public void mouseEnterStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color: #A2F5FF; -fx-border-color: grey;");
        statistiquesButton.setStyle("-fx-background-color: #A2F5FF");
    }

    @FXML
    public void mouseExitStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color: #34EAFF; -fx-border-color: grey;");
        statistiquesButton.setStyle("-fx-background-color: #34EAFF");
    }

    @FXML
    public void mouseEnterMap() {
        mapHbox.setStyle("-fx-background-color: #A2F5FF; -fx-border-color: grey;");
        mapButton.setStyle("-fx-background-color: #A2F5FF");
    }

    @FXML
    public void mouseExitMap() {
        mapHbox.setStyle("-fx-background-color: #34EAFF; -fx-border-color: grey;");
        mapButton.setStyle("-fx-background-color: #34EAFF");
    }
}