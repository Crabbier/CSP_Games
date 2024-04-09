package org.example.csp_games;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GamesGenres {

    public int genreId;

    public String name;

    public GamesGenres(int genreId, String genreName) {
        this.genreId = genreId;
        this.name = genreName;
    }

    // Getters and setters for gameID
    public int genreIdProperty() { return genreId;}

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    // Getters and setters for name
    public String nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Genre: \n" +
                "genreId=" + genreId + "\n" +
                "name=" + name + "\n";
    }
}
