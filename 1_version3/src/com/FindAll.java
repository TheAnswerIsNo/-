package com;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class FindAll {
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
    public FindAll() {
    }
    public void setFindAll(Account2 account2){
        for (int i = 0; i < account2s.size(); i++) {
            if (account2.getName().equals(account2s.get(i).getName())){
                TableView<Transaction> objectTableView = new TableView<>();

                TableColumn<Transaction,Character> objectObjectTableColumn = new TableColumn<>("类型");
                objectObjectTableColumn.setCellValueFactory(new PropertyValueFactory<>("tpye"));

                TableColumn<Transaction,Double> objectObjectTableColumn1 = new TableColumn<>("交易量");
                objectObjectTableColumn1.setCellValueFactory(new PropertyValueFactory<>("amount"));

                TableColumn<Transaction,Double> objectObjectTableColumn2 = new TableColumn<>("余额");
                objectObjectTableColumn2.setCellValueFactory(new PropertyValueFactory<>("balance"));

                TableColumn<Transaction, String> objectObjectTableColumn3 = new TableColumn<>("描述");
                objectObjectTableColumn3.setCellValueFactory(new PropertyValueFactory<>("description"));

                objectTableView.getColumns().add(objectObjectTableColumn);
                objectTableView.getColumns().add(objectObjectTableColumn1);
                objectTableView.getColumns().add(objectObjectTableColumn2);
                objectTableView.getColumns().add(objectObjectTableColumn3);
                ArrayList<Transaction> transactions = account2.getTransactions();
                for (int i1 = 0; i1 < transactions.size(); i1++) {
                    objectTableView.getItems().add(account2.getTransactions().get(i));
                }



                Scene scene = new Scene(objectTableView);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            }
        }
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
}
