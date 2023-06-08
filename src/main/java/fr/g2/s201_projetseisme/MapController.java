package fr.g2.s201_projetseisme;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class MapController extends Controller implements Initializable {

    public MapView mapView;
    public VBox vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);

        /* Création et ajout d'une couche à la carte */
        MapLayer mapLayer = new CustomCircleMarkerLayer(mapPoint);
        mapView.addLayer(mapLayer);

        /* Zoom de 5 */
        mapView.setZoom(5);

        /* Centre la carte sur le point */
        mapView.flyTo(0, mapPoint, 0.1);
    }

    public class CustomCircleMarkerLayer extends MapLayer {

        private final MapPoint mapPoint;
        private final Circle circle;

        public CustomCircleMarkerLayer(MapPoint mapPoint) {
            this.mapPoint = mapPoint;
            this.circle = new Circle(5, Color.RED);
            this.getChildren().add(circle);
        }

        @Override
        protected void layoutLayer() {
            Point2D point2d = getMapPoint(mapPoint.getLatitude(), mapPoint.getLongitude());
            circle.setTranslateX(point2d.getX());
            circle.setTranslateY(point2d.getY());
        }
    }
}