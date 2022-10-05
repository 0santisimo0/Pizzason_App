package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.DBCombos;
import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Combo;
import com.example.pizasson.Model.CombosMenu;
import com.example.pizasson.Model.Extras.Extra;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Model.pizza.Pizza;
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
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class contains the necessary methods to run the stage of combos menu. This is the controller of the
 * ComboMenuView.
 *
 */
public class ComboController {
    /**
     * Is the combos in the menu.
     */
    private CombosMenu combosMenu;
    /**
     * Is a FXML Label that contains the ordered combos.
     */
    @FXML
    private Label combosOrderedLabel;
    /**
     * Is a FXML Pane to manage the view.
     */
    @FXML
    private Pane combosMenuPane;
    /**
     * Is a FXML GridPane that will contain all the combos to distribute them in a good way on the screen space.
     */
    @FXML
    private GridPane combosMenuGridPane;

    /**
     * All are the orders of database.
     */
    private DBOrders dbOrders;

    /**
     * This is the constructor method of the class.
     *
     * <p>
     *     Initializes the class attributes. Initialize the combos menu whit an list by DBCombos.
     * </p>
     *
     * @see DBCombos
     */
    public ComboController(){
        combosMenu = new CombosMenu(new DBCombos().combos);
        combosOrderedLabel = new Label();
        combosMenuPane = new Pane();
        combosMenuGridPane = new GridPane();
        dbOrders = new DBOrders();
    }

    /**
     * This method get the combo products info of the order in a concatenated String.
     *
     * @param combo Receive a param of type combo.
     * @return Returns a concatenated String.
     */
    private String getComboProductsInfo(Combo combo) {
        StringBuilder productsInfo = new StringBuilder(" Products: \n");
        for(int i = 0; i < combo.getPizzasList().size(); i++) {
            Pizza pizza = combo.getPizzasList().get(i);
            productsInfo.append("\n- ").append(pizza.getName()).append(" Pizza");
        }
        for(int i = 0; i < combo.getExtrasList().size(); i++) {
            Extra extra = combo.getExtrasList().get(i);
            productsInfo.append("\n- ").append(extra.getName());
        }
        return productsInfo.toString();
    }

    /**
     * This method creates a new button using JavaFxComponents to order a combo.
     *
     * @see JavaFXComponents
     * @param textButton Is the text displayed on the button.
     * @return Returns a new button created.
     */
    private Button createButtonBuyCombo(String textButton) {
        return  JavaFXComponents.getJavaFXComponents().createButton(textButton, 223, 150, "#852D13");
    }

    /**
     * This method creates a Panel with a button to buy the combo.
     *
     * @param combo To use combo name in the button.
     * @param comboPane Is the panel in which the button will be inserted
     * @return Returns a new pane whit one button.
     */
    private Pane getPaneWhitButtonBuyCombo(Combo combo, Pane comboPane) {
        String textBuyComboButton = "Add 1 " + combo.getComboName();
        Button buyComboButton = createButtonBuyCombo(textBuyComboButton);
        buyComboButton.setOnAction(e -> addNewComboOrder(combo));
        comboPane.getChildren().add(buyComboButton);
        return comboPane;
    }

    /**
     * This method creates a Label with the combo name using JavaFXComponents.
     *
     * @see JavaFXComponents
     * @param combo To use combo name in the label.
     * @return Returns a nwe Label with the combo name
     */
    private Label createComboNameLabel(Combo combo) {
        Label comboNameLabel = JavaFXComponents.getJavaFXComponents().createLabel(
                combo.getComboName(), 250, 40, Pos.BOTTOM_CENTER, 0, 0, 18);
        comboNameLabel.setStyle("-fx-font-weight: bold");
        return comboNameLabel;
    }

    /**
     * This method creates panels to display the information of the menu combos.
     *
     * @see JavaFXComponents
     * @param combo To use the product's info.
     * @return Returns a new label with the product's info.
     */
    private Label createComboProductsInfoLabel(Combo combo) {
        return JavaFXComponents.getJavaFXComponents().createLabel(
                getComboProductsInfo(combo), 150, 100, Pos.CENTER, 185, 55, 10
        );
    }

    /**
     * This method creates a combo image in the menu using JavaFXComponents.
     *
     * @see JavaFXComponents
     * @param combo Receive a combo to use its attribute imageSource.
     * @return Returns a new image created.
     * @throws FileNotFoundException In case the image source is not founded
     */
    private ImageView createComboImage(Combo combo) throws FileNotFoundException {
        return JavaFXComponents.getJavaFXComponents().createImage(
                combo.getComboImageSource() , 180, 135, 20, 45
        );
    }

    /**
     * This method creates a new Label with the combo price info.
     *
     * @see JavaFXComponents
     * @param combo Is the combo to get info.
     * @return Returns a label with the combo price info.
     */
    private Label createComboInfoLabel(Combo combo) {
        return JavaFXComponents.getJavaFXComponents().createLabel(
                getComboPriceInfo(combo), 150, 140, Pos.CENTER_RIGHT, -10, 150, 13
        );
    }

    /**
     * This method get the combo price info.
     *
     * @param combo Receive a param of type combo.
     * @return Returns a String with the combo price info.
     */
    private String getComboPriceInfo(Combo combo) {
        DecimalFormat priceFormat = new DecimalFormat("#.00");
        String comboInfo = "\n\nPrice: Bs. " + priceFormat.format(combo.getComboPrice());
        return comboInfo;
    }

    /**
     * This method creates a Pane that will be a container to display each combo in the menu information and
     * order buttons.
     *
     * @see JavaFXComponents
     * @param combo Receives a param of type combo.
     * @return Returns a new Pane created.
     * @throws FileNotFoundException In case the pizza image source is not founded
     */
    private Pane createComboMenuPane(Combo combo) throws FileNotFoundException {
        Pane comboPane = JavaFXComponents.getJavaFXComponents().createPane(365, 280);
        comboPane = getPaneWhitButtonBuyCombo(combo, comboPane);
        comboPane.getChildren().add(createComboImage(combo));
        comboPane.getChildren().add(createComboNameLabel(combo));
        comboPane.getChildren().add(createComboProductsInfoLabel(combo));
        comboPane.getChildren().add(createComboInfoLabel(combo));
        return comboPane;
    }

    /**
     * This method adds a panel to the combo menu grid
     *
     * @param indexList Is the index of DBCombos list.
     * @param comboPane Is the current combo pane to insert in the grid.
     * @param listSize Is the size of combos options in the menu.
     */
    private void addComboPaneToMenuGrid(int indexList, Pane comboPane, int listSize) {
        if(indexList < listSize / 2) combosMenuGridPane.add(comboPane,  indexList, 0);
        else combosMenuGridPane.add(comboPane,  indexList - (listSize / 2), 1);
    }

    /**
     * This method will be called when the view is rendered.
     * It calls the different above methods to show all the required menu information
     *
     * @throws FileNotFoundException In case the pizza image source is not founded
     */
    public void init() throws FileNotFoundException {
        combosOrderedLabel.setText("Combos Ordered: " + dbOrders.combosOrders.size());
        ArrayList<Combo> combos = combosMenu.getCombos();

        for(int i = 0; i < combos.size(); i++) {
            Combo combo = combos.get(i);
            Pane combosMenuPane = createComboMenuPane(combo);
            addComboPaneToMenuGrid(i, combosMenuPane, combos.size());
        }

        combosMenuPane.getChildren().add(combosMenuGridPane);
    }

    /**
     * This method send the new order's data to Home Order and continues with the menu navigation.
     *
     * @param event Is the button Continue action event.
     * @throws IOException When a fxml file can not be loaded.
     */
    @FXML
    private void continueWithOrder(ActionEvent event) throws IOException {
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
     * This method is used to update the orders from the database.
     *
     * @param  dbOrders the dbOrders with the data orders updated
     */
    public void updateDBOrders(DBOrders dbOrders) {
        this.dbOrders = dbOrders;
    }

    /**
     * This method adds combos to the request every time a button is pressed.
     *
     * @param combo Receive a param of type combo.
     */
    public void addNewComboOrder(Combo combo) {
        orderCombo(combo);
        combosOrderedLabel.setText("Combos Ordered: " + dbOrders.combosOrders.size());
    }

    /**
     * This method creates a new order with the combo data.
     * Later adds the order in the order's database.
     *
     * @param combo Receive a param of type combo to use your data.
     */
    private void orderCombo(Combo combo) {
        Order order = new Order(combo.getComboName(), getComboProductsInfo(combo),1, combo.getComboPrice());
        dbOrders.combosOrders.add(order);
        dbOrders.orders.add(order);
    }
}
