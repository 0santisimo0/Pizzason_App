package com.example.pizasson.Controller;

import com.example.pizasson.Model.pizza.Pizza;
import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.utils.JavaFXComponents;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class is in charge of modifying the elements of the pizza information box view
 * The class gets the attributes of the pizzaModel to create an observable information box to show on screen
 *
 * @author Santiago Caballero
 */
public class PizzaController {
    private Pizza pizzaModel;
    private Label title, price, size;
    private HBox horizontalBox;
    private VBox ingredientsLabelList;

    /**
     * This is the constructor method it initializes the pizzaModel
     * @param pizzaModel receives the object pizza to initialize
     */
    public PizzaController(Pizza pizzaModel) {
        this.pizzaModel = pizzaModel;
    }

    /**
     * Class constructor without params
     */
    public PizzaController() {

    }

    /**
     * This method sets the ui elements with the model attributes to return the general information of the pizza
     * @return returns the ui box with the general information of the pizza
     */
    public VBox showPizzaInformation() {
        ingredientsLabelList = new VBox();
        setTitleView();
        setSizeView();
        setPriceView();
        setIngredientsViewList();
        setPizzaAttributesHBox();
        return setPizzaInfoVBox(horizontalBox);
    }

    /**
     * This method sets the ingredients label list with the ingredients gotten from the pizzaModel
     * the method sets the labels of ingredients just if the pizza has ingredients and append them to the ingredientsLabelList
     */
    private void setIngredientsViewList() {
        if (!pizzaModel.getIngredients().isEmpty()) {
            Label subtitleLabel = new Label("INGREDIENTS: ");
            subtitleLabel.getStyleClass().add("textStyle");
            ingredientsLabelList.getChildren().add(subtitleLabel);

            for (PizzaIngredients ingredient: pizzaModel.getIngredients()) {
                Label ingredientLabel = new Label(ingredient.getName());
                ingredientLabel.getStyleClass().add("textStyle");
                ingredientsLabelList.getChildren().add(ingredientLabel);
            }
        }
    }

    /**
     * This method modifies the principal information box elements adding the title(name) and the attributes of the Horizontal box
     * @param horizontalBox to add into the principal information Vbox
     * @return the principal information Vbox
     */
    private VBox setPizzaInfoVBox(HBox horizontalBox) {
        VBox informationBox = new VBox();
        informationBox.setPrefSize(300,200);
        informationBox.getStyleClass().add("pizzaInformationBoxStyle");
        informationBox.setEffect(new DropShadow());
        informationBox.getChildren().addAll(title,horizontalBox);
        return informationBox;
    }

    /**
     * This method instances a Horizontal box to add the ingredient list, the price, and the size of the pizza
     */
    private void setPizzaAttributesHBox() {
        horizontalBox = new HBox(30);
        horizontalBox.setPrefSize(300,100);
        horizontalBox.getChildren().addAll(ingredientsLabelList,price,size);
        horizontalBox.setAlignment(Pos.TOP_CENTER);
    }

    /**
     * This method creates a label to set the text with the pizza price
     */
    private void setPriceView() {
        price = new Label();
        price.getStyleClass().add("textStyle");
        price.setText(("PRICE: \n"+ pizzaModel.getPrice())+" Bs");
    }

    /**
     * This method creates a label to set the text with the pizza size
     * the method has a label with a text by default that is modified if the pizza has a size
     */
    private void setSizeView() {
        size = new Label("SIZE: \nNot Defined");
        size.getStyleClass().add("textStyle");
        if (pizzaModel.getSize() != null) {
            size.setText("SIZE: \n"+pizzaModel.getSize());
        }
    }

    /**
     * This method creates a label to set the text with the pizza name
     */
    private void setTitleView() {
        title = JavaFXComponents
                .getJavaFXComponents()
                .createLabel(pizzaModel.getName(),300,
                        70,Pos.CENTER,
                        0,
                        0,
                        30);
    }

    /**
     * This method gets all the ingredients name of the pizza ordered in a concatenated String
     * @param pizza the pizza ordered to get its ingredients
     * @return a String with all the ingredients name
     */
    public String getPizzaIngredientsInfo(Pizza pizza){
        StringBuilder ingredientsInfo = new StringBuilder(" Ingredients: \n");
        for (int i = 0; i < pizza.getIngredients().size(); i++) {
            PizzaIngredients pizzaIngredient = pizza.getIngredients().get(i);
            ingredientsInfo.append("\n- ").append(pizzaIngredient.getName());
        }
        return ingredientsInfo.toString();
    }
}
