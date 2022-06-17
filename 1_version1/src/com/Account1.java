package com;

import java.util.Date;
import java.util.Scanner;

public class Account1 {
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    private Date dateCreated;

    public Account1() {
    }

    public Account1(int id, double balance) throws balanceException {
        if (balance>0){
            this.id = id;
            this.balance = balance;
        }else throw new balanceException(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return Math.round(balance*100)/100;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return Math.round(annualInterestRate*100)/100;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterestRate(){
        double monthlyInterestRate = annualInterestRate/1200;
        return Math.round(monthlyInterestRate*100)/100;

    }
    public void withDraw(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入提取金额");
        double money = scanner.nextDouble();
        if (balance<money){
            System.out.println("抱歉,您账户余额不足");
        }else balance-=money;
    }
    public void deposit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存入金额");
        double money = scanner.nextDouble();
        balance+=money;
    }
    public class balanceException extends Exception{
        private double balance;
        public balanceException(double balance) {
            this.balance = balance;
        }
    }
}
