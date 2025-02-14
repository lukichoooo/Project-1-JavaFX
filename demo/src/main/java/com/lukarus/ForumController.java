package com.lukarus;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class ForumController implements Initializable {


    @FXML
    private WebView webView;


@FXML
private void handleHomeButton() {
    System.out.println("Home button clicked!");
}

@FXML
private void handleProfileButton() {
    System.out.println("User button clicked!");
}

@FXML
private void handleTopReviewsButton() {
    System.out.println("Top Reviews button clicked!");
}

@FXML
private void handleLogOutButton() {
    System.out.println("Log Out button clicked!");
}

@FXML
private void handlePreviousButton() {
    System.out.println("previus button clicked!");
}

@FXML
private void handleNextButton() {
    System.out.println("next button clicked!");
}

@Override
public void initialize(URL location, ResourceBundle resources) {
    if (webView != null) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://google.com"); // replace this with my webpage (i have to make it first)
    }
}



}


class ForumDAO {

}