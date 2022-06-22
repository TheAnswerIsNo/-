package com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class ATMMachine3 extends Application {


    static Account2 account2;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Login login = new Login();
        GridPane gridPane = login.setLogin();

        Scene scene = new Scene(gridPane,600,500);
        stage.setTitle("ATMMachine");
        stage.setScene(scene);
        stage.show();
    }
}
