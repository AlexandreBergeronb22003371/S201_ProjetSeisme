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
 * Ceci est la classe qui va se charger de gérer toutes les fonctionnalités liées au graphique de la page Map (map-view.fxml). C'est sa classe controller.
 */
public class MapController extends Controller implements Initializable {

    @FXML
    public MapView mapView;

    /**
     * Cette fonction va initialiser des variables, méthodes ou encore des objets qui reprendront les valeurs données ici à chaque appel de cette classe.
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
     *
     */
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

    /**
     *
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