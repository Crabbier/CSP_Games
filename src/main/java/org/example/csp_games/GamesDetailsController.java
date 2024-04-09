package org.example.csp_games;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamesDetailsController {

    @FXML
    private ImageView gameImage;

    @FXML
    private Label gameTitle;

    @FXML
    private Hyperlink gameUrl;

    @FXML
    private Label txtGameSlug;

    @FXML
    private Label txtGameSummary;

    @FXML
    private Label txtStoryLine;

    @FXML
    private Button back_btn;

    @FXML
    void changeListView(ActionEvent event) {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    public void initialize() {

    }

    private ObservableList<GamesDetails> gamesDetails = FXCollections.observableArrayList();
    public void setGame(GamesTitles selectedGame) {
        IntegerProperty id = selectedGame.id;

        GamesDetails gameDetail = APIConnection.getGameDetails(id.getValue().intValue());

        gameTitle.setText(gameDetail.name.getValue());
//        gameUrl.setText(gameDetail.url.getValue());
        txtGameSlug.setText(gameDetail.slug.getValue());
        txtGameSummary.setText(gameDetail.summary.getValue());
        txtStoryLine.setText(gameDetail.storyline.getValue());
        gameImage.setImage(new Image(gameDetail.image.getValue()));

    }

}


