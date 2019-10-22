package com.jianzhiOffer;

//删除排序链表中的重复结点（只要重复，就都删掉，不是说保留一个）
public class Solution56 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode head) {
        //搞一个虚拟头结点，防止删掉了head
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null){
            ListNode q = p.next;
            while (q!= null && p.next.val == q.val){
                q = q.next;
            }
            //如果下一段的长度是1，
            if(p.next.next == q){
                p = p.next;
            }else {
                p.next = q;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        ListNode resHead = deleteDuplication(head);
        System.out.println(resHead);
    }
}
