package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Model.pizza.Pizza;
import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
import com.example.pizasson.Stages.PizassonScreenStage;
import com.example.pizasson.utils.JavaFXComponents;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class modifies the ui elements of the PizzaCreationView to manage the creation of a pizza
 * the class has methods to modify or instance javafx components
 * in order of the client or user can create his o her own pizza
 *
 * @author Santiago Caballero
 */
public class PizzaCreationController {
    /**
     * VBox ids components in the fxml file
     */
    @FXML
    private VBox leftBox, rightBox2, rightBox1, downRightBox, ingredientInfoBox, pizzaInformationBox;
    /**
     * comboBoxes ids of the ingredients and the sizes of the pizza
     */
    @FXML
    private ComboBox<String> ingredientsBox, sizesBox;
    /**
     * The counter of pizzas created label
     */
    @FXML
    private Label counterLabel;
    /**
     * Buttons used on the ui to cancel or add an ingredient and to continue after the pizza creation
     */
    @FXML
    private Button cancelButton, addButton, continueButton;
    /**
     * Container of the options to add or cancel an ingredient
     */
    private HBox horizontalBox;
    /**
     * To set the size chosen by the user
     */
    private String sizeName;
    /**
     * The all orders database simulation
     */
    private DBOrders dbOrders;
    /**
     * the model of the class pizza
     */
    private final Pizza pizzaModel;
    /**
     * the pizzaController class is used just to show and update the pizzaInformation
     */
    private PizzaController pizzaController;
    /**
     * The constructor method where the pizzaModel is created
     */
    public PizzaCreationController() {
        pizzaModel = new Pizza("Personalized Pizza");
        dbOrders = new DBOrders();
    }

    /**
     * This method receives the ingredient chosen by the client on the ui and adds it to the model
     * the method compares if the ingredient chosen is on the list of ingredients to add it into the pizza ingredientsList
     */
    private void setPizzaIngredientsList() {
        String ingredientOption = ingredientsBox.getSelectionModel().getSelectedItem();
        for (PizzaIngredients ingredient: PizzaIngredients.values()) {
            if (ingredientOption.equalsIgnoreCase(ingredient.getName())) {
                pizzaModel.addIngredient(ingredient);
            }
        }
    }

    /**
     * The method enables the continue button just if the user has chosen a size and 3 o more ingredients
     */
    private void validateContinueButton() {
        if (pizzaModel.getSize() != null && pizzaModel.getIngredients().size() > 2) {
            continueButton.setDisable(false);
        }
    }
    /**
     * This method will be in charge of managing the navigation when user ends to create the pizza
     * It will send the new orders' data to Home Order
     *
     * @param event the button Continue action event
     * @throws IOException when a fxml file can not be loaded
     */
    @FXML
    public void orderPizzaAction(ActionEvent event) throws IOException {
        orderPizza();
        goBackAction(event);
    }

    /**
     * Method to go back to the previous screen
     * @param event when the "go back" button is pressed
     * @throws IOException when the fxml file can not be loaded
     */
    @FXML
    public void goBackAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);

        HomeOrderController homeOrderController = fxmlLoader.getController();
        homeOrderController.updateDBOrders(dbOrders);

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("Home Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method orders the pizza created when the continue button is pressed
     */
    private void orderPizza() {
        Order order = new Order(pizzaModel.getName(),"Size: "+pizzaModel.getSize()+"\n\n"+pizzaController.getPizzaIngredientsInfo(pizzaModel),1,pizzaModel.getPrice());

        dbOrders.pizzasCreatedOrders.add(order);
        dbOrders.orders.add(order);
    }

    /**
     * This method sets the counter label text with the size of pizzas created orders ArrayList
     * The method counts the pizzas created from the database to set the counter label
     */
    private void setCounterLabel() {
        counterLabel.getStyleClass().add("counterLabelStyle");
        counterLabel.setText("Pizzas Created orders: "+dbOrders.pizzasCreatedOrders.size());
        counterLabel.setAlignment(Pos.CENTER_RIGHT);
    }

    /**
     * This method is in charge of showing the confirmation box if the client wants to add an ingredient or not
     * The method calls the methods to create a label, an add button and a cancel button showing the ingredient chosen
     */
    @FXML
    public void showConfirmationBox() {
        ingredientsBox.setDisable(true);
        createCancelIngredientButton();
        createAddIngredientButton();
        setIngredientConfirmationBox(getIngredientChosenLabel());
        showIngredientInfo(ingredientsBox.getSelectionModel().getSelectedItem());
    }

    /**
     * This method returns the label of the ingredient chosen in the ingredients comboBox of the ui
     * @return ingredient chosen label
     */
    private Label getIngredientChosenLabel() {
        return JavaFXComponents.getJavaFXComponents()
                .createLabel(ingredientsBox.getSelectionModel().getSelectedItem(),
                        170,50,Pos.CENTER,0,0,15);
    }

    /**
     * This method sets the elements of the principal confirmation Vbox with the horizontalBox of the chosen ingredient, add button and cancel button
     * @param ingredientChosen to add into the horizontalBox with its confirmation buttons
     */
    private void setIngredientConfirmationBox(Label ingredientChosen) {
        horizontalBox = new HBox(30);
        horizontalBox.getChildren().addAll(ingredientChosen,addButton,cancelButton);
        horizontalBox.getStyleClass().add("confirmationIngredientBox");
        horizontalBox.setEffect(new DropShadow());
        leftBox.getChildren().add(horizontalBox);
    }

    /**
     * This method instances the cancel button providing a text and a style css class
     */
    private void createCancelIngredientButton() {
        cancelButton = new Button("Cancel");
        cancelButton.getStyleClass().add("buttonCancel");
        manageCancelActionEvent();
    }

    /**
     * This method manages the events are going to happen when the cancel button is pressed
     * When the cancel button is pressed the confirmation box and the ingredient info Box will be removed
     * The drop box is able again
     */
    private void manageCancelActionEvent() {
        cancelButton.setOnAction(event -> {
            leftBox.getChildren().remove(horizontalBox);
            rightBox1.getChildren().remove(ingredientInfoBox);
            ingredientsBox.setDisable(false);
        });
    }

    /**
     * This method instances the add button providing a text and a style css class
     */
    private void createAddIngredientButton() {
        addButton = new Button("Add");
        addButton.getStyleClass().add("buttonAdd");
        manageAddAction();
    }

    /**
     * This method will add an ingredient to the pizza ingredients list when the add button is pressed
     * When the add button is pressed the confirmation box and the ingredient info Box will be removed
     * The drop box is able again
     * The pizza Information box will be updated
     */
    private void manageAddAction() {
        addButton.setOnAction(event -> {
            leftBox.getChildren().remove(horizontalBox);
            rightBox1.getChildren().remove(ingredientInfoBox);
            ingredientsBox.setDisable(false);
            setPizzaIngredientsList();
            validateContinueButton();
            resetPizzaInformationBox();
        });
    }

    /**
     * This method updates the pizza information box with the new information received
     * first removes the pizzaInformationBox, then update the information of the model to show on its controller
     */
    private void resetPizzaInformationBox() {
        downRightBox.getChildren().remove(pizzaInformationBox);
        updatePizzaInfo();
        pizzaInformationBox = pizzaController.showPizzaInformation();
        downRightBox.getChildren().add(pizzaInformationBox);
    }

    /**
     * This method sets the model attributes with the elements given by the user on the ui
     * the method sets the prize and the size in the model with the information chosen by the client
     */
    private void updatePizzaInfo() {
        for (PizzaSizable pizzaSizable : pizzaModel.getPizzaSizes()) {
            if (sizeName != null && sizeName.equalsIgnoreCase(pizzaSizable.getSizeName())) {
                pizzaModel.setSize(pizzaSizable.getSizeName());
                pizzaModel.setPrice(pizzaSizable.getPriceSize(pizzaModel.getIngredients()));
            }
        }
        pizzaController = new PizzaController(pizzaModel);
    }

    /**
     * This method shows the ingredient information box chosen by the user
     * the method instances the ingredient controller to display its information
     * @param ingredientChosen the ingredient chosen for looking it into the ingredients data
     */
    private void showIngredientInfo(String ingredientChosen) {
        IngredientController ingredientController = new IngredientController();
        for (PizzaIngredients pizzaIngredient: PizzaIngredients.values()) {
            if (pizzaIngredient.getName().equalsIgnoreCase(ingredientChosen)) {
                ingredientInfoBox = ingredientController.showIngredientInformation(pizzaIngredient);
                rightBox1.getChildren().add(ingredientInfoBox);
            }
        }
    }

    /**
     * This method just shows a pizza image to give some style to the scene
     * @throws FileNotFoundException when the file is not found
     */
    private void showPizzaImage() throws FileNotFoundException {
        rightBox2.getChildren().clear();
        ImageView pizzaImgView = JavaFXComponents.getJavaFXComponents()
                .createImage("src/main/resources/images/pizzaLogo.png",
                        150,150,0,0);
        rightBox2.getChildren().add(pizzaImgView);
    }

    /**
     * This method fill the ingredients drop box items with the ingredients available
     */
    private void initializeIngredientsDropBar() {
        ObservableList<String> ingredientsNames = FXCollections.observableArrayList();
        for (PizzaIngredients ingredient: PizzaIngredients.values()) {
            ingredientsNames.add(ingredient.getName());
        }
        ingredientsBox.setItems(ingredientsNames);
    }

    /**
     * This method will be used to update the database orders to the one received from the HomeOrder
     * with all the orders from the different screens
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method fill the pizza Sizes drop box items with the pizza sizes available
     */
    private void initializePizzaSizesDropBar() {
        ObservableList<String> pizzaSizesNames = FXCollections.observableArrayList();
        for (PizzaSizable size: pizzaModel.getPizzaSizes()) {
            pizzaSizesNames.add(size.getSizeName());
        }
        sizesBox.setItems(pizzaSizesNames);
        setPizzaSize();
    }

    /**
     * This method sets the sizeName with the selected size item of the drop Box
     * the method tries to validate the continue button when a size item is selected
     */
    private void setPizzaSize() {
        sizesBox.setOnAction(event -> {
            sizeName = sizesBox.getSelectionModel().getSelectedItem();
            resetPizzaInformationBox();
            validateContinueButton();
        });
    }

    /**
     * This method will be called when the fxml file is created to initialize its components
     * It calls the necessary methods to set the pizza creation menu
     * @throws FileNotFoundException when a file is not found
     */
    public void initialize() throws FileNotFoundException {
        setCounterLabel();
        showPizzaImage();
        initializeIngredientsDropBar();
        initializePizzaSizesDropBar();
    }
}