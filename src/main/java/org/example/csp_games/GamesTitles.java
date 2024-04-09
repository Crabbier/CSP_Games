package org.example.csp_games;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GamesTitles {

    public IntegerProperty id;
    public StringProperty name;

    // Constructor
    public GamesTitles(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    // Getter for id
    public IntegerProperty gameIDProperty() {
        return id;
    }

    public void setGameID(IntegerProperty gameID) {
        this.id = gameID;
    }

    // Getters and setters for name
    public StringProperty nameProperty() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "GamesTitles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
