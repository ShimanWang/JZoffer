package com.jianzhiOffer;

//变态跳台阶
public class Solution9 {
    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
}
