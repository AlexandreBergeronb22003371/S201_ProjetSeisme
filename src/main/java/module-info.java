module fr.g2.s201_projetseisme {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.gluonhq.maps;


    opens fr.g2.s201_projetseisme to javafx.fxml;
    exports fr.g2.s201_projetseisme;
}