package com.example.pizasson.Stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *This class imports the fxml and the css file creates the scene to set it on the stage
 * the class extends application to initialize the components
 *
 * @author Santiago Caballero
 */
public class PizassonScreenStage extends Application {

    /**
     * Overriding the method start to initialize the components
     * @param stage the root stage getting a window from the system
     * @throws Exception when a window can not be displayed
     */
    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SplashScreenView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
            stage.setTitle("WELCOME");
            String css = this.getClass().getResource("splashScreen.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
