package com.ListNode;

public class AddAndDelete {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    /**
     * 链表添加结点:
     * 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
     */
    public static void add(ListNode head , int d){
        ListNode newNode = new ListNode(d);
        if(head == null){
            head = newNode;
            return;
        }
        while(head.next!=null){
            head = head.next;
        }
        head.next = newNode;
    }

    public static void delete(){}
}
