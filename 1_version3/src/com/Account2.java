package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Account2 extends Account1 implements Serializable {
    private String password;
    private String name;
    private ArrayList<Transaction> transactions;

    public Account2(double balance, String name , String password, double annualInterestRate) throws balanceException {
        super((int)Math.random() * 100,balance,annualInterestRate);
        this.password=password;
        this.name=name;
    }
    public Account2(String name,String password){
        this.name= name;
        this.password=password;
    }

    public Account2() {
    }

    public class idException extends Exception{
        private double id;
        public idException(int id) {
            this.id = id;
        }
    }
    @Override
    public void withDraw(double money){
        if (getBalance()<money){
            System.out.println("抱歉,您账户余额不足");
        }else {
            if (money % 100==0 && money<=5000){
                setBalance(getBalance()-money);
                transactions.add(new Transaction('W',money,getBalance(),"支出"+money+"美元"));
            }else{
                System.out.println("抱歉,支出金额过大或不为100的整数倍,无法支出");
            }
        }
    }
    @Override
    public void deposit(double money){
        setBalance(getBalance()+money);
        transactions.add(new Transaction('D',money,getBalance(),"存入"+money+"美元"));
    }

    public void changePassword(String password){
            if (password.length()>=6 && password.length()<=10){
                Scanner scanner = new Scanner(System.in);
                System.out.println("请再次输入新密码");
                String secondpassword = scanner.next();
                if (secondpassword.equals(password)){
                    this.password=password;
                    System.out.println("修改成功");
                }else{
                    System.out.println("第二次密码错误");
                }
            }else {
                System.out.println("密码不符合要求,长度应在6-10之间");
            }
        }


    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
