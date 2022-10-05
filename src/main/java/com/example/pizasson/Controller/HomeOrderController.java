package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.HomeOrder;
import com.example.pizasson.Model.Order;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HomeOrder Controller for the user orders management from the different stages
 * It is the controller for the main screen application
 *
 */
public class HomeOrderController {
    /**
     * The FXML Button to see the current order
     */
    @FXML
    private Button seeOrderButton;
    /**
     * The FXML Pane body screen container
     */
    @FXML
    private Pane homeOrderPane;
    /**
     * The Label to show alert if user cannot order extras yet
     */
    @FXML
    private Label extrasAlertLabel;

    /**
     * Class Model HomeOrder to logic attributes
     */
    private HomeOrder homeOrder;

    /**
     * The all orders database simulation
     */
    private DBOrders dbOrders;

    /**
     * Class constructor initializing the class attributes
     */
    public HomeOrderController() {
        homeOrderPane = new Pane();
        seeOrderButton = new Button();
        extrasAlertLabel = new Label();
        homeOrder = new HomeOrder();
        dbOrders = new DBOrders();
    }

    /**
     * This method creates a Label designed to be used for
     * @param titlePaneText the text to be displayed in the label
     * @return the label created
     */
    private Label createsLabelForTitlePane(String titlePaneText){
        Label titlePaneLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                titlePaneText, 250, 70, Pos.CENTER, 0, 20, 30
        );
        titlePaneLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-alignment: center");
        return titlePaneLabel;
    }

    /**
     * This method creates an image for the option order pane
     * @param imageSource the image source path
     * @return the image created
     * @throws FileNotFoundException in case the path
     */
    private ImageView createImageForOptionPane(String imageSource) throws FileNotFoundException {
        return JavaFXComponents.getJavaFXComponents().createImage(
                imageSource, 250, 250,
                0, 100);
    }

    /**
     * This method creates a Pane to be used for each option order
     * @param titlePane the title for the Pane
     * @param imageSource the image source path
     * @param positionX the position in X for the pane
     * @return the pane created
     * @throws FileNotFoundException if the image path is not founded
     */
    private Pane createPaneOptionOrder(
            String titlePane, String imageSource, int positionX
    ) throws FileNotFoundException {
        Pane paneOrder = JavaFXComponents.getJavaFXComponents().createPane(250, 350);
        paneOrder.getChildren().add(createsLabelForTitlePane(titlePane));
        paneOrder.getChildren().add(createImageForOptionPane(imageSource));
        paneOrder.setLayoutX(positionX);
        paneOrder.setLayoutY(80);
        paneOrder.setStyle("-fx-border-color: red; -fx-border-radius: 20");
        return paneOrder;
    }

    /**
     * This method will be used to update the database orders to the new one received from some screen
     * with the new orders
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders){
        this.dbOrders = dbOrders;
        homeOrder.setOrders(dbOrders.orders);
        displayFXMLByOrdersLength();
    }

    /**
     * This method will navigate to the combos stage sending data
     */
    private void goToCombosStage(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(
                    PizassonScreenStage.class.getResource("CombosMenuView.fxml")
            );
            Scene comboMenuScene = new Scene(fxmlLoader.load(), 1100, 700);

            ComboController comboController = fxmlLoader.getController();
            comboController.updateDBOrders(dbOrders);
            comboController.init();

            Stage menuStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            menuStage.setTitle("Combos Menu");
            menuStage.setScene(comboMenuScene);
            menuStage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method will navigate to the menu stage sending the orders data
     */
    private void goToMenuStage(MouseEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(
                    PizassonScreenStage.class.getResource("PizzasMenuView.fxml")
            );
            Scene menuScene = new Scene(fxmlLoader.load(), 1100, 700);

            PizzasMenuController pizzasMenuController = fxmlLoader.getController();
            pizzasMenuController.updateDBOrders(dbOrders);
            pizzasMenuController.restartMenuUI();

            Stage menuStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            menuStage.setTitle("Pizzas Menu");
            menuStage.setScene(menuScene);
            menuStage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method will navigate to the build your pizza stage sending data
     */
    private void goToBuildYourPizzaStage(MouseEvent event){
        try{
            FXMLLoader fxmlPizzaCreationFile = new FXMLLoader(
                    PizassonScreenStage.class.getResource("PizzaCreationView.fxml")
            );

            Scene pizzaCreationScene = new Scene(fxmlPizzaCreationFile.load(), 1100, 700);

            PizzaCreationController pizzaCreationController = fxmlPizzaCreationFile.getController();
            pizzaCreationController.updateDBOrders(dbOrders);
            pizzaCreationController.initialize();

            String css1 = PizassonScreenStage.class.getResource("pizzaWindowCreation.css").toExternalForm();
            String css2 = PizassonScreenStage.class.getResource("ingredientsViewStyle.css").toExternalForm();
            String css3 = PizassonScreenStage.class.getResource("pizzaCreationViewStyle.css").toExternalForm();
            String css4 = PizassonScreenStage.class.getResource("generalStyle.css").toExternalForm();
            pizzaCreationScene.getStylesheets().addAll(css1,css2,css3,css4);

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Pizza Creation");
            stage.setScene(pizzaCreationScene);
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method will navigate to the extras stage sending data just if the user made at least an order
     */
    private void goToExtrasPane(MouseEvent event){
        if(homeOrder.getOrders().size() == 0) extrasAlertLabel.setVisible(true);
        else{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(
                        PizassonScreenStage.class.getResource("ExtraProductsView.fxml")
                );
                Scene scene = new Scene(fxmlLoader.load(), 1100, 700);

                ExtraProductsController extraProductsController = fxmlLoader.getController();
                extraProductsController.updateDBOrders(dbOrders);

                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

                stage.setTitle("Extras Menu");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * This method will navigate to the order stage sending data to finish the user order
     */
    @FXML
    private void goToOrdersStage(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("OrderScreen.fxml"));
            Scene ordersScene = new Scene(fxmlLoader.load(), 1100, 700);
            OrderController orderController = fxmlLoader.getController();
            orderController.updateDBOrders(dbOrders);
            orderController.updateClientOrders(dbOrders.orders);
            orderController.initialize();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Orders");
            stage.setScene(ordersScene);
            stage.show();
        }
        catch (Exception e)
        {throw new RuntimeException(e);}
    }

    /**
     * This method return an ArrayList with all the order options panes
     * @return the order options panes
     * @throws FileNotFoundException in case the image source path for order pane is not founded
     */
    private ArrayList<Pane> getOrderOptionsPanes() throws FileNotFoundException {
        Pane combosPane = createPaneOptionOrder(
                "Combos", "src/main/resources/images/homeOrder/pizzaSoda.png", 25
        );
        combosPane.setOnMouseClicked(this::goToCombosStage);

        Pane menuPane = createPaneOptionOrder(
                "Menu", "src/main/resources/images/homeOrder/pizzaSlices.png", 290
        );
        menuPane.setOnMouseClicked(this::goToMenuStage);

        Pane buildPizzaPane = createPaneOptionOrder(
                "Build your \npizza", "src/main/resources/images/homeOrder/pizzaBuild.png",
                560
        );
        buildPizzaPane.setOnMouseClicked(this::goToBuildYourPizzaStage);

        Pane extrasPane = createPaneOptionOrder(
                "Extras", "src/main/resources/images/homeOrder/extras.png", 830
        );
        extrasPane.setOnMouseClicked(this::goToExtrasPane);

        return new ArrayList<>(List.of(combosPane, menuPane, buildPizzaPane, extrasPane));
    }

    /**
     * This method will be called when the view is rendered.
     * It calls the different above methods to show all the required menu information
     * @throws FileNotFoundException in case some image sources is not found
     */
    @FXML
    public void initialize() throws FileNotFoundException {
        for (Pane orderOptionPane:getOrderOptionsPanes()){
            homeOrderPane.getChildren().add(orderOptionPane);
        }

        seeOrderButton.setVisible(false);
        extrasAlertLabel.setVisible(false);
    }

    /**
     * This method adds a new order to the model
     * @param order the new order to add
     */
    private void addOneOrder(Order order){
        homeOrder.addOneOrder(order);
    }

    /**
     * This method will be called when another action is made to verify if there are orders to display
     * the see my order button
     */
    private void displayFXMLByOrdersLength(){
        if(homeOrder.getOrders().size() > 0) {
            seeOrderButton.setVisible(true);
            extrasAlertLabel.setVisible(false);
        }
    }

    /**
     * This method gets the orders' database just to make a test unit of it
     * @return the orders database
     */
    public DBOrders getDbOrders() {
        return dbOrders;
    }
}
