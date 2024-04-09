package org.example.csp_games;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GamesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(GamesApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1171, 787);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        // Load and set the application icon
        Image image = new Image(getClass().getResourceAsStream("/images/browser-coding-svgrepo-com.png"));
        stage.getIcons().add(image);
        stage.setTitle("CSP Games");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException, UnirestException {
        launch();
    }
}