package com.lukarus;

import javafx.fxml.FXML;

public class ForumController {
    @FXML
private void handleHomeButton() {
    System.out.println("Home button clicked!");
}

@FXML
private void handleUserButton() {
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

}