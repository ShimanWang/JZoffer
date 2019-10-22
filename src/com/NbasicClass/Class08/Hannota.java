package com.NbasicClass.Class08;

//汉诺塔
public class Hannota {
    public static void hanno(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println(" move 1 from " + from + " to " + to);
            return;
        }

        hanno(n-1,from,help,to);
        System.out.println(" move "+n+ " from " + from + " to " + to);
        hanno(n-1,help,to,from);
    }

    public static void main(String[] args) {
        hanno(3,"左","右","中");
    }
}
