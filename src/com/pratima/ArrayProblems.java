package com.pratima;
import java.lang.reflect.Array;
import java.util.*;

public class ArrayProblems {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 5, 9, 10, 18, 18};
        int[] arr = {1,1,2,2,3,3,4,4};
        int[] arr1 = {0,1,2,0,1,2,1,2,0,0,0,1};
        int[] prices = {7,1,5,3,6,4};
        int n = arr.length;

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

//        rotateMatrixBy90Degree(matrix);
        rotateMatrixBy90Optimal(matrix);




//        System.out.println("The largest element in the array is" + " " + printLargest(arr, n));
//        System.out.println("The second largest element in the array is" + " " + print2Largest(arr, n));
//
//        int k = removeDuplicatesOptimal(arr);
//        System.out.println("The size of the unique array is" + " " + k);
//        System.out.println("The array after removing duplicate elements is ");
//        for (int i = 0; i < k; i++) {
//            System.out.print(arr[i] + " ");
//        }

//         System.out.print(Arrays.toString(leftRotateByOnePlace(arr, n)));
        //sortArrays(arr1);
//        sortArraysOptimal(arr1);
        System.out.print(maximumProfit(prices));
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

    //Left rotate the array by one place
    //Time Complexity = O(N)
    //Auxillary Space = O(1)
    //Input Space = O(N)
    static int[] leftRotateByOnePlace(int[] arr, int n) {
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[n - 1] = temp;
        return arr;
    }

    //Sort an array of 0's, 1's and 2's
    //One approach can be using sort function. If not allowed we can go from better to optimal approach

    //Better Approach Using count variable and iteration
    //Time Complexity = O(N) + O(N) = O(2N)
    //Space Complexity = O(1)

    static void sortArrays(int[] arr1) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 0) {
                count0++;
            } else if(arr1[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for(int i = 0; i < count0; i++) {
            arr1[i] = 0;
        }
        for(int i = count0; i < count0 + count1; i++) {
            arr1[i] = 1;
        }

        for(int i = count0 + count1; i < arr1.length; i++) {
            arr1[i] = 2;
        }

        System.out.print(Arrays.toString(arr1));
    }


    //Using Dutch National Flag Algorithm Approach
    //Time Complexity = O(N), because only one condition will run for each iteration till N pass
    //Space Complexity = O(1)
    static void sortArraysOptimal(int[] arr1) {
        int low = 0;
        int mid = 0;
        int high = arr1.length -1;

        while(mid <= high) {
            if(arr1[mid] == 0) {
                swap(arr1, low, mid);
                low++;
                mid++;
            } else if(arr1[mid] == 1) {
                mid++;
            } else {
                swap(arr1, mid, high);
                high--;
            }
        }
     System.out.print(Arrays.toString(arr1));

    }

    static void swap(int[] arr1, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp;
    }

    //Best Time To Buy And Sell a Stock
    //Time Complexity = O(N)
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    static int maximumProfit(int[] arr) {
        int minimum = arr[0];
        int maxProfit = 0;

        for(int i = 1; i < arr.length; i++) {
            int cost = arr[i] - minimum;
            maxProfit = Math.max(maxProfit, cost);
            minimum = Math.min(minimum, arr[i]);
        }
        return maxProfit;
    }

    //Brute Force Approach
    //Time Complexity = O(N^2)
    //Space Complexity = O(N^2);
    static void rotateMatrixBy90Degree(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < rotatedMatrix.length; i++) {
            System.out.println(Arrays.toString(rotatedMatrix[i]));
        }
    }

    static  void rotateMatrixBy90Optimal(int[][] matrix) {
        int n = matrix.length;

        //Transposing Matrix
        for(int i = 0; i < n - 2; i++) {
            for(int j = i+1; j < n; j++) {
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }

        //Reverse each row of matrix
        for (int i = 0; i < matrix.length; i++) {
            reverseArray(matrix[i]);
        }

        //Print the final rotated image
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
