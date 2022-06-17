package com;

import java.util.Scanner;

public class ATMMachine1 {
    public static void main(String[] args) throws Account1.balanceException {
        Account1[] list = new Account1[100];
        for (int i = 0; i < 100; i++) {
            list[i]=new Account1(i,1000);
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入所要查询的账户id");
            int id = scanner.nextInt();
            System.out.println("Main menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.println("请输入功能前序号");
            String choose = scanner.next();

            switch (choose){
                case "1":
                    System.out.println(checkbalance(list,id));
                    break;
                case "2":
                    list[id].withDraw();
                    break;
                case "3":
                    list[id].deposit();
                    break;
                case "4":
                    System.out.println("欢迎下次光临");
                    return;
            }
        }

    }

    public static double checkbalance(Account1[] list, int id){
        return list[id].getBalance();
    }
}
