package com.pratima;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9, 10, 18, 18};
        int n = arr.length;
        System.out.println("The largest element in the array is" + " " + printLargest(arr, n));
        System.out.println("The second largest element in the array is" + " " + print2Largest(arr, n));
    }

    static int printLargest(int[] arr, int n) {
        int largest = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    static int print2Largest(int[] arr, int n) {
        int largest = arr[0];
        int secondLargest = -1;
        for(int i = 1; i < n; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return  secondLargest;
    }
}
