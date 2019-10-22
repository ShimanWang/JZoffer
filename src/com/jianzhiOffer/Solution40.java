package com.jianzhiOffer;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
public class Solution40 {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length < 2) {
            return;
        }
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        //所有的数字异或一遍，结果是x^y
        int xorResult = 0;
        for (int i = 0; i < length; i++) {
            xorResult = xorResult ^ array[i];
        }
        //找到x^y中某一个为1的位置(要得到这个位置的下标)
        int index = 0;
        //判断出第index位是0还是1
        while ((xorResult & 1) != 1) {
            xorResult = xorResult >> 1;
            index++;  //循环结束以后，index中存的就是x^y中某一个为1的位置
        }

        int first = 0;
        int second = 0;
        for(int a : array){
            if(((a>>index) & 1 )== 1){
                first = first^a;
            }else {
                second = second^a;
            }
        }
        num1[0] = first;
        num2[0] = second;
    }




    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr,num1,num2);
        System.out.println(6>>1);

    }
}
