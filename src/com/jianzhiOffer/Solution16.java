package com.jianzhiOffer;

//合并两个排序的链表
public class Solution16 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }

        while (list1 == null && list2 != null){
            cur.next = list2;
            cur = list2;
            list2 = list2.next;
        }

        while (list2 == null && list1 != null){
            cur.next = list1;
            cur = list1;
            list1 = list1.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(9);

        ListNode res = Merge(list1,list2);
        System.out.println(res.val);
    }

}
