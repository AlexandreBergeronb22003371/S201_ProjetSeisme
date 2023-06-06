package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}