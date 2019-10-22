package com.jianzhiOffer;

//跳台阶
public class Solution8 {
    public static int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else {
            return JumpFloor(target-1) + JumpFloor(target-2);
        }
    }

    //暴力递推做法：时间更短
    public int JumpFloor2(int target) {

        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        int prePre = 1;
        int pre = 2;
        int res = 0;
        while(target > 2){
            res = pre + prePre;
            prePre = pre;
            pre = res;
            target--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}
