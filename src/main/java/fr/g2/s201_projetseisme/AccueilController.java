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





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        DataSorter.data = new ArrayList<ArrayList<String>>();
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
                while ((line = reader.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    ArrayList<String> tempInsideArr = new ArrayList<String>();
                    for (String tempStr : tempArr) {
                        tempInsideArr.add(tempStr);
                    }
                    DataSorter.data.add(tempInsideArr);
                }

                //Initialisation des index importants

                DataSorter.initDateColumnIndex(DataSorter.data);
                DataSorter.initRegionColumnIndex(DataSorter.data);
                DataSorter.initLatitudeColumnIndex(DataSorter.data);
                DataSorter.initLongitudeColumnIndex(DataSorter.data);

            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        } else {
            pathString = "aucun";
            System.out.println("Aucun fichier sélectionné.");
            pathLabel.setText(pathString);
            pathLabel.setStyle("-fx-text-fill: red");
            DataSorter.data.clear();
        }
    }
}