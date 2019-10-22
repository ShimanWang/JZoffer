package com.examination.KuaiShou;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        solution(str);

    }

    public static void solution(String s){
        char[] cs = s.toCharArray();
        char back = cs[0];
        Stack<Character> stack = new Stack<>();
        for(int i =2;i<cs.length;i++){
            if(cs[i] == back){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(cs[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
