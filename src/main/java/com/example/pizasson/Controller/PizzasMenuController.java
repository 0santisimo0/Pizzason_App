package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBMenu;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Model.pizza.PizzasMenu;
import com.example.pizasson.Model.pizza.PredefinedPizza;
import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Menu Controller for the menu pizzas menu management
 *
 */
public class PizzasMenuController {
    /**
     * The model pizzasMenu
     */
    private PizzasMenu pizzasMenu;
    /**
     * A FXML Pane to manage the view in the controller
     */
    @FXML
    private Pane menuPane;

    /**
     * The GridPane which will contain all the pizzas to distribute them in a good way in the screen space
     */
    private GridPane pizzasMenuGrid;

    /**
     * The all orders database simulation
     */
    private DBOrders dbOrders;

    /**
     * quantityOrders hashmap to manage quantity orders for each product
     */
    private HashMap<String, Integer> quantityOrders;
    /**
     * Controller for pizza model
     */
    private final PizzaController pizzaController;

    /**
     * Class constructor.
     * It initializes the attributes and obtains the predefinedPizzas from the DataBase
     */
    public PizzasMenuController(){
        pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);
        pizzasMenuGrid = new GridPane();
        dbOrders = new DBOrders();
        pizzaController = new PizzaController();
        quantityOrders = dbOrders.getQuantityOrders();
    }

    /**
     * This method will be in charge of managing the navigation when user ends to order from the menu
     * It will send the new orders data to Home Order
     */
    @FXML
    private void continueWithOrderOutOfMenu(ActionEvent event) throws IOException {
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
     * This method restarts the pizzas menu UI to re-render the components
     * @throws FileNotFoundException in case pizza image source is not founded
     */

    public void restartMenuUI() throws FileNotFoundException {
        pizzasMenuGrid = new GridPane();
        pizzasMenuGrid.getChildren().clear();
        menuPane.getChildren().clear();
        initialize();
    }

    /**
     * This method manages the pizza order quantity to update the database
     * @param currentOrder the current pizza order made by the user
     */
    private void managePizzaOrderQuantity(Order currentOrder, int quantityToAdd){
        boolean wasTheOrderMadePreviously = false;

        for (int i = 0; i < dbOrders.orders.size(); i++){
            Order dbOrder = dbOrders.orders.get(i);
            if (dbOrder.getOrderTitle().equalsIgnoreCase(currentOrder.getOrderTitle())){
                dbOrder.setQuantity(dbOrder.getQuantity() + quantityToAdd);
                currentOrder.setQuantity(dbOrder.getQuantity());
                if (dbOrder.getQuantity() == 0) dbOrders.orders.remove(dbOrder);
                wasTheOrderMadePreviously = true;
            }
        }
        if (!wasTheOrderMadePreviously && quantityToAdd > 0) dbOrders.orders.add(currentOrder);
        else if (!wasTheOrderMadePreviously && quantityToAdd < 0) currentOrder.setQuantity(0);
    }

    /**
     * This method gets the new Order made by user to add to the database
     * @param predefinedPizza the pizza ordered by the user
     * @param pizzaSize the pizza size ordered
     * @return the new Order Object
     */
    private Order getNewOrder(PredefinedPizza predefinedPizza, PizzaSizable pizzaSize){
        return new Order(
                predefinedPizza.getName() + " " + pizzaSize.getSizeName().toLowerCase(),
                pizzaController.getPizzaIngredientsInfo(predefinedPizza), 1,
                pizzaSize.getPriceSize(predefinedPizza.getIngredients())
        );
    }

    /**
     * This method manages a new pizza order when one of the buttons to order a pizza is pressed
     * @param predefinedPizza the pizza ordered
     * @param pizzaSize the pizza ordered size
     * @param quantityToAdd the quantityToAdd to the pizza ordered
     */
    private void addToOrderPressedButton(PredefinedPizza predefinedPizza, PizzaSizable pizzaSize, int quantityToAdd) throws FileNotFoundException {
        manageNewPizzaOrder(getNewOrder(predefinedPizza, pizzaSize), quantityToAdd);
    }

    /**
     * This method manages a new pizza order when one of the buttons to order a pizza is pressed
     * @param currentOrder is the current order made by the user
     */
    private void manageNewPizzaOrder(Order currentOrder, int quantityToAdd) throws FileNotFoundException {
        if (!(pizzasMenu.getPizzasOrderedNumber() == 0 && quantityToAdd < 0)) pizzasMenu.addOnePizzaOrdered(quantityToAdd);

        managePizzaOrderQuantity(currentOrder, quantityToAdd);
        quantityOrders.put(currentOrder.getOrderTitle().toLowerCase(), currentOrder.getQuantity());
        dbOrders.setQuantityOrders(quantityOrders);

        restartMenuUI();
    }

    /**
     * This method creates a button using JavaFxComponents to order a pizza depending on its size
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza the button is for
     * @param pizzaIndex the index of the pizza to align it in Y
     * @return the button created
     */
    private Button createAddPizzaSizeButton(PredefinedPizza predefinedPizza, int pizzaIndex){
        Button pizzaSizeButton = JavaFXComponents.getJavaFXComponents().createButton(
                "Add +1", pizzaIndex * 33 + 190, 180, "#00ab66", 13
        );
        pizzaSizeButton.setOnAction(e -> {
            try {
                addToOrderPressedButton(predefinedPizza, pizzasMenu.getPizzaSizes().get(pizzaIndex), 1);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return pizzaSizeButton;
    }

    /**
     * This method creates a button using JavaFxComponents to subtract an order made before
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza the button is for
     * @param pizzaIndex the index of the pizza to align it in Y
     * @return the button created
     */
    private Button createSubtractPizzaSizeButton(PredefinedPizza predefinedPizza, int pizzaIndex){
        Button pizzaSizeButton = JavaFXComponents.getJavaFXComponents().createButton(
                "Subtract -1", pizzaIndex * 33 + 190, 255, "#dc3545", 13
        );
        pizzaSizeButton.setOnAction(e -> {
            try {
                addToOrderPressedButton(predefinedPizza, pizzasMenu.getPizzaSizes().get(pizzaIndex), -1);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        return pizzaSizeButton;
    }

    /**
     * This method returns a Pane with the Buttons of pizza sizes options inserted
     * @param predefinedPizza the current pizza of the menu to insert the Buttons
     * @param pizzaPane the current pizza pane in which the Buttons will be inserted
     * @return the Pane with the Buttons
     */
    private Pane getPaneWithPizzaSizesButtons(PredefinedPizza predefinedPizza, Pane pizzaPane){
        for (int i = 0; i < pizzasMenu.getPizzaSizes().size(); i++){
            pizzaPane.getChildren().add(createAddPizzaSizeButton(predefinedPizza, i));
            pizzaPane.getChildren().add(createSubtractPizzaSizeButton(predefinedPizza, i));
        }
        return pizzaPane;
    }

    /**
     * This method creates a Label with the pizza name using JavaFXComponents
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza in the menu to create the Label for
     * @return the Label created
     */
    private Label createPizzaNameLabel(PredefinedPizza predefinedPizza){
        Label pizzaNameLabel = JavaFXComponents.getJavaFXComponents().createLabel(
            predefinedPizza.getName(), 250, 40, Pos.BOTTOM_CENTER, 0, 0, 16
        );
        pizzaNameLabel.setStyle("-fx-font-weight: bold");
        return pizzaNameLabel;
    }

    /**
     * This method creates a Label that will display all the pizza ingredients information
     * @param predefinedPizza the pizza to display the ingredients for
     * @return the Label created
     */
    private Label createPizzaIngredientsInfo(PredefinedPizza predefinedPizza){
        return JavaFXComponents.getJavaFXComponents().createLabel(
                pizzaController.getPizzaIngredientsInfo(predefinedPizza), 150, 100, Pos.CENTER, 185, 55, 10
        );
    }

    /**
     * This method creates an image for each pizza in the menu with its respective source using JavaFxComponents
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza which the image will be for
     * @return the image created
     * @throws FileNotFoundException in case the image source is not founded
     */
    private ImageView createPizzaImage(PredefinedPizza predefinedPizza) throws FileNotFoundException {
        return JavaFXComponents.getJavaFXComponents().createImage(
            predefinedPizza.getImageSource(), 180, 135, 20, 45
        );
    }

    /**
     * This method get the pizza sizes options name and price
     * @param predefinedPizza the current pizza in the menu to get this info.
     * @return a String with the pizza sizes option information
     */
    private String getPizzasSizesInfo(PredefinedPizza predefinedPizza){
        ArrayList<PizzaSizable> pizzaSizes = pizzasMenu.getPizzaSizes();
        StringBuilder pizzaSizesInfo = new StringBuilder();
        for (PizzaSizable pizzaSize : pizzaSizes) {
            pizzaSizesInfo.append("\n\n").append(pizzaSize.getSizeName()).
                append(": Bs. ").append(pizzaSize.getPriceSize(predefinedPizza.getIngredients()));
        }
        return pizzaSizesInfo.toString();
    }

    /**
     * This method creates a Label with the pizza sizes information to show in view using JavaFxComponents
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza in the menu the Label is for
     * @return the Label created
     */
    private Label createPizzasSizePricesLabel(PredefinedPizza predefinedPizza){
        return JavaFXComponents.getJavaFXComponents().createLabel(
                getPizzasSizesInfo(predefinedPizza), 150, 140,
                Pos.CENTER_RIGHT,  20, 150, 13
        );
    }

    private void createQuantityOrderLabels(PredefinedPizza predefinedPizza, Pane pizzaPane){
        for (int i = 0; i < pizzasMenu.getPizzaSizes().size(); i++){
            int finalI = i;
            quantityOrders.forEach((key, value) -> {
                if (key.contains(predefinedPizza.getName().toLowerCase()) &&
                        key.contains(pizzasMenu.getPizzaSizes().get(finalI).getSizeName().toLowerCase())
                ){
                    Label label = JavaFXComponents.getJavaFXComponents().createLabel(
                            String.valueOf(value), 20, 20,
                            Pos.CENTER,  20, finalI * 31 + 195, 13
                    );
                    label.setStyle("-fx-background-color: #ca352a; -fx-text-fill: #fff; -fx-background-radius: 5");
                    pizzaPane.getChildren().add(label);
                }
            });
        }
    }

    /**
     * Creates a Pane that will be a container to display each pizza in the menu information and order buttons
     * It calls to the others method for interacting in the view to add in the pane
     * @see JavaFXComponents
     * @param predefinedPizza the current pizza the Pane is for
     * @return the Pane created
     * @throws FileNotFoundException in case the pizza image source is not founded
     */
    private Pane createPizzaMenuPane(PredefinedPizza predefinedPizza) throws FileNotFoundException {
        Pane pizzaPane = JavaFXComponents.getJavaFXComponents().createPane(365, 280);

        createQuantityOrderLabels(predefinedPizza, pizzaPane);
        pizzaPane = getPaneWithPizzaSizesButtons(predefinedPizza, pizzaPane);
        pizzaPane.getChildren().add(createPizzaImage(predefinedPizza));
        pizzaPane.getChildren().add(createPizzaNameLabel(predefinedPizza));
        pizzaPane.getChildren().add(createPizzaIngredientsInfo(predefinedPizza));
        pizzaPane.getChildren().add(createPizzasSizePricesLabel(predefinedPizza));

        return pizzaPane;
    }

    /**
     * This method adds a pizza pane to the grid to display all of them in a kind of table in the screen
     * @param indexList the index of the current pizza pane in the ArrayList obtained from DataBase
     * @param pizzaPane the current pizza pane to insert in the grid
     * @param listSize the size of predefined pizzas options in the menu
     */
    private void addPizzaPaneToMenuGrid(int indexList, Pane pizzaPane, int listSize){
        if(indexList < listSize / 2) pizzasMenuGrid.add(pizzaPane,  indexList, 0);
        else pizzasMenuGrid.add(pizzaPane,  indexList - (listSize / 2), 1);
    }

    /**
     * This method will be used to update the database orders to the one received from the HomeOrder
     * with all the orders from the different screens
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders) throws FileNotFoundException {
        this.dbOrders = dbOrders;
        this.quantityOrders = dbOrders.quantityOrders;
    }

    /**
     * This method adds quantity pizza orders data to the Hashmap quantityOrders
     * @param predefinedPizza the current pizza to add its sizes data
     */
    private void setQuantityOrderValues(PredefinedPizza predefinedPizza){
        int totalPizzasOptionsToOrder = pizzasMenu.getPizzaSizes().size() * pizzasMenu.getPredefinedPizzas().size();
        for (PizzaSizable pizzaSizable : pizzasMenu.getPizzaSizes()){
            String pizzaKey = predefinedPizza.getName().toLowerCase() + " " + pizzaSizable.getSizeName().toLowerCase();
            if (quantityOrders.size() < totalPizzasOptionsToOrder) quantityOrders.put(pizzaKey, 0);
        }
    }

    /**
     * This method will be called when the view is rendered.
     * It calls the different above methods to show all the required menu information
     * @throws FileNotFoundException in case some pizza image sources is not founded
     */
    public void initialize() throws FileNotFoundException {
        ArrayList<PredefinedPizza> predefinedPizzas = pizzasMenu.getPredefinedPizzas();

        for (int i = 0; i < predefinedPizzas.size(); i++) {
            PredefinedPizza predefinedPizza = predefinedPizzas.get(i);
            setQuantityOrderValues(predefinedPizza);

            Pane pizzaPane = createPizzaMenuPane(predefinedPizza);
            addPizzaPaneToMenuGrid(i, pizzaPane, predefinedPizzas.size());
        }

        menuPane.getChildren().add(pizzasMenuGrid);
    }
}
