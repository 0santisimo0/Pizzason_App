package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Invoice;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Stages.ClientInformationStage;
import com.example.pizasson.Stages.PizassonScreenStage;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class is the controller for the invoice printing
 */
public class InvoiceController {
    /**
     * The table orders in invoice view
     */
    @FXML private TableView<Order> ordersTable;
    /**
     * The order quantity column in invoice view
     */
    @FXML private TableColumn<Order, String> orderQuantity;
    /**
     * The order title column in invoice view
     */
    @FXML private TableColumn<Order, String> orderTitle;
    /**
     * The order unitary cost column in invoice view
     */
    @FXML private TableColumn<Order, String> orderUnitaryCost;
    /**
     * The order subtotal cost column in invoice view
     */
    @FXML private TableColumn<Order, String> orderSubTotal;
    /**
     * The invoice model
     */
    private Invoice invoice;
    /**
     * The dbOrders with all orders data
     */
    private DBOrders dbOrders;
    /**
     * The invoice id label in the view
     */
    @FXML private Label invoiceIdLabel;
    /**
     * The invoice location and date label in the view
     */
    @FXML private Label locationDateLabel;
    /**
     * The client name label in the view
     */
    @FXML private Label clientNameLabel;
    /**
     * The client nit label in the view
     */
    @FXML private Label clientNitLabel;
    /**
     * The total cost label in the view
     */
    @FXML private Label totalCostLabel;
    /**
     * The wait order time label in the view
     */
    @FXML private Label waitOrderTimeLabel;

    /**
     * Class constructor initializing the invoice and dbOrders
     */
    public InvoiceController(){
        invoice = new Invoice();
        dbOrders = new DBOrders();
    }

    /**
     * This method sets the invoice id label text to the invoice id model
     */
    private void setInvoiceIdLabel(){
        invoice.setInvoiceId((int) (Math.random() * 99999999 + 11111111));
        invoiceIdLabel.setText("Invoice Nº " + invoice.getInvoiceID());
    }

    /**
     * This method gets the wait time of all orders in minutes
     * It multiplies all quantities by 8 min
     * @return the wait time orders in minutes
     */
    private int getWaitTimeInMinutes(){
        int totalQuantity = 0;
        for (Order order : invoice.getOrders()){
            totalQuantity += order.getQuantity();
        }
        return totalQuantity * 8;
    }

    /**
     * This method checks if the wait orders time is less than an hour
     * @return the compilation wait time orders less than 60
     */
    private boolean checkIfWaitOrderTimeIsLessThanAnHour(){
        return getWaitTimeInMinutes() < 60;
    }

    /**
     * This method will be in charge of managing the navigation when the user wants to fill the data again.
     *
     * @param actionEvent the button Continue action event
     * @throws IOException when a fxml file can not be loaded
     */
    @FXML
    public void goBackAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("ClientInformationView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        ClientController clientController = fxmlLoader.getController();

        clientController.updateDBOrders(dbOrders);
        clientController.updateClientOrders(dbOrders.orders);

        String css1 = String.valueOf(ClientInformationStage.class.getResource("clientInformationView.css"));
        String css2 = String.valueOf(ClientInformationStage.class.getResource("generalStyle.css"));

        scene.getStylesheets().addAll(css1,css2);

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("INVOICE INFORMATION");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * This method gets a concatenated message with the wait time order
     * @return the wait order time message
     */
    private String getWaitOrderTimeMessage(){
        String waitOrderTimeMessage = "Wait time: " + getWaitTimeInMinutes() + " hours";
        if (!checkIfWaitOrderTimeIsLessThanAnHour()){
            int hours = getWaitTimeInMinutes() / 60;
            int leftMinutes = getWaitTimeInMinutes() % 60;
            waitOrderTimeMessage = "Wait time: " + hours + " hour(s)";
            waitOrderTimeMessage += leftMinutes != 0 ? " and " + leftMinutes + " minutes" : "";
        }
        return waitOrderTimeMessage;
    }

    /**
     * This method sets the wait order time label text to the wait order gotten from orders quantity
     */
    private void setWaitOrderTimeLabel() {
        waitOrderTimeLabel.setText(getWaitOrderTimeMessage());
    }

    /**
     * This method sets the location date label text to the location concatenated to the current date
     */
    private void setCurrentLocationDateLabel(){
        String pattern = "MMMMM dd, yyyy";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern, new Locale("en", "BO"));

        String currentDate = simpleDateFormat.format(new Date());
        locationDateLabel.setText("Cochabamba " + currentDate);
    }

    /**
     * This method will be in charge of managing the navigation when user ends to see the invoice.
     * It won't send the new orders data to Home Order because the order is finished.
     *
     * @param actionEvent the button Continue action event
     * @throws IOException when a fxml file can not be loaded
     */
    @FXML
    public void finishInvoice(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("Home Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method adds the orders information to the table
     */
    private void addOrdersInformationToTable(){
        for (Order order : invoice.getOrders()){
            ordersTable.getItems().add(order);
        }
    }

    /**
     * This method gets the total cost of all orders
     * @return the orders total cost
     */
    private double getTotalCostOrders(){
        double totalCostOrders = 0;
        for (Order order : invoice.getOrders()){
            double subTotalOrder = order.getQuantity() *order.getUnitaryCost();
            totalCostOrders += subTotalOrder;
        }
        return totalCostOrders;
    }

    /**
     * This method sets the total cost label to the string returned in getTotalCostOrders()
     */
    private void setTotalCostLabel(){
        totalCostLabel.setText("TOTAL: BS. " + getTotalCostOrders());
    }

    /**
     * This method sets the client name label to the client name attribute object in invoice
     */
    private void setClientNameLabel(){
        clientNameLabel.setText("TO: " + invoice.getClient().getName());
    }

    /**
     * This method sets the client nit label to the client nit attribute object in invoice
     */
    private void setClientNitLabel(){
        clientNitLabel.setText("NIT: " + invoice.getClient().getNit());
    }

    /**
     * This method sets the cells value factory to their corresponding attribute in the invoice
     */
    private void setTableColumnsCells(){
        orderQuantity.setCellValueFactory(cell -> new SimpleStringProperty(
                String.valueOf(cell.getValue().getQuantity()))
        );
        orderTitle.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOrderTitle()));
        orderUnitaryCost.setCellValueFactory(cell -> new SimpleStringProperty(
                String.valueOf(cell.getValue().getUnitaryCost())
        ));
        orderSubTotal.setCellValueFactory(cell -> new SimpleStringProperty(
                String.valueOf(cell.getValue().getQuantity() * cell.getValue().getUnitaryCost())
        ));
    }

    /**
     * This method is to initialize FXML method to start the components
     */
    @FXML
    public void initialize() {
        addOrdersInformationToTable();
        setTableColumnsCells();
        setCurrentLocationDateLabel();
        setTotalCostLabel();
        setInvoiceIdLabel();
        setWaitOrderTimeLabel();
        setClientNameLabel();
        setClientNitLabel();
    }

    /**
     * This method update the dbOrders to the received one from previous screen
     * @param dbOrders the updated dbOrders
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method update the Invoice information to the received one from previous screen
     * @param invoice the updated invoice information
     */
    public void updateInvoiceInformation(Invoice invoice){
        this.invoice = invoice;
    }

}
