package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Client;
import com.example.pizasson.Model.Invoice;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Stages.PizassonScreenStage;
import com.example.pizasson.utils.JavaFXComponents;
import com.example.pizasson.utils.RegularExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to receive and validate the information from the client for the invoice
 * The class sets iu elements and events to receive the name, nit or email from the client if he or she
 * wants to provide them the class uses regular expressions to verify each field
 *
 * @author Santiago Caballero
 * @see RegularExpression
 */
public class ClientController {
    @FXML private Pane principalPane;
    private TextField nameField, nitField, emailField;
    private Label validNameLabel, validNitLabel, validEmailLabel;
    private boolean isNameValid, isNitValid, isEmailValid;
    private Client client;
    private DBOrders dbOrders;
    private ArrayList<Order> orders;

    /**
     * The constructor method
     */
    public ClientController() {
        dbOrders = new DBOrders();
    }

    /**
     * This method initializes all the ui components to ask the client information
     */
    @FXML
    public void initialize() {
        setNameField();
        setNitField();
        setEmailField();
    }

    /**
     * This method receives the action when the button continue is pressed to call the verify methods modifying the client information
     * @param event when the button continue is pressed
     * @throws IOException when the fxml file of the next screen can not be loaded
     */
    @FXML
    public void continueAction(ActionEvent event) throws IOException {
        resetAlertLabels();
        setClientInformation();
        verifyInformationToContinue(event);
    }

    /**
     * Method to reset the alert labels of the verification results
     */
    private void resetAlertLabels() {
        principalPane.getChildren().removeAll(validNameLabel,validNitLabel,validEmailLabel);
    }

    /**
     * Method to verify if the information inserted is valid to go to the Invoice scene updating the information
     * @param event the action when continue button is pressed
     * @throws IOException when the fxml file can not be loaded
     */
    private void verifyInformationToContinue(ActionEvent event) throws IOException {
        if (isNameValid && isNitValid && isEmailValid) {

            FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("InvoiceView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);

            InvoiceController invoiceController = fxmlLoader.getController();
            invoiceController.updateDBOrders(dbOrders);

            orders = dbOrders.orders;

            Invoice invoice = new Invoice(client,orders);
            invoiceController.updateInvoiceInformation(invoice);
            invoiceController.initialize();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

            stage.setTitle("Invoice");
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Method to go back to the previous screen
     * @param event when the "go back" button is pressed
     * @throws IOException when the fxml file can not be loaded
     */
    @FXML
    public void goBackAction(ActionEvent event) throws IOException {

    }

    /**
     * This method update the dbOrders to the received one from previous screen
     * @param dbOrders the updated dbOrders
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method update the orders' information to the received one from previous screen
     * @param orders the updated orders information
     */
    public void updateClientOrders(ArrayList<Order> orders){
        this.orders = orders;
    }

    /**
     * Method to instance a client
     */
    private void instanceClient() {
        client = new Client();
    }

    /**
     * Method to set the client information with the validations of the information inserted
     */
    private void setClientInformation() {
        instanceClient();
        validateClientInformation();
    }

    /**
     * Method to validate or verify the client information received
     */
    private void validateClientInformation() {
        validateNameInserted();
        validateNitInserted();
        validateEmailInserted();
    }

    /**
     * Method to validate the name inserted
     * if the client doesn't give a name the name will be "No Name" but if the client inserts a name,
     * and it doesn't pass the validation test an alert label will be displayed
     * when the user inserts a good name without numbers or symbols the client name will be modified with the
     * name inserted
     */
    private void validateNameInserted() {
        if (nameField.getText().isEmpty()) {
            client.setName("No Name");
            isNameValid = true;
        }
        else if (RegularExpression.getRegularExpression().validateLetters(nameField.getText())) {
            validNameLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                    "Insert a valid name",300,30,
                    Pos.CENTER_LEFT,785,180,20);
            validNameLabel.getStyleClass().add("alertLabelStyle");
            principalPane.getChildren().add(validNameLabel);
            isNameValid = false;
        }
        else {
            client.setName(nameField.getText());
            isNameValid = true;
        }
    }
    /**
     * Method to validate the nit inserted
     * if the client doesn't give a nit the nit will be "No Nit" but if the client inserts a nit,
     * and it doesn't pass the validation test an alert label will be displayed
     * when the user inserts a good nit without letters or symbols the client nit will be modified with the
     * nit inserted
     */
    private void validateNitInserted() {
        if (nitField.getText().isEmpty()) {
            client.setNit("No Nit");
            isNitValid = true;
        }
        else if (RegularExpression.getRegularExpression().validateNumbers(nitField.getText())) {
            validNitLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                    "Insert a valid nit",300,30,
                    Pos.CENTER_LEFT,785,370,20);
            validNitLabel.getStyleClass().add("alertLabelStyle");
            principalPane.getChildren().add(validNitLabel);
            isNitValid = false;
        }
        else {
            client.setNit(nitField.getText());
            isNitValid = true;
        }
    }
    /**
     * Method to validate the email inserted
     * if the client doesn't give an email the name will be "No Email" but if the client inserts email,
     * and it doesn't pass the validation test an alert label will be displayed
     * when the user inserts a good email without numbers or symbols the client email will be modified with the
     * email inserted
     */
    private void validateEmailInserted() {
        if (emailField.getText().isEmpty()) {
            client.setEmail("No Email");
            isEmailValid = true;
        }
        else if (!RegularExpression.getRegularExpression().validateEmail(emailField.getText())) {
            validEmailLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                    "Insert a valid email address",300,30,
                    Pos.CENTER_LEFT,785,550,20);
            validEmailLabel.getStyleClass().add("alertLabelStyle");
            principalPane.getChildren().add(validEmailLabel);
            isEmailValid = false;
        }
        else {
            client.setEmail(emailField.getText());
            isEmailValid = true;
        }
    }

    /**
     * This method sets the field where the client would insert his or her name
     * Giving style classes, width, height and position
     */
    private void setNameField() {
        Label nameLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                "INSERT YOUR NAME \n          (optional)",350,100,
                Pos.CENTER,400,80,35);
        nameLabel.getStyleClass().add("subtitleLabels");
        nameField = JavaFXComponents.getJavaFXComponents().createTextField("Jefferson Vie..",
                390,40, Pos.CENTER,375,180
        );
        nameField.getStyleClass().add("textFieldStyle");
        principalPane.getChildren().addAll(nameLabel,nameField);
    }
    /**
     * This method sets the field where the client would insert his or her nit
     * Giving style classes, width, height and position
     */
    private void setNitField() {
        Label nitLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                "INSERT YOUR NIT \n         (optional)",350,100,
                Pos.CENTER,390,260,35);
        nitLabel.getStyleClass().add("subtitleLabels");
        nitField = JavaFXComponents.getJavaFXComponents().createTextField("93546...",
                390,40, Pos.CENTER,375,360
        );
        nitField.getStyleClass().add("textFieldStyle");
        principalPane.getChildren().addAll(nitLabel,nitField);
    }
    /**
     * This method sets the field where the client would insert his or her email
     * Giving style classes, width, height and position
     */
    private void setEmailField() {
        Label emailLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                "INSERT YOUR EMAIL \n           (optional)",
                350,100,
                Pos.CENTER,400,450,35);
        Label descriptionLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                "(the invoice will be sent to your email)",
                450,40,
                Pos.CENTER_LEFT,390,590,25);
        emailLabel.getStyleClass().add("subtitleLabels");
        descriptionLabel.getStyleClass().add("subtitleLabels");

        emailField = JavaFXComponents.getJavaFXComponents().createTextField("jefftheKiller@g...",
                390,40, Pos.CENTER,375,550
        );
        emailField.getStyleClass().add("textFieldStyle");
        principalPane.getChildren().addAll(emailLabel,descriptionLabel,emailField);
    }
}
