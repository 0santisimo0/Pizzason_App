package com.example.pizasson.Controller.Payments;

import com.example.pizasson.Controller.ClientController;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.DataBase.DBPaymentMethods;
import com.example.pizasson.Stages.ClientInformationStage;
import com.example.pizasson.Stages.PizassonScreenStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is used to be able to manage the data, methods, buttons and combo boxes used in the execution screen of
 * the Pay PayPal Controller.
 *
 * @author Jefersson Coronel
 */
public class PayQRCodeController {

    private DBOrders dbOrders;
    @FXML
    private TextField textFieldDate = new TextField();
    private DBPaymentMethods dbPaymentMethods;

    /**
     * The constructor method where initialized the databaseOrder and the button.
     */
    public PayQRCodeController() {
        dbOrders = new DBOrders();
        dbPaymentMethods = new DBPaymentMethods();
    }

    /**
     * This method will be used to update the database orders to the one received from the HomeOrder
     * with all the orders from the different screens.
     *
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method is responsible for doing what is related to the date on the screen.
     */
    @FXML
    public void initialize() throws FileNotFoundException {
        textFieldDate.appendText(dbPaymentMethods.payQR.getDayOfPay());
    }

    /**
     * This method is executed when an action or event is performed, in this case pressing the continue button.
     *
     * @param event an action or an event that occurred
     */
    @FXML
    void changeView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("ClientInformationView.fxml"));
        Scene clientInformationScene = new Scene(fxmlLoader.load(), 1100, 700);

        ClientController clientController = fxmlLoader.getController();
        clientController.updateDBOrders(dbOrders);

        Stage pizzasonStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        String css1 = String.valueOf(ClientInformationStage.class.getResource("clientInformationView.css"));
        String css2 = String.valueOf(ClientInformationStage.class.getResource("generalStyle.css"));
        clientInformationScene.getStylesheets().addAll(css1,css2);

        pizzasonStage.setTitle("INVOICE INFORMATION");
        pizzasonStage.setScene(clientInformationScene);
        pizzasonStage.show();
    }
}
