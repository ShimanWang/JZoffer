package com.jianzhiOffer;

import java.util.LinkedHashMap;
import java.util.Set;

//1、字符串中第一个只出现一次的字符     &&     //2、字符流中第一个只出现一次的字符
public class Solution34 {
    public static int FirstNotRepeatingChar(String str) {
        char[] array = str.toCharArray();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int time = map.get(array[i]);
                time++;
                map.put(array[i],time);
            }else {
                map.put(array[i],1);
            }
        }

//        Set<Character> set = map.keySet();
//        for(char a : set){
//            if(map.get(a) == 1) return a;
//        }

        //牛客要求返回第一次出现的这个字符串的下标，需要再遍历一次array数组，其实这样只用HashMap也可以
        for(int i = 0; i<array.length; i++){
            if(map.get(array[i]) == 1){
                return i;
            }
        }
        return -1;
    }





    public static void main(String[] args) {
        int res = FirstNotRepeatingChar("google");
        System.out.println(res);
    }
}
