package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;

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
    public static String pathString = "aucun";

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
        accueilHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        accueilButton.setStyle("-fx-background-color: #E8A97E");
    }

    @FXML
    public void mouseExitAccueil() {
        accueilHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        accueilButton.setStyle("-fx-background-color:  #DB854B");
    }

    @FXML
    public void mouseEnterStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        statistiquesButton.setStyle("-fx-background-color: #E8A97E");
    }

    @FXML
    public void mouseExitStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        statistiquesButton.setStyle("-fx-background-color:  #DB854B");
    }

    @FXML
    public void mouseEnterMap() {
        mapHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        mapButton.setStyle("-fx-background-color: #E8A97E");
    }

    @FXML
    public void mouseExitMap() {
        mapHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        mapButton.setStyle("-fx-background-color:  #DB854B");
    }
}