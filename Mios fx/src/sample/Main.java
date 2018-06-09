package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 640, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("cssfx.css");
        Button boton = new Button();
        boton.setLabel("Hola!");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
