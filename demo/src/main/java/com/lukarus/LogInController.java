package com.lukarus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        checkLogIn();
    }

    //Sign up button press
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
        // if(checkUser()) createAccount()
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

    public void createAccount(String user,String pass){
        String query = "insert into "+table+"(username,password) values(?,?);";
        try {
            PreparedStatement pst = con.prepareStatement(query);

            // insert into database password and username
            pst.setString(1,user);
            pst.setString(2,pass);
    
            int count = pst.executeUpdate();
            System.out.println(count + " rows changed");
        pst.close();
        } catch (Exception e) {System.err.println(e);}
    }

    //returns true if user is in database
    public boolean checkUser(String user){
        String query = "SELECT * FROM users WHERE username ="+user;

            try {
                PreparedStatement pst = con.prepareStatement(query);
    
                pst.setString(1, user);

                ResultSet rs = pst.executeQuery(query);
                
                //if rs is empty it means we dont have user in our database

                return !rs.isBeforeFirst();

            } catch (Exception e) {System.err.println(e);}

            return true;
        }


        public void test(){
            String query = "select username from "+table+" where rollno="+"1";
            String S;
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
    
                String studName = rs.getNString(1);
                S=studName;
                
                System.out.println(S);
            st.close();
            } catch (Exception e) {System.err.println(e);}
    
        }
}


