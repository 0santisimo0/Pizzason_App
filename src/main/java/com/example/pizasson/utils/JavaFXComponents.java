package com.example.pizasson.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class will be used as an util to implement the methods in the controller required.
 * The methods provided from this class returns JavaFX Components created with different parameters.
 *
 * @author Santiago Caballero
 */

public class JavaFXComponents {
    /**
     * This is a unique attribute in all program in this case is printer for after instance this attribute.
     */
    private static JavaFXComponents javaFXComponents;

    /**
     * This method do the unique instance in all program of this class in case there isn't an instance of this class.
     *
     * @return JavaFXComponents to get the unique instance.
     */
    public static JavaFXComponents getJavaFXComponents() {
        if (javaFXComponents == null) {javaFXComponents = new JavaFXComponents();}
        return javaFXComponents;
    }


    /**
     * This method returns a Pane created with some parameters
     * @param paneWidth the pane width
     * @param paneHeight the pane height
     * @return the pane created
     */
    public Pane createPane(int paneWidth, int paneHeight){
        Pane pane = new Pane();
        pane.setPrefWidth(paneWidth);
        pane.setPrefHeight(paneHeight);
        return pane;
    }


    /**
     * This method returns a Label created with simple parameters
     * @param labelText the initial text contained in the label
     * @param labelWidth the label width
     * @param labelHeight the label height
     * @param alignment the label alignment
     * @param positionX the label position in X
     * @param positionY the label position in Y
     * @param fontSize the label text font size
     * @return the label created
     */
    public Label createLabel(
            String labelText, int labelWidth, int labelHeight, Pos alignment, int positionX, int positionY, int fontSize
    ){
        Label label = new Label(labelText);
        label.setPrefWidth(labelWidth);
        label.setAlignment(alignment);
        label.setPrefHeight(labelHeight);
        label.setTextFill(Paint.valueOf("#ca352a"));
        label.setStyle("-fx-font-size: " + fontSize + ";");
        label.setLayoutX(positionX);
        label.setLayoutY(positionY);
        return label;
    }

    /**
     * This method creates an image receiving some parameters.
     * @param imageSource the image source in the project
     * @param imageWidth the image width
     * @param imageHeight the image height
     * @param positionX the image position in X
     * @param positionY the image position in y
     * @return the image created
     * @throws FileNotFoundException in case the image source is not founded
     */
    public ImageView createImage(
            String imageSource, int imageWidth, int imageHeight, int positionX, int positionY
    ) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(imageSource));
        ImageView imageView = new ImageView(image);
        imageView.setY(positionY);
        imageView.setX(positionX);
        imageView.setFitHeight(imageHeight);
        imageView.setFitWidth(imageWidth);
        return imageView;
    }

    /**
     * This method creates a button receiving some parameters
     * @param textButton the text that will be displayed in the button
     * @param positionY the button position in y
     * @param positionX the button position in x
     * @param buttonColor the button background color
     * @return the button created
     */
    public Button createButton(String textButton, int positionY, int positionX, String buttonColor){
        Button button = new Button(textButton);
        button.setStyle("-fx-background-color: " + buttonColor + "; -fx-text-fill: #fff;");
        button.setLayoutY(positionY);
        button.setLayoutX(positionX);
        return button;
    }

    /**
     * Overload method create button to also receive the font size text
     * @param textButton the text that will be displayed in the button
     * @param positionY the button position in y
     * @param positionX the button position in x
     * @param buttonColor the button background color
     * @param fontSize the button text font size
     * @return the button created
     */
    public Button createButton(String textButton, int positionY, int positionX, String buttonColor, int fontSize){
        Button button = new Button(textButton);
        button.setStyle("-fx-background-color: " + buttonColor + "; -fx-text-fill: #fff; -fx-font-size: " + fontSize);
        button.setLayoutY(positionY);
        button.setLayoutX(positionX);
        return button;
    }

    /**
     * This method returns a TextField created with simple parameters
     * @param initialMessage the initial default hint text displayed on the field
     * @param fieldWidth the field width
     * @param fieldHeight the field height
     * @param alignment the field alignment
     * @param positionX the field position in X
     * @param positionY the field position in Y
     * @return the text field created
     */
    public TextField createTextField(
            String initialMessage, int fieldWidth, int fieldHeight, Pos alignment, int positionX, int positionY) {
        TextField textField = new TextField();
        textField.setPromptText(initialMessage);
        textField.setPrefWidth(fieldWidth);
        textField.setAlignment(alignment);
        textField.setPrefHeight(fieldHeight);
        textField.setLayoutX(positionX);
        textField.setLayoutY(positionY);
        return textField;
    }
}
