package com.pratima;
import java.util.*;

public class ArrayProblems {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 5, 9, 10, 18, 18};
        int[] arr = {1,1,2,2,3,3,4,4};
        int n = arr.length;
        System.out.println("The largest element in the array is" + " " + printLargest(arr, n));
        System.out.println("The second largest element in the array is" + " " + print2Largest(arr, n));

        int k = removeDuplicatesOptimal(arr);
        System.out.println("The size of the unique array is" + " " + k);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
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

    // Remove duplicates in place from sorted array
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Brute Force Approach | Time Complexity = O(N * log N) + O(N) | Space Complexity = O(N)
    static int removeDuplicates(int[] arr) {
        HashSet <Integer> set = new HashSet <> ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            arr[j] = x;
            j++;
        }
        return k;
    }

    // Two pointers approach | Time Complexity = O(N) | Space Complexity = O(1)
    static int removeDuplicatesOptimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }
}
