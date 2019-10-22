package com.jianzhiOffer;

//从尾到头打印链表
import java.util.ArrayList;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
}

public class Solution3 {
    public static ArrayList<Integer> list = new ArrayList<Integer> ();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;

    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<>();
        }
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ArrayList<Integer> list = printListFromTailToHead(head);
        for(int a : list){
            System.out.println(a);
        }

    }
}
