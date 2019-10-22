package com.jianzhiOffer;

//链表中倒数第K个结点
public class Solution14 {
    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        //异常情况1：链表为空
        if(head == null){
            return null;
        }
        if (k<1){
            throw  new RuntimeException("k must > 0");
        }

        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && k > 1){
            n2 = n2.next;
            k--;
        }
        //比如链表长度只有6，要求倒数第7个结点
        if(k != 1){
            throw  new RuntimeException("k 比链表长度还大");
        }

        while (n2.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = FindKthToTail(head,1);
        System.out.println(res.val);
    }
}
