package com.LeetCodeString;

import java.util.*;

//字母异位词分组
/*
*输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
* 这是LeetCode中的返回值，是List<List<String>>
* */
public class Solution49 {

    public static ArrayList<String> anagrams(String[] strs) {
        if(strs.length == 0){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        //搞一个map,key是字典顺序的字符串,value是一个list,里面放原字符串（未计算字典顺序前的字符串）
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            String key = sort(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key,temp);
            }
        }

        //将map中的value放入一个list中返回
        Set<String> set = map.keySet();
        for(String str : set){
            ArrayList<String> res = map.get(str);
            if(res.size()!=0){
                list.addAll(res);//addAll()方法是按照位置逐条向原有的list中添加对象元素
            }
        }
        return list;

    }

    public static String sort(String str) {
        char[] arr = str.toCharArray();
        //将这个字符数组按照字典顺序排序
        Arrays.sort(arr);
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i];
        }
        return res;
    }


    //LeetCode 中要求返回值为List<List<String>>
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return null;
        }

        List<List<String>> list = new ArrayList<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
//        for(String str : strs){
//            String key = sort(str);
//            if(map.containsKey(key)){
//                map.get(key).add(str);
//            }else {
//                ArrayList<String> temp = new ArrayList<>();
//                temp.add(str);
//                map.put(key,temp);
//            }
//        }

        //将map中的value放入一个List<List<String>> 中，返回
        Set<String> set = map.keySet();
        for(String str : set){
            list.add(map.get(str));
        }

        return list;
    }




    public static void main(String[] args) {
//        String[] arr1 = {""};
        String[] arr1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<String> list = anagrams(arr1);
        for(String s : list){
            System.out.println(s);
        }

    }
}
