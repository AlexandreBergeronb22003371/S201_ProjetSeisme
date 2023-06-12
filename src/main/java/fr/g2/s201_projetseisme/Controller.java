package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Cette classe est la classe mère de tous les Controller. Elle contient toutes les fonctions activées par les boutons communs à toutes les vues.
 */
public class Controller {

    /**
     * accueilHbox est la HBox qui contient l'image et le bouton relatifs à l'onglet Accueil.
     */
    @FXML
    private HBox accueilHbox;
    /**
     * statistiquesHbox est la HBox qui contient l'image et le bouton relatifs à l'onglet Statistiques.
     */
    @FXML
    private HBox statistiquesHbox;
    /**
     * mapHbox est la HBox qui contient l'image et le bouton relatifs à l'onglet Map.
     */
    @FXML
    private HBox mapHbox;
    /**
     * accueilButton est le Button relatif à l'onglet Accueil.
     */
    @FXML
    private Button accueilButton;
    /**
     * statistiquesButton est le Button relatif à l'onglet Statistiques.
     */
    @FXML
    private Button statistiquesButton;
    /**
     * mapButton est le Button relatif à l'onglet Map.
     */
    @FXML
    private Button mapButton;
    /**
     * pathString est la String accessible depuis toutes les classes relative à l'état du fichier csv sélectionné.
     * Par défaut, sa valeur est "aucun" car aucun fichier n'est sélectionné au lancement de l'application.
     */
    public static String pathString = "aucun";

    /**
     * mapButtonClicked() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Map sont cliqués.
     * Elle modifie la Scene principale contenue dans la classe MainApp et actualise la Stage aussi contenue dans MainApp.
     * @throws IOException
     */
    @FXML
    public void mapButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("map-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }

    /**
     * accueilButtonClicked() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Accueil sont cliqués.
     * Elle modifie la Scene principale contenue dans la classe MainApp et actualise la Stage aussi contenue dans MainApp.
     * @throws IOException
     */
    @FXML
    public void accueilButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("accueil-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }

    /**
     * statsButtonClicked() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Statistiques sont cliqués.
     * Elle modifie la Scene principale contenue dans la classe MainApp et actualise la Stage aussi contenue dans MainApp.
     * @throws IOException
     */
    @FXML
    public void statsButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("statistiques-view.fxml"));
        MainApp.scene = new Scene(fxmlLoader.load(), 800, 600);
        MainApp.stage.setScene(MainApp.scene);
        MainApp.stage.show();
    }

    /**
     * mouseEnterAccueil() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Accueil sont survolés par le curseur de souris.
     * Elle modifie la couleur de fond de accueilHbox et accueilButton pour donner un effet éclairci.
     */
    @FXML
    public void mouseEnterAccueil() {
        accueilHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        accueilButton.setStyle("-fx-background-color: #E8A97E");
    }

    /**
     * mouseExitAccueil() est la fonction exécutée lorsque le curseur de la souris quitte la zone du bouton et de l'image relatifs à l'onglet Accueil.
     * Elle modifie la couleur de fond de accueilHbox et accueilButton pour la remettre à sa couleur d'origine.
     */
    @FXML
    public void mouseExitAccueil() {
        accueilHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        accueilButton.setStyle("-fx-background-color:  #DB854B");
    }
    /**
     * mouseEnterStatistiques() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Statistiques sont survolés par le curseur de souris.
     * Elle modifie la couleur de fond de statistiquesHbox et statistiquesButton pour donner un effet éclairci.
     */
    @FXML
    public void mouseEnterStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        statistiquesButton.setStyle("-fx-background-color: #E8A97E");
    }
    /**
     * mouseExitStatistiques() est la fonction exécutée lorsque le curseur de la souris quitte la zone du bouton et de l'image relatifs à l'onglet Statistiques.
     * Elle modifie la couleur de fond de statistiquesHbox et statistiquesButton pour la remettre à sa couleur d'origine.
     */
    @FXML
    public void mouseExitStatistiques() {
        statistiquesHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        statistiquesButton.setStyle("-fx-background-color:  #DB854B");
    }

    /**
     * mouseEnterMap() est la fonction exécutée lorsque le bouton et l'image relatifs à l'onglet Map sont survolés par le curseur de souris.
     * Elle modifie la couleur de fond de mapHbox et mapButton pour donner un effet éclairci.
     */
    @FXML
    public void mouseEnterMap() {
        mapHbox.setStyle("-fx-background-color:  #E8A97E; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        mapButton.setStyle("-fx-background-color: #E8A97E");
    }
    /**
     * mouseExitMap() est la fonction exécutée lorsque le curseur de la souris quitte la zone du bouton et de l'image relatifs à l'onglet Map.
     * Elle modifie la couleur de fond de mapHbox et mapButton pour la remettre à sa couleur d'origine.
     */
    @FXML
    public void mouseExitMap() {
        mapHbox.setStyle("-fx-background-color:  #DB854B; -fx-border-color: black; -fx-background-radius: 10; -fx-border-radius: 10");
        mapButton.setStyle("-fx-background-color:  #DB854B");
    }
}