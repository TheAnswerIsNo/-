package com;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class test extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FlowPane flowPane = new FlowPane();
        HBox hBox1 = new HBox();
        for (int i = 0; i < 26; i++) {
            Label label1 = new Label(""+(char)(i+65));
            Rectangle rectangle = new Rectangle();
            rectangle.setStyle("-fx-stroke:black;-fx-fill: white; ");
            rectangle.setWidth(10);
            rectangle.setHeight(0);
            label1.setGraphic(rectangle);
            label1.setContentDisplay(ContentDisplay.TOP);
            hBox1.getChildren().add(label1);
                    }
        flowPane.getChildren().add(hBox1);

        Label label = new Label("Filename: ");
        TextField textField = new TextField();
        Button button = new Button("View");
        button.setOnAction(event -> {

            String string = textField.getText();
            File file = new File(string);
            char[] list = new char[0];
            try {
                list = read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int[] sum = getsum(list);
            for (int i = 0; i < 26; i++) {
                Label label1 = new Label(""+(char)(i+65));
                Rectangle rectangle1 = new Rectangle();
                rectangle1.setStyle("-fx-stroke:black;-fx-fill: white; ");
                rectangle1.setWidth(10);
                rectangle1.setHeight(10*sum[i+65]);
                label1.setGraphic(rectangle1);
                label1.setContentDisplay(ContentDisplay.TOP);
                hBox1.getChildren().set(i,label1);
                hBox1.setAlignment(Pos.BOTTOM_CENTER);
            }
        });


        flowPane.setAlignment(Pos.BOTTOM_CENTER);
        flowPane.setOrientation(Orientation.VERTICAL);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(label,textField,button);
        flowPane.getChildren().addAll(hBox);
        Scene scene = new Scene(flowPane,450,300);
        stage.setScene(scene);
        stage.show();
    }
    public static int[] getsum(char[] list){
        int[] sum = new int[255];
        for (int i = 0; i < list.length; i++) {
            if (list[i]>='A' && list[i]<='Z'){
                sum[(int)list[i]]++;
            }else if(list[i]>='a' && list[i]<='z'){
                sum[((int)list[i])-32]++;
            }
        }
        return sum;
    }
    public static char[] read(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        char[] list = new char[1024];
        while (true) {
            int i = fileReader.read(list);
            if (i == -1) {
                break;
            }
        }
        fileReader.close();
        return list;
    }
}
