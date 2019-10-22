package com.jianzhiOld;

//字符流中第一个只出现一次的字符
//开始时，哈希表的值都初始化为-1，
//当读取到某个字符时，将位置存入value中，如果之前读取过该字符（即value>=0），将value赋值为-2，代表重复出现过
public class Solution51 {

    private int[] arr;
    private int index;

    public Solution51(){
        arr = new int[256];
        index = 0;
        for(int i = 0; i<arr.length; i++){
            arr[i] = -1;
        }
    }

    //Insert one char from stringstream
    public void insert(char ch){
        //字符的ASCII码作为哈希表的键值key，字符对应的位置作为哈希表的值value
        if(arr[(int)ch] == -1){
            arr[(int)ch] = index;
        }else if(arr[(int)ch] >= 0){
            arr[(int)ch] = -2;
        }  // 如果这个arr[(int)ch] = -2的话，反正都出现过了，就不用管了
        index++;
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        int minIndex = Integer.MAX_VALUE;
        char c = '#';
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= 0  && arr[i] < minIndex){
                minIndex = arr[i];
                c = (char)i;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        solution51.insert('Z');
        System.out.println(solution51.firstAppearingOnce());
        solution51.insert('Z');
        System.out.println(solution51.firstAppearingOnce());
        solution51.insert('Z');
        System.out.println(solution51.firstAppearingOnce());
//        solution51.insert('g');
//        System.out.println(solution51.firstAppearingOnce());
//        solution51.insert('l');
//        System.out.println(solution51.firstAppearingOnce());
//        solution51.insert('e');
//        System.out.println(solution51.firstAppearingOnce());
        char a = 'z';
        System.out.println((int)a);

    }
}
