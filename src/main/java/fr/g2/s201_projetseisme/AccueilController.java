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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccueilController extends Controller implements Initializable {

    @FXML
    private Button importButton;

    @FXML
    private Label pathLabel;

    public static ArrayList<ArrayList<String>> data;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        data = new ArrayList<ArrayList<String>>();
        if (pathString != "aucun") {
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: green");
        }
        else {
            pathString = "aucun";
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: red");
        }
    }

    public void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        Stage stage = (Stage) MainApp.stage;
        java.io.File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            pathString = selectedFile.getAbsolutePath();
            System.out.println("Fichier sélectionné : " + pathString);
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: green");
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                String[] tempArr;
                String delimiter = ",";
                ArrayList<String> insideArr = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    for (String tempStr : tempArr) {
                        insideArr.add(tempStr);
                    }
                    data.add(insideArr);
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        } else {
            pathString = "aucun";
            System.out.println("Aucun fichier sélectionné.");
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: red");
        }
    }
}