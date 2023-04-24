package com.pratima;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,6,8,9,6};
        int target = 12;
        int[] ans = twoSum(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] arr, int target) {
        //Brute Force Solution
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i + 1; j < arr.length; j++) {
//                if(arr[i] + arr[j] == target) {
//                    return new int[] {i, j};
//                }
//            }
//        }
//
//        return new int[] {-1, -1};


        //Using HashMap

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            //Find the compliment
            int compliment = target - arr[i];

            //Check if the compliment exists in the map Key
            if(map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            } else {
                map.put(arr[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}
