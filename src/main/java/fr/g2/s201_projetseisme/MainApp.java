package fr.g2.s201_projetseisme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author  ALI Mdallah, BERGERON Alexandre, BIHI Ayoub, FERRIER Killian
 *
 * @version 1.0.0
 */
public class MainApp extends Application {

    /**
     * scene est une Scene accessible par toutes les classes. C'est elle qui est contenue dans stage et elle est modifiable afin de naviguer entre plusieurs onglets
     */
    public static Scene scene;
    /**
     *  stage est une Stage accessible par toutes les calsses. C'est la fenêtre qui contient tout le contenu de l'application.
     */
    public static Stage stage;

    /**
     * C'est la fonction principale du code. Elle va loader le FXML qui par la suite pourra changer en fonction de la fenêtre que nous avons sélectionnée. Elle est donc utilisée pour démarrer l'application et afficher la fenêtre principale de l'interface utilisateur.
     * @param stage est de type Stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("accueil-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("KAMA Séisme App");
        stage.setScene(scene);
        stage.setResizable(false);
        MainApp.stage = stage;
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
        stage.show();
    }

    /**
     * C'est la fonction qui est le point d'entrée de l'application, où le programme commence son exécution.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}