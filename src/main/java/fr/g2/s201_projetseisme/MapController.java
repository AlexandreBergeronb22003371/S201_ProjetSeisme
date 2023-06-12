package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Ceci est la classe qui va se charger de gérer toutes les fonctionnalités liées à la mapView de la page Map (map-view.fxml). C'est sa classe controller.
 */
public class MapController extends Controller implements Initializable {

    @FXML
    public MapView mapView;

    /**
     * Cette fonction va initialiser le placement visuel de la map et le zoom par défaut.
     * Si un fichier csv est sélectionné, alors elle initialise aussi les points correspondant à chaque séisme.
     * Sinon, la map s'affiche sans points.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);

        /* Zoom de 5 */
        mapView.setZoom(3);

        /* Centre la carte sur le point */
        mapView.flyTo(0, mapPoint, 0.1);

        if (DataSorter.data != null) {
            if (!(DataSorter.data.isEmpty())) {
                mapPointTrace();
            }
        }
    }

    /**
     * CustomCircleMarkerLayer est une sous classe qui contient les attributs et fonctions nécessaires au traçage de points sur la mapView
     */
    public class CustomCircleMarkerLayer extends MapLayer {
        /**
         * mapPoint est un point à afficher sur une MapView.
         */
        private final MapPoint mapPoint;
        /**
         * circle est un cercle qui permet l'affichage d'un point sur une MapView.
         */
        private final Circle circle;

        /**
         * Permet la création d'un cercle de couleur rouge en fonction de mapPoint
         * @param mapPoint
         */
        public CustomCircleMarkerLayer(MapPoint mapPoint) {
            this.mapPoint = mapPoint;
            this.circle = new Circle(5, Color.RED);
            this.getChildren().add(circle);
        }

        /**
         * Permet le placement du point au bon endroit sur la MapView
         */
        @Override
        protected void layoutLayer() {
            Point2D point2d = getMapPoint(mapPoint.getLatitude(), mapPoint.getLongitude());
            circle.setTranslateX(point2d.getX());
            circle.setTranslateY(point2d.getY());
        }
    }

    /**
     * Cette fonction trace chaque point un par un en fonction du contenu de DataSorter.data.
     */
    public void mapPointTrace(){

        for (int i = 1 ; i < DataSorter.data.size() ; ++i) {

            String latitudeStr = DataSorter.data.get(i).get(DataSorter.latitudeColumnIndex);
            String longitudeStr = DataSorter.data.get(i).get(DataSorter.longitudeColumnIndex);

            if (!(latitudeStr.isEmpty() || longitudeStr.isEmpty())) {
                double latitude = Double.parseDouble(DataSorter.data.get(i).get(DataSorter.latitudeColumnIndex));
                double longitude = Double.parseDouble(DataSorter.data.get(i).get(DataSorter.longitudeColumnIndex));

                MapPoint mapPoint = new MapPoint(latitude, longitude);
                MapLayer mapLayer = new CustomCircleMarkerLayer(mapPoint);
                mapView.addLayer(mapLayer);
            }
        }
    }
}