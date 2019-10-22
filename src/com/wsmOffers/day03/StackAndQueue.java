package com.wsmOffers.day03;


import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue {
    //两个队列实现栈
    public static class TwoQueueStack{
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack(){
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        //入栈
        public void push(int input){

            data.add(input);
        }

        //出栈
        public Integer pop(){
            if (data.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            while (data.size()>1){
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
//            return data.poll();
        }

        public void swap(){
            Queue temp = data;
            data = help;
            help = temp;
        }
    }

    //两个栈实现队列

    public static void main(String[] args) {
        TwoQueueStack twoQueueStack = new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        twoQueueStack.push(3);
        twoQueueStack.push(4);
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());

    }
}
