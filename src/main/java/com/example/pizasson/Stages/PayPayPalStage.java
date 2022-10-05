package com.example.pizasson.Stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PayPayPalStage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PaymentPayPalView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 689, 470);
            stage.setTitle("Payment");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {throw new RuntimeException(e);}
    }

}
