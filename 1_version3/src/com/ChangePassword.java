package com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ChangePassword {
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
    String string="";
    public ChangePassword() {
    }

    public void setChangePassword( Account2 account2){


        FlowPane flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        HBox hBox = new HBox();
        Label label = new Label("原密码: ");
        TextField textField = new TextField();
        hBox.getChildren().addAll(label,textField);


        HBox hBox1 = new HBox();
        Label label1 = new Label("新密码: ");
        TextField textField1 = new TextField();
        hBox1.getChildren().addAll(label1,textField1);


        HBox hBox2 = new HBox();
        Label label2 = new Label("再次输入密码: ");
        TextField textField2 = new TextField();
        hBox2.getChildren().addAll(label2,textField2);

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


        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="0";
                textField.setText(string);
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="1";
                textField.setText(string);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="2";
                textField.setText(string);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="3";
                textField.setText(string);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="4";
                textField.setText(string);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="5";
                textField.setText(string);
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="6";
                textField.setText(string);
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="7";
                textField.setText(string);
            }
        });
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="8";
                textField.setText(string);
            }
        });
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                string+="9";
                textField.setText(string);
            }
        });
        buttonclear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField.setText("");
                string="";
            }
        });
        buttonenter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textField.getText().equals(account2.getPassword())){
                    if (textField1.getText().equals(textField2.getText())){
                        for (int i = 0; i < account2s.size(); i++) {
                            if (account2.getName().equals(account2s.get(i).getName())){
                                account2s.get(i).setPassword(String.valueOf(textField1));
                                try {
                                    serialization(account2s);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Label label3 = new Label("修改成功");
                        newStage(label3);
                    }else {
                        Label label3 = new Label("第二次密码错误");
                        newStage(label3);
                    }
                }else {
                    Label label3 = new Label("原密码错误");
                    newStage(label3);
                }
            }
        });


        flowPane.getChildren().addAll(hBox,hBox1,hBox2,gridPane);

        Scene scene = new Scene(flowPane,600,500);
        Stage stage = new Stage();
        stage.setTitle("修改密码");
        stage.setScene(scene);
        stage.show();
    }
    public void newStage(Label label){
        Scene scene = new Scene(label,200,200);
        label.setAlignment(Pos.CENTER);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
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
