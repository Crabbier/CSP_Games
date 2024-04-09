package org.example.csp_games;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class GamesController {
    @FXML
    private ComboBox<String> cmbx_genre;

    @FXML
    private TableView<GamesTitles> gamesTable;

    @FXML
    private TableColumn<GamesTitles, String> list_games;

    @FXML
    private TextField txf_search;

    @FXML
    private Button search_btn;

//  create an observable list to display the data in the table and the combo box
    private ObservableList<GamesTitles> gamesList = FXCollections.observableArrayList();

    private ObservableList<GamesGenres> gamesGenres = FXCollections.observableArrayList();

//  Function excecuting when the fxml view is displayed
    @FXML
    public void initialize() throws UnirestException, IOException, InterruptedException {

        List <GamesGenres> genres = new ArrayList<>();

        genres = APIConnection.getGenres();

//         Insert genres in the combo box
            for (GamesGenres genre : genres) {
                cmbx_genre.getItems().addAll(genre.name);
        }

        // Set default values
        cmbx_genre.setValue("Shooter");
        String DefaultSelectedGenre = cmbx_genre.getValue();
//
        populateTable(DefaultSelectedGenre);

        cmbx_genre.setOnAction(event -> {
            String selectedGenre = cmbx_genre.getSelectionModel().getSelectedItem();
            if (selectedGenre != null) {
                populateTable(selectedGenre);
            }
        });

        // Set up double-click event handler for the TableView
        gamesTable.setRowFactory(tv -> {
            TableRow<GamesTitles> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    GamesTitles selectedGame = row.getItem();
                    openNewScene(selectedGame); // Open a new scene with the selected game
                }
            });
            return row;
        });
    }

    @FXML
    void searchGame(ActionEvent event) {
        // call populateBySearch using the text inside the text field
        populateBySearch(txf_search.getText());
    }

    private void openNewScene(GamesTitles selectedGame) {
        try {
            // Load the new FXML file for the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("details-view.fxml"));
            Parent root = loader.load();

            // Pass the selected game to the controller of the new scene
            GamesDetailsController controller = loader.getController();
            controller.setGame(selectedGame);

            // Create the new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            Image image = new Image(getClass().getResourceAsStream("/images/browser-coding-svgrepo-com.png"));
            stage.getIcons().add(image);
            stage.setTitle("CSP Games - Details");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateBySearch(String searchWord) {
        // empty the current list of games
        gamesList.clear();

        // Add the sale object to the obsverbable list 'gamesList'
        gamesList.addAll(APIConnection.getAllGamesByWord(searchWord));

        // Populate the table with the data on the list
        list_games.setCellValueFactory(cellData -> cellData.getValue().name);

        gamesTable.setItems(gamesList);
    }

    private void populateTable(String selectedGenre){
        // empty the current list of games
        gamesList.clear();

        // Add the sale object to the obsverbable list 'gamesList'
        gamesList.addAll(APIConnection.getAllGames(selectedGenre));

        // Populate the table with the data on the list
        list_games.setCellValueFactory(cellData -> cellData.getValue().name);

        gamesTable.setItems(gamesList);


    }

}
