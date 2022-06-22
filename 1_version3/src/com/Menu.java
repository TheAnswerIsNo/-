package com;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    public Menu() {
    }

    public void setMenu(Account2 account2) {


        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        VBox vBox = new VBox();
        Label label = new Label("账户余额: "+account2.getBalance());
        Label label1 = new Label("请选择项目");
        vBox.getChildren().addAll(label,label1);
        label.setAlignment(Pos.CENTER);
        gridPane.add(vBox,1,0);


        Button deposit = new Button("存款");
        Button withDraw = new Button("取款");
        Button changepassword = new Button("修改密码");
        Button findAll = new Button("查询");
        Button quit = new Button("退卡");


        deposit.setMaxWidth(Double.MAX_VALUE);
        withDraw.setMaxWidth(Double.MAX_VALUE);
        changepassword.setMaxWidth(Double.MAX_VALUE);
        findAll.setMaxWidth(Double.MAX_VALUE);
        quit.setMaxWidth(Double.MAX_VALUE);



        deposit.setOnAction(event -> {
            Deposit deposit1 = new Deposit();
            deposit1.setDeposit(account2);
        });

        withDraw.setOnAction(event -> {
            WithDraw withDraw1 = new WithDraw();
            withDraw1.setWithDraw(account2);
        });

        changepassword.setOnAction(event -> {
            ChangePassword changePassword = new ChangePassword();
            changePassword.setChangePassword(account2);
        });

        findAll.setOnAction(event -> {
            FindAll findAll1 = new FindAll();
            findAll1.setFindAll(account2);
        });

        quit.setOnAction(event -> {
            Login login = new Login();
            try {
                GridPane gridPane1 = login.setLogin();
                Scene scene = new Scene(gridPane1);
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


        gridPane.add(deposit,0,3);
        gridPane.add(withDraw,1,3);
        gridPane.add(changepassword,2,3);
        gridPane.add(findAll,0,4);
        gridPane.add(quit,1,4);




        Scene scene = new Scene(gridPane,600,500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
