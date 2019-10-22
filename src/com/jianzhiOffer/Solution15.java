package com.jianzhiOffer;

import com.sun.org.apache.bcel.internal.generic.NEW;

//单链表反转
public class Solution15 {
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head){

        //特殊情况
        if (head == null){
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(reverseList(head).val);
    }
}
