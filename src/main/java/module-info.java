module com.example.pizasson {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.pizasson to javafx.fxml;
    exports com.example.pizasson;
    exports com.example.pizasson.Controller;
    opens com.example.pizasson.Controller to javafx.fxml;
    exports com.example.pizasson.Stages;
    opens com.example.pizasson.Stages to javafx.fxml;
    exports com.example.pizasson.Controller.Payments;
    opens com.example.pizasson.Controller.Payments to javafx.fxml;
}