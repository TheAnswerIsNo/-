package com;


import java.io.Serializable;
import java.util.Date;

public class Account1 implements Serializable {
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    private Date dateCreated;

    public Account1() {
    }

    public Account1(int id, double balance,double annualInterestRate) throws balanceException {
        if (balance>=0){
            this.id = id;
            this.balance = balance;
            this.annualInterestRate=annualInterestRate;
        }else throw new balanceException(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterestRate(){
        double monthlyInterestRate = annualInterestRate/1200;
        return monthlyInterestRate;
    }
    //取钱
    public void withDraw(double money){
        if (balance<money){
            System.out.println("抱歉,您账户余额不足");
        }else balance-=money;
    }
    //存钱
    public void deposit(double money){
        balance+=money;
    }
    public class balanceException extends Exception{
        private double balance;
        public balanceException(double balance) {
            this.balance = balance;
            System.out.println("金额不能为负");
        }
    }
}
