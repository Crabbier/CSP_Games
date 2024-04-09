package org.example.csp_games;

public class GamesImages {

    public int id;
    public int gameId;
    public String imageId;

    // Constructor
    public GamesImages(int id, int gameId, String imageId) {
        this.id = id;
        this.gameId = gameId;
        this.imageId = imageId;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for gameId
    public int getGameId() {
        return gameId;
    }

    // Setter for gameId
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    // Getter for imageId
    public String getImageId() {
        return imageId;
    }

    // Setter for imageId
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "GamesImage: \n" +
                "id=" + id +
                ", gameId=" + gameId +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
