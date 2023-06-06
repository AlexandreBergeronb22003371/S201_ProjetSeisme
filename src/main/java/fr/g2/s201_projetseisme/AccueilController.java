package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccueilController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}