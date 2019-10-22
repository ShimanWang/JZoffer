package com.jianzhiOffer;

//矩形覆盖
public class Solution10 {
    public static int RectCover(int target) {
        //不考虑0会报错
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return RectCover(target-1) + RectCover(target-2);
        }
    }

    //暴力递推法
//    public static int RectCover2(int target) {
//
//    }

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
