package fr.g2.s201_projetseisme;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static Scene scene;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("accueil-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("KAMA Séisme App");
        stage.setScene(scene);
        stage.setResizable(false);
        MainApp.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}