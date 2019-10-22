package com.wsmOffers.Exercise;

import java.util.HashMap;

public class SolutionMap {
    public static void main(String[] args) {


    }

    public char firstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int time = map.get(arr[i]) + 1;
                map.put(arr[i], time);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return '#';

    }
}
