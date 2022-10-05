package com.example.pizasson.Controller;

import com.example.pizasson.Controller.Payments.PaymentController;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Stages.ClientInformationStage;
import com.example.pizasson.Stages.PizassonScreenStage;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to a le to handle the buttons , view tablets where the order can be visualized.
 *
 */
public class OrderController {
    /**
     * Is a Button to confirm an order
     */
    public Button confirmOrder;

    /**
     * A TableView FXML to display the list of orders
     */
    @FXML
    private TableView<Order> tableOrders;

    /**
     * The column of the table contains the title of the orders
     */
    @FXML
    private TableColumn<Order, String> columnOrderTitle;
    /**
     * The column of the table contains the unitary price of the orders
     */
    @FXML
    private TableColumn<Order, String> columnUnitaryCost;

    /**
     * The column of the table contains the quantity of the orders
     */
    @FXML
    private TableColumn<Order, String> columnQuantity;
    /**
     * The column of the table contains the description of the orders
     */
    @FXML
    private TableColumn<Order, String> columnDescriptionOrder;
    /**
     * Is the list of customer orders
     */
    private ArrayList<Order> ordersClient;
    /**
     * The total cost label in the view
     */
    @FXML private Label totalCostLabel;

    /**
     * The dbOrders with all user orders in different screens
     */
    private DBOrders dbOrders;

    /**
     * This is the constructor method
     *
     * Here we will initialize the database of orders and the list of orders
     */
    public OrderController()
    {
        ordersClient = new ArrayList<>();
        dbOrders = new DBOrders();
    }

    /**
     * This method is responsible for adding objects of type order to the table
     */
    private void addOrdersInformationToTable(){
        for (Order order :ordersClient){
            tableOrders.getItems().add(order);
        }
    }


    /**
     * This method is responsible for deleting the entire list
     */
    public void deleteOrders(ActionEvent actionEvent) throws Exception{
        ordersClient.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("Home Order");
        stage.setScene(scene);
        stage.show();
        }

    /**
     * This method is responsible for displaying the corresponding
     * elements in each column of the table.
     */
    private void setTableColumnsCells(){
        columnOrderTitle.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getOrderTitle())));
        columnDescriptionOrder.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescriptionOrder()));
        columnUnitaryCost.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getUnitaryCost())));
        columnQuantity.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getQuantity())));

    }
    /**
     * This method update the dbOrders to the received one from previous screen
     * @param dbOrders the updated dbOrders
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method update the orders information to the received one from previous screen
     * @param orders the updated orders information
     */
    public void updateClientOrders(ArrayList<Order> orders){
        this.ordersClient = orders;
    }

    /**
     * This method will be in charge of managing the navigation when user ends to order from the menu
     * It will send the new orders data to Home Order
     */
    @FXML
    private void navigateToModifyOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("ModifyOrdersView.fxml"));
        Scene modifyOrdersScene = new Scene(fxmlLoader.load(), 1100, 700);

        ModifyOrdersController modifyOrdersController = fxmlLoader.getController();
        modifyOrdersController.updateDBOrders(dbOrders);
        modifyOrdersController.restartMenuUI();

        Stage homeOrderStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homeOrderStage.setTitle("Modify Orders");
        homeOrderStage.setScene(modifyOrdersScene);
        homeOrderStage.show();
    }

    /**
     * This method navigates to payment view
     * @param event the button pressed event
     * @throws IOException in case the view fxml can't load or is not founded
     */
    @FXML
    private void confirmOrderToPay(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("ClientInformationView.fxml"));
        Scene clientInformationScene = new Scene(fxmlLoader.load(), 1100, 700);

        ClientController clientController = fxmlLoader.getController();
        clientController.updateDBOrders(dbOrders);

        Stage pizzasonStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String css1 = String.valueOf(ClientInformationStage.class.getResource("clientInformationView.css"));
        String css2 = String.valueOf(ClientInformationStage.class.getResource("generalStyle.css"));
        clientInformationScene.getStylesheets().addAll(css1, css2);

        pizzasonStage.setTitle("INVOICE INFORMATION");
        pizzasonStage.setScene(clientInformationScene);
        pizzasonStage.show();
    }

    /**
     * This method navigates to home order in case user press go back button
     * @param event the button action event
     * @throws IOException in case the view fxml is not loaded or founded
     */
    @FXML
    private void goToHomeOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
        Scene homeOrderScene = new Scene(fxmlLoader.load(), 1100, 700);

        HomeOrderController homeOrderController = fxmlLoader.getController();
        homeOrderController.updateDBOrders(dbOrders);

        Stage homeOrderStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homeOrderStage.setTitle("Home Order");
        homeOrderStage.setScene(homeOrderScene);
        homeOrderStage.show();
    }

    /**
     * This method gets the total cost of all orders
     * @return the orders total cost
     */
    private double getTotalCostOrders(){
        double totalCostOrders = 0;
        for (Order order : ordersClient){
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
     * This method initializes the controller
     *
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @FXML
    public void initialize() {
        addOrdersInformationToTable();
        setTableColumnsCells();
        setTotalCostLabel();
    }
}