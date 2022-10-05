package com.example.pizasson.Stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PaymentStage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("PaymentView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 484);
            stage.setTitle("Payment");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {throw new RuntimeException(e);}
    }
}
