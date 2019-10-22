package com.jianzhiOffer;

import java.util.Stack;

//包含min函数的栈
public class Solution20 {
    private Stack<Integer> dataStack;
    private Stack<Integer> helpStack;

    public Solution20(){
        dataStack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int node){
        if (dataStack.size() == 0 && helpStack.size() == 0){
            dataStack.push(node);
            helpStack.push(node);
        }
        if(node > helpStack.peek()){
            dataStack.push(node);
            helpStack.push(helpStack.peek());
        }else {
            dataStack.push(node);
            helpStack.push(node);
        }
    }

    public void pop(){
        if(dataStack.size()==0){
            throw new RuntimeException("stack is empty");
        }
        dataStack.pop();
        helpStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int min() {
        return helpStack.peek();
    }
}
