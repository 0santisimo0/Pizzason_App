package com.example.pizasson.Stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientInformationStage extends Application {
    /**
     * Overriding the method start to initialize the components and render the view
     * @param stage the root stage getting a window from the system
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(ClientInformationStage.class.getResource("ClientInformationView.fxml"));
            Scene scene = new Scene(fxmlLoader2.load(), 1100, 700);
            stage.setTitle("INVOICE INFORMATION");
            String css1 = String.valueOf(ClientInformationStage.class.getResource("clientInformationView.css"));
            String css2 = String.valueOf(ClientInformationStage.class.getResource("generalStyle.css"));
            scene.getStylesheets().addAll(css1,css2);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
