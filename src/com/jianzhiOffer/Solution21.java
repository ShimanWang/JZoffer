package com.jianzhiOffer;
import java.util.Stack;

//栈的压入、弹出序列
public class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0 || pushA.length == 0){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0; i<pushA.length; i++){
            stack.push(pushA[i]);
            while (stack.size() != 0 && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }

        }
        return stack.isEmpty();
    }
}
