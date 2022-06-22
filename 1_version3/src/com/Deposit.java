package com;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class Deposit {
    static ArrayList<Account2> account2s = new ArrayList<>();

    static {
        try {
            account2s = deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    String string = "";
    public Deposit() {
    }

    public void setDeposit(Account2 account2){

        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        HBox hBox = new HBox();
        Label label = new Label("存款金额: ");
        TextField textField = new TextField();
        hBox.getChildren().addAll(label,textField);

        GridPane gridPane = new GridPane();
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
            for (int i = 0; i < account2s.size(); i++) {
                if (account2s.get(i).getName().equals(account2.getName())){
                    account2s.get(i).setBalance(account2s.get(i).getBalance()+Double.valueOf(String.valueOf(textField)));
                    try {
                        serialization(account2s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        gridPane.add(button1,0,2);
        gridPane.add(button2,1,2);
        gridPane.add(button3,2,2);
        gridPane.add(button4,0,1);
        gridPane.add(button5,1,1);
        gridPane.add(button6,2,1);
        gridPane.add(button7,0,0);
        gridPane.add(button8,1,0);
        gridPane.add(button9,2,0);
        gridPane.add(button0,0,3);
        gridPane.add(buttonclear,1,3);
        gridPane.add(buttonenter,2,3);


        flowPane.getChildren().addAll(hBox,gridPane);



        Scene scene = new Scene(flowPane,600,500);
        Stage stage = new Stage();
        stage.setTitle("存款");
        stage.setScene(scene);
        stage.show();
    }
    public  static ArrayList<Account2> deserialization() throws IOException, ClassNotFoundException {
        ArrayList<Account2> account2s = new ArrayList<>();
        File file = new File("E:\\java课\\课设\\1_version2\\accounts.dat");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        ){
            if (account2s==null){
                account2s =(ArrayList<Account2>) objectInputStream.readObject();
            }
        }catch (EOFException e){
            return account2s;
        }
        return account2s;
    }

    public static void serialization(ArrayList<Account2> account2) throws IOException {
        File file = new File("E:\\java课\\课设\\1_version2\\accounts.dat");
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            outputStream.writeObject(account2);
        }
    }

}
