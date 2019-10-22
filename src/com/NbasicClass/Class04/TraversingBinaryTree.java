package com.NbasicClass.Class04;

import java.util.Stack;

//遍历二叉树
public class TraversingBinaryTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    static int index = 0 ;
    //1.递归前序遍历--根左右
    public static void frontTraversing1(Node head){
        if(head==null){
            return;
        }

        index++;
        System.out.print(head.value+" ");
        System.out.print("【"+index+"】 ");
        frontTraversing1(head.left);
        frontTraversing1(head.right);
    }
    //2.非递归前序遍历--根左右
    public static void frontTraversing2(Node head){
        if(head==null){
            return;
        }
        int k = 0;
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()){
            Node cur  = stack.pop();
            System.out.print(cur.value+" 【"+(k++)+"】");
            if(cur.right!=null){
                stack.add(cur.right);
            }
            if(cur.left!=null){
                stack.add(cur.left);
            }
        }

    }

    //3.递归中序遍历--左根右
    public static void midTraversing1(Node head){
        if(head==null){
            return;
        }
        midTraversing1(head.left);
        System.out.print(head.value+" ");
        midTraversing1(head.right);
    }

    //4.非递归中序遍历--左根右
    public static void midTraversing2(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.add(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.value+" ");
                head = head.right;
            }
        }
    }

    //5.递归后序遍历--左右根
    public static void backTraversing1(Node head){
        if(head==null){
            return;
        }
        backTraversing1(head.left);
        backTraversing1(head.right);
        System.out.print(head.value+" ");
    }

    //6.非递归后序遍历--左右根
    public static void backTraversing2(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackHelp = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            //System.out.print(head.value+" ");
            stackHelp.add(head);
            if(head.left!=null){
                stack.add(head.left);
            }
            if(head.right!=null){
                stack.add(head.right);
            }
        }
        while(!stackHelp.isEmpty()){
            System.out.print(stackHelp.pop().value+" ");
        }
    }



    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        frontTraversing1(head);
        System.out.println();
        frontTraversing2(head);
        System.out.println();
        midTraversing1(head);
        System.out.println();
        midTraversing2(head);
        System.out.println();
        backTraversing1(head);
        System.out.println();
        backTraversing2(head);
    }
}
