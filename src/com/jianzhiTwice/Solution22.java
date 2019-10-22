package com.jianzhiTwice;

public class Solution22 {
    class ListNode{
        int value;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        //异常情况
        if(head==null || k<1){return null;}
        ListNode n1 = head;
        ListNode n2 = head;
        //1.先让n1走k-1步
        while(k>1){
            n1 = n1.next;
            k--;
            //k>链表长度
            if(n1 == null){
                return null;
            }
        }
        while(n1.next!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;

    }
}
