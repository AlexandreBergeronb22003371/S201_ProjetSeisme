package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController extends Controller implements Initializable {

    @FXML
    Button importButton;

    @FXML
    Label pathLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        Stage stage = (Stage) MainApp.stage;
        java.io.File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());
            pathLabel.setText(" " + selectedFile.getAbsolutePath());
            pathLabel.setStyle("-fx-text-fill: green");
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        } else {
            System.out.println("Aucun fichier sélectionné.");
            pathLabel.setText(" aucun");
            pathLabel.setStyle("-fx-text-fill: red");
        }
    }
}