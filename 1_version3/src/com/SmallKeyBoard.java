package com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SmallKeyBoard {
    String string = "";
    Button button0 = new Button("0");
    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");
    Button button9 = new Button("9");
    Button buttonenter = new Button("ENTER");
    Button buttonclear = new Button("CLEAR");
    public SmallKeyBoard() {
    }

    public GridPane setSmallKeyBoard(){

        GridPane gridPane1 = new GridPane();


        button0.setMaxWidth(Double.MAX_VALUE);
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);
        button4.setMaxWidth(Double.MAX_VALUE);
        button5.setMaxWidth(Double.MAX_VALUE);
        button6.setMaxWidth(Double.MAX_VALUE);
        button7.setMaxWidth(Double.MAX_VALUE);
        button8.setMaxWidth(Double.MAX_VALUE);
        button9.setMaxWidth(Double.MAX_VALUE);
        buttonclear.setMaxWidth(Double.MAX_VALUE);
        buttonenter.setMaxWidth(Double.MAX_VALUE);


        gridPane1.add(button1,0,2);
        gridPane1.add(button2,1,2);
        gridPane1.add(button3,2,2);
        gridPane1.add(button4,0,1);
        gridPane1.add(button5,1,1);
        gridPane1.add(button6,2,1);
        gridPane1.add(button7,0,0);
        gridPane1.add(button8,1,0);
        gridPane1.add(button9,2,0);
        gridPane1.add(button0,0,3);
        gridPane1.add(buttonclear,1,3);
        gridPane1.add(buttonenter,2,3);


        return gridPane1;
    }

    public void clickpassword(PasswordField passwordField){
            button0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="0";
                    passwordField.setText(string);
                }
            });
            button1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="1";
                    passwordField.setText(string);
                }
            });
            button2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="2";
                    passwordField.setText(string);
                }
            });
            button3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="3";
                    passwordField.setText(string);
                }
            });
            button4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="4";
                    passwordField.setText(string);
                }
            });
            button5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="5";
                    passwordField.setText(string);
                }
            });
            button6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="6";
                    passwordField.setText(string);
                }
            });
            button7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="7";
                    passwordField.setText(string);
                }
            });
            button8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="8";
                    passwordField.setText(string);
                }
            });
            button9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    string+="9";
                    passwordField.setText(string);
                }
            });
            buttonclear.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        passwordField.setText("");
                        string="";
                }
            });
        }

        public void click(TextField textField){
            button0.setOnAction(event -> {
                string+="0";
                textField.setText(string);
            });
            button1.setOnAction(event -> {
                string+="1";
                textField.setText(string);
            });
            button2.setOnAction(event -> {
                string+="2";
                textField.setText(string);
            });
            button3.setOnAction(event -> {
                string+="3";
                textField.setText(string);
            });
            button4.setOnAction(event -> {
                string+="4";
                textField.setText(string);
            });
            button5.setOnAction(event -> {
                string+="5";
                textField.setText(string);
            });
            button6.setOnAction(event -> {
                string+="6";
                textField.setText(string);
            });
            button7.setOnAction(event -> {
                string+="7";
                textField.setText(string);
            });
            button8.setOnAction(event -> {
                string+="8";
                textField.setText(string);
            });
            button9.setOnAction(event -> {
                string+="9";
                textField.setText(string);
            });
            buttonclear.setOnAction(event -> {
               textField.setText("");
               string="";
            });
            buttonenter.setOnAction(event -> {

            });
        }
}
