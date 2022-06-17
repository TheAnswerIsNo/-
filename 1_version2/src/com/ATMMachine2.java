package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMMachine2 implements Serializable {
    public static void main(String[] args) throws Account1.balanceException, IOException, Account2.idException, ClassNotFoundException {
        ArrayList<Account2> account2s = new ArrayList<>();
        serialization(account2s);
        ArrayList<Account2> list = deserialization();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Main menu");
            System.out.println("0：create a account");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4：details of the transaction");
            System.out.println("5: change password");
            System.out.println("6: exit");
            System.out.println("请输入功能前序号");
            String choose = scanner.next();
            if (choose.equals("0")){
                createaaccount();
                continue;
            }if (choose.equals("6")){
                System.out.println("欢迎下次光临");
                return;
            }else {
                System.out.println("请输入用户名");
                Account2 account2 = new Account2();
                String name = scanner.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(name)){
                        account2=list.get(i);
                        break;
                    }
                }
                switch (choose) {
                    case "1":
                        checkbalance(account2);
                        break;
                    case "2":
                        withDraw(account2);
                        break;
                    case "3":
                        deposit(account2);
                        break;
                    case "4":
                        detailsOfTheTransaction(account2);
                        break;
                    case "5":
                        changepassword(account2);
                        break;
                }
            }
        }
    }
    public static void detailsOfTheTransaction(Account2 account2){
        for (int i = 0; i < account2.getTransactions().size(); i++) {
            account2.getTransactions().get(i).toString();
        }
    }
    //创建一个账户
    public static void createaaccount() throws Account2.idException, Account1.balanceException, IOException, ClassNotFoundException {
        ArrayList<Account2> list = deserialization();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        System.out.println("请输入金额");
        double balance = scanner.nextDouble();
        System.out.println("请输入年利率");
        double annualInterestRate = scanner.nextDouble();
        Account2 account2 = new Account2(balance, name, password, annualInterestRate);
        list.add(account2);
        serialization(list);
        System.out.println("创建账户成功");
    }
    //检查账户余额
    public static void checkbalance(Account2 account2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码");
        String password = scanner.next();
        System.out.println(account2.getPassword());
        if (password.equals(account2.getPassword())){
            System.out.println(account2.getBalance());
        }else {
            System.out.println("密码错误");
        }
    }
    //取钱
    public static void withDraw(Account2 account2) throws IOException, ClassNotFoundException {
        ArrayList<Account2> list = deserialization();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码");
        String password = scanner.next();
        if (password.equals(account2.getPassword())){
            System.out.println("请输入所要支出金额");
            double money = scanner.nextDouble();
            account2.withDraw(money);
            for (int i = 0; i < list.size(); i++) {
                if (account2.getName()==list.get(i).getName()){
                    list.get(i).setBalance(account2.getBalance());
                }
            }
            serialization(list);
        }else {
            System.out.println("密码错误");
        }
    }
    //存钱
    public static void deposit(Account2 account2) throws IOException, ClassNotFoundException {
        ArrayList<Account2> list = deserialization();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码");
        String password = scanner.next();
        if (password.equals(account2.getPassword())){
            System.out.println("请输入所要存入的金额");
            double money = scanner.nextDouble();
            account2.deposit(money);
            for (int i = 0; i < list.size(); i++) {
                if (account2.getName()==list.get(i).getName()){
                    list.get(i).setBalance(account2.getBalance());
                }
            }
            serialization(list);
        }else {
            System.out.println("密码错误");
        }
    }
    //修改密码
    public static void changepassword(Account2 account2) throws IOException, ClassNotFoundException {
        ArrayList<Account2> list = deserialization();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码");
        String password = scanner.next();
        if (password.equals(account2.getPassword())){
            System.out.println("请输入您的新密码");
            String newpassword = scanner.next();
            account2.changePassword(newpassword);
            for (int i = 0; i < list.size(); i++) {
                if (account2.getName()==list.get(i).getName()){
                    list.get(i).setPassword(newpassword);
                }
            }
            serialization(list);
        }else {
            System.out.println("密码错误");
        }
    }
    //序列化
    public static void serialization(ArrayList<Account2> account2) throws IOException {
        File file = new File("E:\\java课\\课设\\1_version2\\accounts.dat");
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            outputStream.writeObject(account2);
        }
    }
    //反序列化
    public  static ArrayList<Account2> deserialization() throws IOException, ClassNotFoundException {
        ArrayList<Account2> account2s = new ArrayList<>();
        File file = new File("E:\\java课\\课设\\1_version2\\accounts.dat");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        ){
            if (account2s==null){
                account2s = (ArrayList<Account2>) objectInputStream.readObject();
            }
        }catch (EOFException e){
            return account2s;
        }
        return account2s;
    }
}
