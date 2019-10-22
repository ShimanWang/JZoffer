package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//字符串的排列
/*例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
*本文代码采用ArrayList<String>接收返回的字符串，并要求不出现重复字符串
*/
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0){
            return list;
        }
        if(str.length() == 1){
            list.add(str);
            return list;
        }
        char[] arr = str.toCharArray();
        //初始条件：0位置和后面的位置交换、list为空
        process(arr,list,0);
        Collections.sort(list);//按照字典序排序
        return list;
    }

    public void process(char[] arr, ArrayList<String> list, int i){
        //递归停止的条件：只有一个元素时
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if(i == arr.length-1){
            String s = String.valueOf(arr);
            if(!list.contains(s)){
                list.add(s);
                return;
            }
        }else{
            for(int j = i; j<arr.length; j++){
                swap(arr,i,j);
                process(arr,list,i+1);//递归从i+1开始，意味着位置（上一个位置）固定不动
                swap(arr,i,j);//i,j两个位置再次交换，恢复原样
            }
        }
    }

    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //这个格式真的是日了狗了.....
    public List<List<Integer>> permutationInt(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        List<Integer> listHelp = new ArrayList<>();
        if(nums.length == 1){
            listHelp.add(nums[0]);
            list.add(listHelp);
            return list;
        }
        processInt(nums,list,0);
        return list;
    }

    public void processInt(int[] arr, List<List<Integer>> list, int i ){
        List<Integer> listHelp = new ArrayList<>();
        //递归停止的条件
        if(i == arr.length-1){
            for(int k = 0; k<arr.length; k++){
                listHelp.add(arr[k]);
            }
            if(!list.contains(listHelp)){
                list.add(listHelp);
            }
        }else {
            for(int j = i; j<arr.length; j++){
                swapInt(arr,i,j);
                processInt(arr,list,i+1);
                swapInt(arr,i,j);
            }
        }
    }

    public void swapInt(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        Solution27 solution27 = new Solution27();
//        ArrayList<String> list = solution27.Permutation(str);
        int[] nums = {1,2};
        List<List<Integer>> list = solution27.permutationInt(nums);
        for(List<Integer> lista : list){
            for(int a : lista){
                System.out.print(a);
            }
            System.out.println();
        }
    }

}
