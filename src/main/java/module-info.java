module org.example.csp_games {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    requires unirest.java;


    opens org.example.csp_games to javafx.fxml;
    exports org.example.csp_games;
}