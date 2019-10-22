package com.examination.KuaiShou;

import java.util.*;

//统计字符串中字符出现的次数，次数降序排列
public class Main2 {
    public static class MapValueComparator implements Comparator<Map.Entry<Character, Integer>> {


        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }

//    public static class MyComparator implements Comparator<String>{
//
//        @Override
//        public int compare(String o1, String o2) {
//            return (o1+o2).compareTo(o2+o1);
//        }
//    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        solution(str);
    }

    public static void solution(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int time = map.get(arr[i]) + 1;
                map.put(arr[i], time);
            } else {
                map.put(arr[i], 1);
            }
        }

        map = sortByValue(map);


        StringBuffer sb = new StringBuffer();
        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            sb.append(key + ":" + map.get(key) + ",");
            //System.out.print(key+":"+map.get(key)+",");
        }
        String res = sb.substring(0, sb.length() - 1);
        System.out.println(res);

    }

    public static Map<Character, Integer> sortByValue(Map<Character, Integer> oldMap) {
//        Map<Character, Integer> map = new TreeMap<>();
//        map.put('a',5);
//        map.put('b',1);
//        map.put('c',3);
//        Map<Character, Integer> resultMap ;
        if (oldMap == null || oldMap.isEmpty()) {
            return null;
        }
        Map<Character, Integer> sortMap = new LinkedHashMap<>();
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(
                oldMap.entrySet()
        );
        Collections.sort(entryList, new MapValueComparator());
        Iterator<Map.Entry<Character, Integer>> iter = entryList.iterator();
        Map.Entry<Character, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortMap;

    }
}


