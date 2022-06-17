package com;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String next = scanner.next();
        File file = new File(next);
        char[] list = read(file);
        int[] sum = getsum(list);
        for (int i = 65; i <= 90; i++) {
            System.out.println("Number of "+(char)(i)+"s: "+sum[i]);
        }
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

    public static int[] getsum(char[] list){
        int[] sum = new int[255];
        for (int i = 0; i < list.length; i++) {
            if (list[i]>='A' || list[i]<='Z'){
                sum[(int)list[i]]++;
            }else if(list[i]>='a' || list[i]<='z'){
                sum[((int)list[i])-32]++;
            }
        }
        return sum;
    }
}
