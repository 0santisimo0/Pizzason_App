package com.example.pizasson.Controller;

import com.example.pizasson.DataBase.*;
import com.example.pizasson.Model.Extras.ExtraDrink;
import com.example.pizasson.Model.Extras.ExtraMealPortion;
import com.example.pizasson.Model.Extras.ExtraServingOfDesserts;
import com.example.pizasson.Model.Extras.ExtrasSizable;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion100gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion1300gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion450gr;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.ExtraDrinkQuantity;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters2;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters3;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.PersonalDrink;
import com.example.pizasson.Model.Extras.ExtraMealSize.AcademicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.EconomicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.LargePortion;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Stages.PizassonScreenStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to be able to manage the data, methods, buttons and combo boxes used in the execution screen of
 * the secondary products' menu.
 *
 */
public class ExtraProductsController {

    /**
     * These attributes are used to handle the combo boxes.
     */
    @FXML
    private ComboBox <String> comboBoxDessert1, comboboxDessert2, comboboxDessert3, comboboxDessert4, comboboxDessert5,
            comboboxDessert6, comboboxMeal1, comboboxMeal2, comboboxMeal3, comboboxMeal4, comboboxDrinks1,
            comboboxDrinks2, comboboxDrinks3, comboboxDrinks4, comboboxDrinks5, comboboxDrinks6, comboboxDrinks7;

    /**
     * These attributes are used to modify the values of label.
     */
    @FXML
    public Label amountLabelCounterDrinks, amountLabelCounterDesserts, amountLabelCounterMeals;

    /**
     * This attribute is used to save the combo boxes of type Desserts.
     */
    protected ArrayList<ComboBox> listOfComboBoxDessert = new ArrayList<>();

    /**
     * This attribute is used to save the combo boxes of type Meals.
     */
    protected ArrayList<ComboBox> listOfComboBoxMeal = new ArrayList<>();

    /**
     * This attribute is used to save the combo boxes of type Drinks.
     */
    protected ArrayList<ComboBox> listOfComboBoxDrinks = new ArrayList<>();

    /**
     * This attribute is used to access the simulated database of the drinks.
     */
    private DBExtraDrinks dbExtraDrinks = new DBExtraDrinks();

    /**
     * This attribute is used to access the simulated database of the desserts.
     */
    private DBExtraDesserts dbExtraDesserts = new DBExtraDesserts();

    /**
     * This attribute is used to access the simulated database of the meals.
     */
    private DBExtraMeal dbExtraMeal = new DBExtraMeal();

    /**
     * These attributes are used to handle the desserts and meals quantities.
     */
    private ArrayList<ExtrasSizable> extraDessertsSizes, extraMealSizes;

    /**
     * This attribute is used to handle the drinks quantities.
     */
    private ArrayList<ExtraDrinkQuantity> extraDrinkQuantities;

    /**
     * This attribute is used to save and update the orders for user can be pay.
     */
    private DBOrders dbOrders;


    /**
     * This method is a constructor method where initialized the arrayList and dbOrders.
     */
    public ExtraProductsController(){
        extraDessertsSizes = new ArrayList<>(
                List.of(new Portion100gr(), new Portion450gr(), new Portion1300gr())
        );
        extraDrinkQuantities = new ArrayList<>(
                List.of(new Litters3(), new Litters2(), new PersonalDrink())
        );
        extraMealSizes = new ArrayList<>(List.of(
                new AcademicPortion(), new EconomicPortion(), new LargePortion()));

        dbOrders = new DBOrders();
    }

    /**
     * This method will be used to update the database orders to the one received from the HomeOrder
     * with all the orders from the different screens.
     *
     * @param dbOrders the dbOrders with the data orders updated.
     */
    public void updateDBOrders(DBOrders dbOrders) throws FileNotFoundException {
        this.dbOrders = dbOrders;
        initializedLabels();
    }

    /**
     * This method is used to initialize the values of labels for charge in scene.
     */
    private void initializedLabels() {
        amountLabelCounterDrinks.setText(String.valueOf(dbOrders.extraDrinkOrders.size()));
        amountLabelCounterDesserts.setText(String.valueOf(dbOrders.extraMealOrders.size()));
        amountLabelCounterMeals.setText(String.valueOf(dbOrders.extraDessertsOrders.size()));
    }

    /**
     * This method is used to verify is there any order replied in case there is return  the boolean is in list.
     *
     * @param order This attribute is used to check if there is a matching order.
     * @return This attribute is a boolean value is in list to verify the new order.
     */
    private boolean verifyIsThereOrder(Order order) {
        boolean isInList = false;
        for (Order orderGeneral : dbOrders.orders){
            if (orderGeneral.getOrderTitle().equals(order.getOrderTitle()) ){
                orderGeneral.setQuantity(orderGeneral.getQuantity() + 1);
                order.setQuantity(order.getQuantity() + 1);
                isInList = true;
            }
        }
        return isInList;
    }

    /**
     * This method is used to add order if there isn't any order equals.
     *
     * @param isThereOrder This parameter is used to check  is there in list.
     * @param order This order is added in case there isn't any equals.
     */
    private void addOrderIfNotfound(boolean isThereOrder, Order order){
        if (!isThereOrder) {
            dbOrders.orders.add(order);
        }
    }

    /**
     * This method is used to create a new order of type drink when the continue button is pressed.
     *
     * @param extraDrink This parameter is used to save on the order of type drink its attributes.
     * @param extraDrinkQuantity This parameter is used to save the quantity of Drink on the order and get its attributes.
     */
    public void addNewOrderDrink(ExtraDrink extraDrink, ExtraDrinkQuantity extraDrinkQuantity) {
        amountLabelCounterDrinks.setText(String.valueOf(dbOrders.extraDrinkOrders.size() + 1));

        Order order = new Order(extraDrink.getName() + " " + extraDrinkQuantity.getQuantityName(),
                extraDrink.getTypeOfDrink(), 1, extraDrinkQuantity.getPriceQuantity());

        addOrderIfNotfound(verifyIsThereOrder(order), order);
        dbOrders.extraDrinkOrders.add(order);
    }

    /**
     * This method is used to create a new order of type meal when the continue button is pressed.
     *
     * @param extraMealPortion This parameter is used to save on the order of type meal its attributes..
     * @param extrasSizable This parameter is used to save the size of general extras on the order and get its attributes.
     */
    public void addNewOrderMeal(ExtraMealPortion extraMealPortion, ExtrasSizable extrasSizable) {
        amountLabelCounterDesserts.setText(String.valueOf(dbOrders.extraMealOrders.size() + 1));

        Order order = new Order(extraMealPortion.getName() + " " + extrasSizable.getSizeName(),
                extraMealPortion.getListOfIngredients().toString(), 1,
                extrasSizable.getPriceSize(extraMealPortion.getListOfIngredients()));

        addOrderIfNotfound(verifyIsThereOrder(order), order);
        dbOrders.extraMealOrders.add(order);
    }

    /**
     * This method is used to create a new order of type dessert when the continue button is pressed.
     *
     * @param extraServingOfDesserts This parameter is used to save on the order of type dessert its attributes.
     * @param extrasSizable This parameter is used to save the size of general extras on the order and get its attributes.
     */
    public void addNewOrderDessert(ExtraServingOfDesserts extraServingOfDesserts, ExtrasSizable extrasSizable) {
        amountLabelCounterMeals.setText(String.valueOf(dbOrders.extraDessertsOrders.size() + 1));

        Order order = new Order(extraServingOfDesserts.getName() + " " + extrasSizable.getSizeName(),
                extraServingOfDesserts.getListOfIngredients().toString(), 1,
                extrasSizable.getPriceSize(extraServingOfDesserts.getListOfIngredients()));

        addOrderIfNotfound(verifyIsThereOrder(order), order);
        dbOrders.extraDessertsOrders.add(order);
    }

    /**
     * This method is used to add all comboBox to their respective lists according to the type of combo box.
     */
    private void createListOfComboBox(){
        Collections.addAll(listOfComboBoxDessert, comboBoxDessert1,comboboxDessert2, comboboxDessert3,comboboxDessert4,
                comboboxDessert5, comboboxDessert6);

        Collections.addAll(listOfComboBoxMeal, comboboxMeal1, comboboxMeal2, comboboxMeal3, comboboxMeal4);

        Collections.addAll(listOfComboBoxDrinks, comboboxDrinks1, comboboxDrinks2, comboboxDrinks3, comboboxDrinks4,
                comboboxDrinks5, comboboxDrinks6, comboboxDrinks7);
    }


    /**
     * This method is used to put the options in the appropriate comboBox, in this case the options will be added in
     * the general extra type combo boxes.
     *
     * @param listOptions This list is of type string like options will be used to do actions.
     * @param extrasSizable This attribute is a list of options where new options will be implemented.
     * @param comboBoxesList The combo boxes will add actions.
     */
    private void putOptionsInGeneralList(ArrayList<String> listOptions, ArrayList<ExtrasSizable> extrasSizable, ArrayList<ComboBox> comboBoxesList) {
        listOptions.add("Select");
        for (ExtrasSizable extraSizable : extrasSizable){
            listOptions.add(extraSizable.getSizeName());
        }
        implementInComboBox(comboBoxesList, listOptions);
    }

    /**
     * This method is used to put the options in the appropriate comboBox, in this case the options will be added in
     * the drink type combo boxes.
     *
     * @param listOptions this list is of type string like options will be used to do actions.
     * @param comboBoxesList the combo boxes will add actions.
     */
    private void putInDrinkListOptions(ArrayList<String> listOptions, ArrayList<ComboBox> comboBoxesList) {
        listOptions.add("Select");
        for (ExtraDrinkQuantity extraDrinkQuantity: extraDrinkQuantities){
            listOptions.add(extraDrinkQuantity.getQuantityName());
        }
        implementInComboBox(comboBoxesList, listOptions);
    }

    /**
     * This method will be in charge of managing the navigation when user ends to order from the menu,
     * it will send the new orders data to Home Order.
     *
     * @param event This parameter register the event.
     */
    @FXML
    private void continueWithOrderOutOfMenu(ActionEvent event) throws IOException {
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
     * This method is used to create the options for after user can select the method and do action like buy.
     */
    private void createOptionsOfComboBox(){
        createListOfComboBox();
        ArrayList<String> dessertComboboxOptions = new ArrayList<>();
        putOptionsInGeneralList(dessertComboboxOptions, extraDessertsSizes, listOfComboBoxDessert);

        ArrayList<String> drinkComboboxOptions = new ArrayList<>();
        putInDrinkListOptions(drinkComboboxOptions, listOfComboBoxDrinks);

        ArrayList<String> mealComboboxOptions = new ArrayList<>();
        putOptionsInGeneralList(mealComboboxOptions, extraMealSizes, listOfComboBoxMeal);
    }

    /**
     * This method is used to add the previously mentioned options to combo Boxes
     *
     * @param listOfComboBox This attribute is the list where we are going to put the options of the respective combo boxes.
     * @param list This attribute is the list where the options are stored it is used to add to the list of options of the combo box.
     */
    public void implementInComboBox(ArrayList<ComboBox> listOfComboBox, ArrayList<String> list){
        for (var comboBox: listOfComboBox) {
            comboBox.getItems().clear();
            comboBox.getItems().addAll(list);
        }
    }

    /**
     * This method will be called when the view is rendered for after execute the methods to show all the required Extras menu.
     *
     * @throws FileNotFoundException in case some extra product image sources is not founded.
     */
    public void initialize () throws FileNotFoundException {
        createOptionsOfComboBox();
    }

    /**
     * This method is used to do action if combobox is equals Meals combo boxes.
     *
     * @param extraMealPortion This attribute is used to create yhe new order.
     * @param comboBoxItem This attribute is a combo box id.
     */
    private void doActionMealExtraCombobox(ExtraMealPortion extraMealPortion, String comboBoxItem) {
        for (ExtrasSizable extraSize : extraMealSizes){
            if(comboBoxItem.equalsIgnoreCase(extraSize.getSizeName())) addNewOrderMeal(extraMealPortion, extraSize);
        }
    }

    /**
     * This method is used to do action if combobox is equals Dessert combobox
     *
     * @param extraServingOfDesserts This attribute is used to create yhe new order.
     * @param comboBoxItem This attribute is a combo box id.
     */
    private void doActionDessertExtraCombobox(ExtraServingOfDesserts extraServingOfDesserts, String comboBoxItem) {
        for (ExtrasSizable extraSize : extraDessertsSizes){
            if(comboBoxItem.equalsIgnoreCase(extraSize.getSizeName())){
                addNewOrderDessert(extraServingOfDesserts, extraSize);
            }
        }
    }

    /**
     * This method is used to do action if combobox is equals Drink combobox
     *
     * @param extraDrink This attribute is used to create yhe new order.
     * @param comboBoxItem This attribute is a combo box id.
     */
    private void doActionDrinkCombobox(ExtraDrink extraDrink, String comboBoxItem) {
        for (ExtraDrinkQuantity extraDrinkQuantity: extraDrinkQuantities){
            if(comboBoxItem.equalsIgnoreCase(extraDrinkQuantity.getQuantityName())){
                addNewOrderDrink(extraDrink, extraDrinkQuantity);
            }
        }
    }

    /**
     * This method is overload used when the user wants to do any action with combo box so the user selects one option and do
     * the respective action in this case oly the drinks.
     *
     * @param comboBox This attribute is a combo box where we want each option to do its respective action.
     * @param extraServingOfDesserts This attribute is used to pass by parameter for do actions.
     */
    public void comboBoxCheckAction(ComboBox comboBox, ExtraServingOfDesserts extraServingOfDesserts) {
        String comboBoxItem = comboBox.getSelectionModel().getSelectedItem().toString();;
        if (!comboBoxItem.equalsIgnoreCase("Select")) {
            doActionDessertExtraCombobox(extraServingOfDesserts, comboBoxItem);
        }
    }

    /**
     * This method is overload used when the user wants to do any action with combo box so the user selects one option and do
     * the respective action in this case oly the drinks.
     *
     * @param comboBox This attribute is a combo box where we want each option to do its respective action.
     * @param extraMealPortion This attribute is used to pass by parameter for do actions.
     */
    public void comboBoxCheckAction(ComboBox comboBox, ExtraMealPortion extraMealPortion) {
        String comboBoxItem = comboBox.getSelectionModel().getSelectedItem().toString();;
        if (!comboBoxItem.equalsIgnoreCase("Select")) {
            doActionMealExtraCombobox(extraMealPortion, comboBoxItem);
        }
    }

    /**
     * This method is overload used when the user wants to do any action with combo box so the user selects one option and do
     * the respective action in this case oly the drinks.
     *
     * @param comboBox This attribute is a combo box where we want each option to do its respective action.
     * @param extraDrink This attribute is used to pass by parameter for do actions.
     */
    public void comboBoxCheckAction(ComboBox comboBox, ExtraDrink extraDrink) {
        String comboBoxItem = comboBox.getSelectionModel().getSelectedItem().toString();;
        if (!comboBoxItem.equalsIgnoreCase("Select")) {
            doActionDrinkCombobox(extraDrink, comboBoxItem);
        }
    }

    /**
     * This method is in charge to do an action of the desired combobox in this case the dessert combo boxes.
     *
     * @param event This is the type event will be used to do action.
     * @param comboBox This is the combo box will be to do its action.
     * @param extraServingOfDesserts This attribute is passed like parameter for after do its action.
     */
    public void doActionOfDessertComboBox(Object event, ComboBox comboBox, ExtraServingOfDesserts extraServingOfDesserts) {
        if (event.equals(comboBox))
            comboBoxCheckAction(comboBox, extraServingOfDesserts);
    }

    /**
     * This method is  overload in charge to do an action of the desired combobox in this case the drink combo boxes.
     *
     * @param event This is the type event will be used to do action.
     * @param comboBox This is the combo box will be to do its action.
     * @param extraDrink This attribute is passed like parameter for after do its action.
     */
    public void doActionOfDrinkComboBox(Object event, ComboBox comboBox, ExtraDrink extraDrink) {
        if (event.equals(comboBox))
            comboBoxCheckAction(comboBox, extraDrink);
    }

    /**
     * This method is in charge to do an action of the desired combobox in this case the meal combo boxes.
     *
     * @param event This is the type event will be used to do action.
     * @param comboBox This is the combo box will be to do its action.
     * @param extraMealPortion This attribute is passed like parameter for after do its action.
     */
    public void doActionOfOnlyMealComboBox(Object event, ComboBox comboBox, ExtraMealPortion extraMealPortion) {
        if (event.equals(comboBox))
            comboBoxCheckAction(comboBox, extraMealPortion);
    }

    /**
     * This method is the one that registers the event of type dessert that was performed on the selected combo box.
     *
     * @param actionEvent This attribute is the one that records the action performed by the user.
     */
    public void comboBoxDessertsEvents(ActionEvent actionEvent) {
        for (ComboBox comboBox: listOfComboBoxDessert){
            Object event = actionEvent.getSource();
            int index = listOfComboBoxDessert.indexOf(comboBox);
            doActionOfDessertComboBox(event, comboBox, dbExtraDesserts.listDesserts.get(index));
        }
    }

    /**
     * This method is the one that registers the event of type drink that was performed on the selected combo box.
     *
     * @param actionEvent This attribute is the one that records the action performed by the user.
     */
    public void comboBoxDrinksEvents(ActionEvent actionEvent) {
        for (ComboBox comboBox: listOfComboBoxDrinks){
            Object event = actionEvent.getSource();
            int index = listOfComboBoxDrinks.indexOf(comboBox);
            doActionOfDrinkComboBox(event, comboBox, dbExtraDrinks.listOfDrinks.get(index));
        }
    }

    /**
     * This method is the one that registers the event of type meal that was performed on the selected combo box.
     *
     * @param actionEvent This attribute is the one that records the action performed by the user.
     */
    public void comboBoxMealsEvents(ActionEvent actionEvent) {
        for (ComboBox comboBox: listOfComboBoxMeal){
            Object event = actionEvent.getSource();
            int index = listOfComboBoxMeal.indexOf(comboBox);
            doActionOfOnlyMealComboBox(event, comboBox, dbExtraMeal.listOfMeal.get(index));
        }
    }
}
