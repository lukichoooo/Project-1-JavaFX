package com.lukarus;

import javafx.fxml.FXML;

public class ForumController {

    

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

}


class ForumDAO {

}