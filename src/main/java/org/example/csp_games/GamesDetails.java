package org.example.csp_games;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GamesDetails {

//  Define variables
    public IntegerProperty gameID;
    public StringProperty name;
    public StringProperty slug;
    public StringProperty storyline;
    public StringProperty summary;
    public StringProperty url;
    public StringProperty image;

//  Define constructor
    public GamesDetails(int gameID, String name, String slug, String storyLine, String summary, String url, String image) {
        this.gameID = new SimpleIntegerProperty(gameID);
        this.name = new SimpleStringProperty(name);
        this.slug = new SimpleStringProperty(slug);
        this.storyline = new SimpleStringProperty(storyLine);
        this.summary = new SimpleStringProperty(summary);
        this.url = new SimpleStringProperty(url);
        this.image = new SimpleStringProperty(image);
    }

    // Getters and setters for gameID
    public IntegerProperty gameIDProperty() {
        return gameID;
    }

    public void setGameID(IntegerProperty gameID) {
        this.gameID = gameID;
    }

    // Getters and setters for name
    public StringProperty nameProperty() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public StringProperty slugProperty() {
        return slug;
    }

    public void setSlug(StringProperty slug) {
        this.name = slug;
    }

    public StringProperty storyLyneProperty() {
        return storyline;
    }

    public void setStoryLyne(StringProperty storyLyne) {
        this.name = storyLyne;
    }

    public StringProperty summaryProperty() {
        return summary;
    }

    public void setSummary(StringProperty summary) {
        this.name = summary;
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(StringProperty url) {
        this.name = url;
    }

    public StringProperty imageProperty() {
        return image;
    }

    public void setImage(StringProperty image) {
        this.image = image;
    }

    public String toString() {
        return "Games: \n" +
                "gameID=" + gameID.get() +
                ", name='" + name.get() + '\'' +
                ", slug='" + slug.get() + '\'' +
                ", storyline='" + storyline.get() + '\'' +
                ", summary='" + summary.get() + '\'' +
                ", url='" + url.get() + '\'' +
                ", image='" + image.get() + '\'' +
                '}';
    }

}
