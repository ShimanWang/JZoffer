package com.jianzhiOld;

//O（1）时间删除链表结点
public class Solution17 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
  }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
