package com.lukarus;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    // register/login scene
    private static Scene loginScene;

    @Override
    public void start(Stage loginStage) throws IOException {
        loginScene = new Scene(loadFXML("logIn"));
        loginStage.setScene(loginScene);
        loginStage.setResizable(false);
        loginStage.setTitle("LGR");
        Image icon = new Image(getClass().getResourceAsStream("/com/lukarus/LGRicon.jpg"));
        loginStage.getIcons().add(icon);
        loginStage.show();
    }


    static void setRoot(String fxml) throws IOException {
        loginScene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void changeScene(){
        // idk yet
    }

    public static void main(String[] args) {
        launch();

        //testing stuff
        DAO dao = new DAO();
        System.out.print(dao.checkUser("lukaa"));

        dao.test();
    }

}