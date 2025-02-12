package com.lukarus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LogInController {

    @FXML
    private TextField signInPassword;
    @FXML
    private TextField signInUsername;
    @FXML
    private TextField signUpUsername;
    @FXML
    private TextField signUpPassword;

    @FXML
    private Label wrongSignIn;
    @FXML
    private Label wrongSignUp;

    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;

    public void userSignIn(){
        checkLogIn();
    }

    public void userSignUp(){
        createAccount();
    }


    public void checkLogIn(){
        if(signInUsername.getText().toString().equals("luka") && signInPassword.getText().toString().equals("luka123")){
            wrongSignIn.setTextFill(Color.GREEN);
            wrongSignIn.setText("Signing in");
        } 
        else {
            wrongSignIn.setTextFill(Color.RED);
            wrongSignIn.setText("Incorrect Sign in");
        }
    }

    public void createAccount(){

    }
}
