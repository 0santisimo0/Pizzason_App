package com.example.pizasson.Controller.Payments;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.DataBase.DBPaymentMethods;
import com.example.pizasson.Model.Payment.Payment;
import com.example.pizasson.Stages.PizassonScreenStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is a controller of paymentView is used to handle all class its view and generate the functionality of all
 * methods and attributes of this class.
 *
 * @see DBPaymentMethods
 * @author Jefersson Coronel
 */
public class PaymentController {

    /**
     * These attributes are the radio buttons will be used to do all actions.
     */
    @FXML
    private RadioButton payCreditCard, payPayPal, payQr, payTigoMoney;

    /**
     * These attributes are the buttons will be used to do actions.
     */
    @FXML
    private Button creditCardButton, payPalButton, tigoMoneyButton, qrButton;

    /**
     * This attribute is used to show the method of payment is selected.
     */
    @FXML private TextField methodSelected;

    /**
     * This attribute is used to save all buttons for after change the status.
     */
    private ArrayList<Button> listOfButtons;

    /**
     * This attribute is the database of all payment methods.
     */
    private DBPaymentMethods dbPaymentMethods;

    /**
     * This attribute is used save the database of payment.
     */
    private ArrayList<Payment> listOfPayments;

    /**
     * This attribute is used to save all radio buttons.
     */
    private ArrayList<RadioButton> listOfRadioButtons;
    /**
     * The all orders database simulation
     */
    private DBOrders dbOrders;

    /**
     * This is a constructor method of PaymentController where initialized the array lists.
     */
    public PaymentController() {
        dbPaymentMethods = new DBPaymentMethods();
        listOfRadioButtons = new ArrayList<>();
        listOfButtons = new ArrayList<>();
        listOfPayments = dbPaymentMethods.listOfPayments;
        dbOrders = new DBOrders();
    }

    /**
     * This method is used to update the texts of all radio buttons.
     */
    private void addTittlesToRadioBottoms() {
        int indexInLIst = 0;
        for (RadioButton radioButton: listOfRadioButtons){
            radioButton.setText(listOfPayments.get(indexInLIst).getNamePaymentMethod());
            indexInLIst ++;
        }
    }

    /**
     * This method will be used to update the database orders to the one received
     * with all the orders from the different screens
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders) throws FileNotFoundException {
        this.dbOrders = dbOrders;
    }


    /**
     * This method is in charge of initializing all the operation of our screen, generating all the controllers.
     */
    private void initializedTheControls(){
        generateListOfControls();
        for (Button button : listOfButtons) {
            button.setDisable(true);
        }
        addTittlesToRadioBottoms();
    }

    /**
     * This method is used to save all controls in its respective list.
     */
    public void generateListOfControls() {
        Collections.addAll(listOfRadioButtons, payCreditCard, payPayPal, payTigoMoney, payQr);

        Collections.addAll(listOfButtons, creditCardButton, payPalButton, tigoMoneyButton, qrButton);
    }

    /**
     * This method is used to set de status of bottoms for do only one action when the user choose.
     *
     * @param buttonSelected This parameter is used to check the status of this bottom;
     * @param paymentSelected This attribute is used to show what action is selected by user.
     */
    public void updateThePaymentMethod(Button buttonSelected, RadioButton paymentSelected){
        methodSelected.setText("");

        for (Button button: listOfButtons){
            if (!button.disableProperty().get()) button.setDisable(true);
        }
        buttonSelected.setDisable(false);
        methodSelected.appendText(paymentSelected.getText());
    }

    /**
     * This method is principal because is the method with initialized all view and controls of this controller.
     *
     * @throws FileNotFoundException in case there is an exception.
     */
    public void initialize () throws FileNotFoundException {
        initializedTheControls();
    }

    /**
     * This is used to an action in this case the action of credit card button.
     *
     * @param event receive the event like click
     */
    @FXML
    void getCreditCard(ActionEvent event) {
        updateThePaymentMethod(creditCardButton, payCreditCard);
    }

    /**
     * This is used to an action in this case the action of PayPal button.
     *
     * @param event receive the event like click
     */
    @FXML
    void getPayPal(ActionEvent event) {
        updateThePaymentMethod(payPalButton, payPayPal);
    }

    /**
     * This is used to an action in this case the action of qr button.
     *
     * @param event receive the event like click
     */
    @FXML
    void getQr(ActionEvent event) {
        updateThePaymentMethod(qrButton, payQr);
    }

    /**
     * This is used to an action in this case the action of Tigo Money button.
     *
     * @param event receive the event like click
     */
    @FXML
    void getTigoMoney(ActionEvent event) {
        updateThePaymentMethod(tigoMoneyButton, payTigoMoney);
    }


    /**
     * This method called to action of method selected fo change screens.
     *
     * @param actionEvent receive the event like click
     */
    public void clickedOnCreditCard(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PizassonScreenStage.class.getResource("PaymentCreditCardView.fxml"));

            Parent parent = loader.load();

            Scene extraScene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Payment Credit Card");
            stage.setScene(extraScene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method called to action of method selected fo change screens.
     *
     * @param actionEvent receive the event like click
     */
    public void clickedQR(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PizassonScreenStage.class.getResource("PaymentQRView.fxml"));

            Parent parent = loader.load();

            Scene extraScene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Payment Qr");
            stage.setScene(extraScene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method called to action of method selected fo change screens.
     *
     * @param actionEvent receive the event like click
     */
    public void clickedOnTigoMoney(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PizassonScreenStage.class.getResource("PaymentTigoMoneyView.fxml"));

            Parent parent = loader.load();

            Scene extraScene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Payment Tigo Money");
            stage.setScene(extraScene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method called to action of method selected fo change screens.
     *
     * @param actionEvent receive the event like click
     */
    public void clickedOnPayPal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PizassonScreenStage.class.getResource("PaymentPayPalView.fxml"));

            Parent parent = loader.load();

            Scene extraScene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Payment Pay Pal");
            stage.setScene(extraScene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
