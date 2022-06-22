package com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Login  {
    static ArrayList<Account2> account2s = new ArrayList<>();

    public Login() {
    }

    public GridPane  setLogin() throws IOException, ClassNotFoundException {


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        SmallKeyBoard smallKeyBoard = new SmallKeyBoard();
        GridPane gridPane1 = smallKeyBoard.setSmallKeyBoard();
        gridPane.add(gridPane1,1,10);
        Label label = new Label("ATM");
        label.setFont(new Font(40));
        Label label1 = new Label("用户名: ");
        label1.setFont(new Font(15));
        Label label2 = new Label("密码: ");
        label2.setFont(new Font(15));
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        smallKeyBoard.clickpassword(passwordField);
        Button buttonlogin = new Button("登录");
        buttonlogin.setOnAction(event -> {
            try {
                account2s =deserialization();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < account2s.size(); i++) {
                if (account2s.get(i).getName().equals(textField.getText())){
                    if (passwordField.getText().length()>=6 &&passwordField.getText().length()<=10){
                        if (account2s.get(i).getPassword().equals(passwordField.getText())){
                            gridPane.setVisible(false);
                            Menu menu = new Menu();
                            menu.setMenu(account2s.get(i));
                        }else {
                            Label label3 = new Label("密码错误,请重新输入");
                            newStage(label3);
                        }
                    }else {
                        Label label4 = new Label("密码长度不对,请重新输入");
                        newStage(label4);
                    }
                }
            }

        });


        Button buttonregister = new Button("退出");
        buttonregister.setOnAction(event -> {
            Platform.exit();
        });

        gridPane.add(label,1,0);
        gridPane.add(label1,0,3);
        gridPane.add(label2,0,4);
        gridPane.add(textField,1,3);
        gridPane.add(passwordField,1,4);
        gridPane.add(buttonlogin,0,7);
        gridPane.add(buttonregister,2,7);


        return gridPane;
    }



    public static void serialization(ArrayList<Account2> account2) throws IOException {
        File file = new File("E:\\java课\\课设\\1_version2\\accounts.dat");
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            outputStream.writeObject(account2);
        }
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

    public void newStage(Label label){
        Scene scene = new Scene(label,200,200);
        label.setAlignment(Pos.CENTER);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
