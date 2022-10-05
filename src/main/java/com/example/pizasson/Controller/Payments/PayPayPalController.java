package com.example.pizasson.Controller.Payments;

import com.example.pizasson.Controller.ClientController;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.DataBase.DBPaymentMethods;
import com.example.pizasson.Stages.ClientInformationStage;
import com.example.pizasson.Stages.PizassonScreenStage;
import com.example.pizasson.utils.RegularExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is used to be able to manage the data, methods, buttons and combo boxes used in the execution screen of
 * the Pay PayPal Controller.
 *
 * @author Jefersson Coronel
 */
public class PayPayPalController {

    @FXML
    private Button buttonDate;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label messageLabel;

    private DBPaymentMethods dbPaymentMethods = new DBPaymentMethods();

    private DBOrders dbOrders;

    /**
     * The constructor method where initialized the databaseOrder and the button.
     */
    public PayPayPalController() {
        dbOrders = new DBOrders();
        buttonDate = new Button();
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
     * This method is executed when an action or event is performed, in this case pressing the continue button.
     *
     * @param actionEvent an action or an event that occurred
     */
    public void doContinue(ActionEvent actionEvent) throws IOException {
        toDoIfCondition(actionEvent);
    }

    /**
     * This method is responsible for doing what is related to the date on the screen.
     *
     * @param actionEvent an action or an event that occurred
     */
    public void updateDayInTextField(ActionEvent actionEvent) {
        dateTextField.setText("");
        dateTextField.appendText(dbPaymentMethods.payPayPal.getDayOfPay());
        buttonDate.setDisable(true);
    }

    /**
     * This method is responsible for performing actions according to a condition.
     */
    public void toDoIfCondition(ActionEvent actionEvent) throws IOException {
        if (RegularExpression.getRegularExpression().validateEmail(emailTextField.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("ClientInformationView.fxml"));
            Scene clientInformationScene = new Scene(fxmlLoader.load(), 1100, 700);

            ClientController clientController = fxmlLoader.getController();
            clientController.updateDBOrders(dbOrders);

            Stage pizzasonStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            String css1 = String.valueOf(ClientInformationStage.class.getResource("clientInformationView.css"));
            String css2 = String.valueOf(ClientInformationStage.class.getResource("generalStyle.css"));
            clientInformationScene.getStylesheets().addAll(css1, css2);

            pizzasonStage.setTitle("INVOICE INFORMATION");
            pizzasonStage.setScene(clientInformationScene);
            pizzasonStage.show();
        }
        else { messageLabel.setText("Please enter a correct email"); }
    }
}
