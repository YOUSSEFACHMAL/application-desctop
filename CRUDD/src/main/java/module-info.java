module com.example.crudd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.crudd to javafx.fxml;
    opens com.example.crudd.model to java.base ;

    exports com.example.crudd;
    exports com.example.crudd.model ;
}