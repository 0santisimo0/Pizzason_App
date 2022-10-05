package com.example.pizasson.Controller;

import com.example.pizasson.Stages.PizassonScreenStage;
import com.example.pizasson.utils.JavaFXComponents;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is in charge of controlling the display of the splash screen.
 * The class controls the display of the icon and the title of the restaurant
 *
 * @author Santiago Caballero
 */
public class SplashScreenController {
    @FXML
    private VBox startBox;
    @FXML
    private ImageView icon;

    /**
     * This method gets the event everytime the icon image is clicked
     * With this method the next scene will be displayed when the user clicks the icon
     */
    @FXML
    private void manageImgTouch() {
        icon.setOnMouseClicked(mouseEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(PizassonScreenStage.class.getResource("HomeOrderView.fxml"));
            Scene homeOrderScene;
            try {
                homeOrderScene = new Scene(fxmlLoader.load(), 1100, 700);
                HomeOrderController homeOrderController = fxmlLoader.getController();
                homeOrderController.initialize();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Stage homeOrderStage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
            homeOrderStage.setTitle("Home Order");
            homeOrderStage.setScene(homeOrderScene);
            homeOrderStage.show();
        });
    }

    /**
     * This method modifies an animation with the icon just to give style to the splash screen
     */
    private void animateIcon() {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(4));
        translateTransition.setNode(icon);
        translateTransition.setFromY(-50);
        translateTransition.setToY(-35);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(10);
        translateTransition.play();
    }

    /**
     * the method imports the icon from the files, assigns to an ImageView to be displayed
     * @throws FileNotFoundException when the file can not be imported
     */
    private void createImgIconView () throws FileNotFoundException {
        icon = JavaFXComponents.getJavaFXComponents().createImage("src/main/resources/images/pizzaLogo.png"
                ,200,200,0,0);
        icon.getStyleClass().add("ImgPizza");
    }

    /**
     * This method imports the title image, assigns it to a ImageView to be displayed on the screen
     *
     * @return the imageView of the title to display it on the screen
     * @throws FileNotFoundException everytime the file can not be imported
     */
    private ImageView createTitleImgView () throws FileNotFoundException {
        ImageView titleView = JavaFXComponents.getJavaFXComponents()
                .createImage("src/main/resources/images/titleIcon.png"
                        , 300,100,0,0);

        titleView.getStyleClass().add("ImgPizza");
        return titleView;
    }

    /**
     * The main method to call the other methods, import images, add to the Vbox, animation.
     * @throws FileNotFoundException everytime the file can not be imported
     */
    private void startSplashScreen() throws FileNotFoundException {
        createImgIconView();
        manageImgTouch();
        startBox.getChildren().addAll(createTitleImgView(),icon);
        animateIcon();
    }

    /**
     * This method initialize the splashscreen
     * @throws FileNotFoundException everytime the file can not be imported
     */
    @FXML
    public void initialize() throws FileNotFoundException {
        startSplashScreen();
    }
}
