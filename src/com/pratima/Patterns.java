package com.pratima;

public class Patterns {
    public static void main(String[] args) {
        int n = 5;
        print2(n);
    }
    public static void print1(int n) {
        for(int i = 0; i<=n; i++) {
            for (int j = 0; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print2(int n) {
        for(int i = 1; i<=n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
