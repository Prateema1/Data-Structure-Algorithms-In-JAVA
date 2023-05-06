package com.pratima;

public class Patterns {
    public static void main(String[] args) {
        int n = 5;
        //Substitute the function name you want to execute
        print6(n);
    }

    /*

    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *

    */
    public static void print1(int n) {
        for(int i = 0; i<=n; i++) {
            for (int j = 0; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /*

    *
    * *
    * * *
    * * * *
    * * * * *

    */
    public static void print2(int n) {
        for(int i = 1; i<=n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

     /*
     1
     1 2
     1 2 3
     1 2 3 4
     1 2 3 4 5
     */
    public static void print3(int n) {
        for (int i = 1; i <= n; i++) {
          for(int j = 1; j <= i; j++) {
              System.out.print(j);
          }
          System.out.println();
        }
    }
       /*
         1
         2 2
         3 3 3
         4 4 4 4
         5 5 5 5 5

        */
    public static void print4(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /*
       *****
       ****
       ***
       **
       *

     */
    public static void print5(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2
    1
     */

    public static void print6(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


}

