package com.jianzhiOld;

//单链表有环无环，入环结点
public class Solution23 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        while (n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
