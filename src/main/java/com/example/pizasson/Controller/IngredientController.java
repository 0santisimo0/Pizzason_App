package com.example.pizasson.Controller;

import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.utils.JavaFXComponents;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.FileNotFoundException;

/**
 * This class is in charge of modifying the elements of the ingredient information box view
 * The class gets the attributes of the pizzaIngredient to create an observable information box to show on screen
 *
 * @author Santiago Caballero
 */
public class IngredientController {
    private Label title;
    private ImageView ingredientImg;
    private Label price;

    /**
     * This method sets the ui elements with the model attributes to return the general information of the ingredient
     * @return returns the ui box with the general information of the ingredient
     */
    public VBox showIngredientInformation(PizzaIngredients pizzaIngredient) {
        setTitle(pizzaIngredient);
        importIngredientImg(pizzaIngredient);
        setPriceView(pizzaIngredient);
        return setVBox(setHBox());
    }
    /**
     * This method modifies the principal information box elements adding the title(name) and the horizontalBox attributes
     * @param horizontalBox to add into the principal information Vbox
     * @return the principal information Vbox
     */
    private VBox setVBox(HBox horizontalBox) {
        VBox informationBox = new VBox();
        informationBox.setPrefSize(300,300);
        informationBox.getStyleClass().add("IngredientInformationVbox");
        informationBox.setEffect(new DropShadow());
        informationBox.getChildren().addAll(title,horizontalBox);
        return informationBox;
    }

    /**
     * This method instances a Horizontal box to add the ingredient img and its price
     * @return the horizontal box with the ingredient image and prize
     */
    private HBox setHBox() {
        HBox horizontalBox = new HBox(30);
        horizontalBox.setPrefSize(300,100);
        horizontalBox.getChildren().addAll(ingredientImg,price);
        horizontalBox.setAlignment(Pos.CENTER);
        return horizontalBox;
    }

    /**
     * Method to instance the ingredient price label
     * @param pizzaIngredient to get its cost
     */
    private void setPriceView(PizzaIngredients pizzaIngredient) {
        price =new Label();
        price.getStyleClass().add("textStyle");
        price.setText(("Price: \n"+pizzaIngredient.getCost())+" Bs");
    }

    /**
     * This method tries to import the ingredient image from the sources
     * @param pizzaIngredient to get its image path
     */
    private void importIngredientImg(PizzaIngredients pizzaIngredient) {
        try {
            ingredientImg = JavaFXComponents.getJavaFXComponents().createImage(
                    pizzaIngredient.getImagePath(),180,130,0,0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to set the title with the name of the ingredient
     * @param pizzaIngredient to get its name
     */
    private void setTitle(PizzaIngredients pizzaIngredient) {
        title = new Label(pizzaIngredient.getName());
        title.getStyleClass().add("ingredientTitle");
        title.setPrefSize(250,50);
    }
}
