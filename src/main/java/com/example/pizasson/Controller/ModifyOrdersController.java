package com.example.pizasson.Controller;

import com.example.pizasson.Controller.Payments.PaymentController;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.DataBase.ModifyOrders;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Stages.ClientInformationStage;
import com.example.pizasson.Stages.PizassonScreenStage;
import com.example.pizasson.utils.JavaFXComponents;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is the controller to manage modify orders
 *
 */
public class ModifyOrdersController {
    /**
     * The ordersPane in the view to add content depending on the orders
     */
    @FXML
    private Pane ordersPane;

    /**
     * The all orders database simulation
    */
    private DBOrders dbOrders;

    /**
     * Modify orders model
     */
    ModifyOrders modifyOrders;
    /**
     * The total cost label in the view
     */
    @FXML private Label totalCostLabel;

    /**
     * Class constructor that initializes the ordersPane the dbOrders and the model
     */
    public ModifyOrdersController(){
        ordersPane = new Pane();
        dbOrders = new DBOrders();
        modifyOrders = new ModifyOrders();
    }

    /**
     * This method manages the order quantity to update the database
     * @param currentOrder the current pizza order made by the user
     */
    private void managePizzaOrderQuantity(Order currentOrder, int quantityToAdd){
        currentOrder.setQuantity(currentOrder.getQuantity() + quantityToAdd);
        if (currentOrder.getQuantity() == 0) modifyOrders.getOrders().remove(currentOrder);

        if (currentOrder.getQuantity() == 0) modifyOrders.getOrders().remove(currentOrder);
        dbOrders.setOrders(modifyOrders.getOrders());
    }

    /**
     * This method restarts the UI to re-render the components
     */

    public void restartMenuUI() {
        ordersPane.getChildren().clear();
        initialize();
    }

    /**
     * This method manages a new order when one of the buttons to order is pressed
     * @param currentOrder is the current order made by the user
     * @param quantityToAdd the quantityToAdd to the pizza ordered
     */
    private void manageNewPizzaOrder(Order currentOrder, int quantityToAdd) throws FileNotFoundException {
        managePizzaOrderQuantity(currentOrder, quantityToAdd);
        restartMenuUI();
    }

    /**
     * This method deletes the order received
     * @param orderIndex the index order made by the user in orders in the dbOrders
     */
    private void deleteOrder(int orderIndex){
        modifyOrders.getOrders().remove(orderIndex);
        dbOrders.setOrders(modifyOrders.getOrders());
        restartMenuUI();
    }

    /**
     * This method creates a button using JavaFxComponents to add an order made before
     * @see JavaFXComponents
     * @param order the current order the button is for
     * @param orderIndex the index of the order to align it in Y
     * @return the button created
     */
    private Button createAddOrderButton(Order order, int orderIndex){
        Button addOrderButton = JavaFXComponents.getJavaFXComponents().createButton(
                "Add +1", orderIndex * 100 + 38, 800, "#00ab66", 13
        );
        addOrderButton.setOnAction(e -> {
            try {
                manageNewPizzaOrder(order, 1);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return addOrderButton;
    }

    /**
     * This method creates a button using JavaFxComponents to subtract an order made before
     * @see JavaFXComponents
     * @param order the current order the button is for
     * @param orderIndex the index of the order to align it in Y
     * @return the button created
     */
    private Button createSubtractOrderButton(Order order, int orderIndex){
        Button subtractOrderButton = JavaFXComponents.getJavaFXComponents().createButton(
                "Subtract -1", orderIndex * 100 + 38, 877, "#dc3545", 13
        );
        subtractOrderButton.setOnAction(e -> {
            try {
                manageNewPizzaOrder(order, -1);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return subtractOrderButton;
    }

    /**
     * This method creates a button using JavaFxComponents to delete an order made before
     * @see JavaFXComponents
     * @param orderIndex the index of the order to align it in Y
     * @return the button created
     */
    private Button createDeleteOrderButton(int orderIndex){
        Button deleteButton = JavaFXComponents.getJavaFXComponents().createButton(
                "Delete", orderIndex * 100 + 38, 977, "#ff2e2e", 13
        );
        deleteButton.setOnAction(e -> deleteOrder(orderIndex));
        return deleteButton;
    }

    /**
     * This method creates a Label with the order title information
     * @see JavaFXComponents
     * @param orderTitle the current order title text label
     * @return the Label created
     */
    private Label createOrderTitleLabel(String orderTitle, int orderIndex){
        Label orderTitleLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                orderTitle, 270, 100,
                Pos.CENTER, 20, orderIndex * 100, 16
        );
        orderTitleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        return orderTitleLabel;
    }

    /**
     * This method creates a Label with the order description information
     * @see JavaFXComponents
     * @param orderDescription the current order description text label
     * @return the Label created
     */
    private Label createOrderDescriptionLabel(String orderDescription, int orderIndex){
        return JavaFXComponents.getJavaFXComponents().createLabel(
                orderDescription, 250, 100,
                Pos.CENTER, 290, orderIndex * 100, 10
        );
    }

    /**
     * This method creates a label with the order quantity number
     * @param orderQuantity the order quantity
     * @param orderIndex the order index in arraylist orders in dbOrders
     * @return the label created
     */
    private Label createOrderQuantityLabel(int orderQuantity, int orderIndex){
        return JavaFXComponents.getJavaFXComponents().createLabel(
                String.valueOf(orderQuantity), 80, 100,
                Pos.CENTER, 550, orderIndex * 100, 16
        );
    }

    /**
     * This method creates a label with the order unitary cost
     * @param unitaryCost the order unitary cost
     * @param orderIndex the order index in arraylist orders in dbOrders
     * @return the label created
     */
    private Label createOrderUnitaryCostLabel(double unitaryCost, int orderIndex){
        return JavaFXComponents.getJavaFXComponents().createLabel(
                "Bs. " + unitaryCost, 120, 100,
                Pos.CENTER, 640, orderIndex * 100, 16
        );
    }

    /**
     * This method initializes the fxml components
     */
    @FXML
    public void initialize(){
        for (int i = 0; i < modifyOrders.getOrders().size(); i++){
            Order order = modifyOrders.getOrders().get(i);
            ordersPane.getChildren().add(createAddOrderButton(order, i));
            ordersPane.getChildren().add(createDeleteOrderButton(i));
            ordersPane.getChildren().add(createSubtractOrderButton(order, i));

            ordersPane.getChildren().add(createOrderTitleLabel(order.getOrderTitle(), i));
            ordersPane.getChildren().add(createOrderDescriptionLabel(order.getDescriptionOrder(), i));
            ordersPane.getChildren().add(createOrderQuantityLabel(order.getQuantity(), i));
            ordersPane.getChildren().add(createOrderUnitaryCostLabel(order.getUnitaryCost(), i));
        }
        setTotalCostLabel();
    }

    /**
     * This method deletes all orders and navigates to the home order screen
     * @param actionEvent the button pressed event
     * @throws IOException in case the view fxml is not founded
     */
    @FXML
    public void deleteAllOrders(ActionEvent actionEvent) throws IOException {
        dbOrders.orders.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setTitle("Home Order");
        stage.setScene(scene);
        stage.show();
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
     * This method update the dbOrders to the received one from previous screen
     * @param dbOrders the updated dbOrders
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
        modifyOrders.setOrders(dbOrders.orders);
    }

    /**
     * This method gets the total cost of all orders
     * @return the orders total cost
     */
    private double getTotalCostOrders(){
        double totalCostOrders = 0;
        for (Order order : modifyOrders.getOrders()){
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
}
