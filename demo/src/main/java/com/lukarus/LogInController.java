package com.lukarus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    // connector object DAO
    DAO dao = new DAO();

    //Sign in button press
    public void userSignIn(){
        dao.connect();

        checkLogIn();

        dao.disconnect();
    }

    //Sign up button press
    public void userSignUp(){
        dao.connect();

        createAccount();

        dao.disconnect();
    }


    public void checkLogIn(){

        if(dao.checkLogInData(signInUsername.getText().toString(),signInPassword.getText().toString())){
            wrongSignIn.setTextFill(Color.GREEN);
            wrongSignIn.setText("Signing in");
        }
        else {
            wrongSignIn.setTextFill(Color.RED);
            wrongSignIn.setText("Incorrect username or password");
        }
    }

    public void createAccount(){

        if(signUpUsername.getText().toString().length()>40
        || signUpPassword.getText().toString().length()>45) {
            wrongSignUp.setTextFill(Color.RED);
            wrongSignUp.setText("Username or Password too long ");
        }
        else{
        if(!dao.checkUser(signUpUsername.getText().toString())) {
        dao.createAccountData(signUpUsername.getText().toString(),signUpPassword.getText().toString());
        wrongSignUp.setTextFill(Color.GREEN);
        wrongSignUp.setText("Account created");
        }
        else {
            wrongSignUp.setTextFill(Color.RED);
            wrongSignUp.setText("Username already in use");
        }
    }

    }
}


// DAO - Data Access Object
// this class helps me connect and access my MySQL database
class DAO{

    private static final String url = "jdbc:mysql://localhost:3306/login_schema";
    private static final String user = "root";
    private static final String password = "luka123";
    private static final String table = "users";

    Connection con=null;
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {System.err.println(e);}
    }
    public void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public void createAccountData(String user,String pass){
        String query = "insert into "+table+"(username,password) values(?,?);";
        try {
            PreparedStatement pst = con.prepareStatement(query);

            // insert into database password and username
            pst.setString(1,user);
            pst.setString(2,pass);
    
            int count = pst.executeUpdate();
            System.out.println(count + " rows changed");
        pst.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    // returns true if user is in database
    public boolean checkUser(String user) {
        String query = "SELECT * FROM "+table+" WHERE username = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user);

            ResultSet rs = pst.executeQuery();

            // if rs is empty it means we don't have user in our database
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // returns true if user and password is correct
    public boolean checkLogInData(String user, String pass){
        String query = "SELECT * FROM "+table+" WHERE username = ? AND password = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            // if rs is empty it means we don't have user in our database
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}


