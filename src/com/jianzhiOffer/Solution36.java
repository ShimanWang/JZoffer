package com.jianzhiOffer;

//输入两个链表，找出它们的第一个公共结点
//实际上这道题需要判断有环、无环，是三道题的合体，但是牛客上只考虑了无环单链表这一种情况
public class Solution36 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return null;
    }

    //先判断链表有没有环
    public static ListNode isLoop (ListNode head){
        if(head==null || head.next==null || head.next.next==null){
            return null;
        }
        ListNode cur1 = head.next;
        ListNode cur2 = head.next.next;

        while (cur1 != cur2){
            if(cur2.next == null || cur2.next.next == null){
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        cur2 = head;

        while (cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两无环链表的第一个公共结点
    public static ListNode noLoop(ListNode head1,ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len = 0;
        while (cur1 != null){
            len++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            len--;
            cur2 = cur2.next;
        }
        //如果都走到最后一个结点了，这两个链表的最后一个结点不是同一个结点，则一定没有公共结点
        if(cur1 != cur2){
            return null;
        }
        if(len>0){
            cur1 = head1;
            cur2 = head2;
        }else {
            cur1 = head2;
            cur2 = head1;
        }
        len = Math.abs(len);

        while (len!=0){
            cur1 = cur1.next;
            len--;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

//    //两个有环链表的第一个公共结点
//    public static ListNode bothLoop(ListNode head1,ListNode loop1,ListNode head2,ListNode loop2){
//        if(loop1 == loop2){
//            ListNode cur1 = head1;
//            ListNode cur2 = head2;
//            int n = 0;
//            while(cur1 != null){
//                n++;
//                cur1 = cur1.next;
//            }
//            while(cur2 != null){
//                n--;
//                cur2 = cur2.next;
//            }
//            if(cur1 != cur2){
//                return null;
//            }
//            if(n>0){
//                cur1 = head1;
//                cur2 = head2;
//            }else {
//                cur1 = head2;
//                cur2 = head1;
//            }
//            n = Math.abs(n);
//
//            while (n!=0){
//                cur1 = cur1.next;
//                n--;
//            }
//
//            while (cur1 != cur2){
//                cur1 = cur1.next;
//                cur2 = cur2.next;
//            }
//            return cur1;
//        }else{
//            ListNode cur1 =loop1.next;
//            while (cur1 != loop1){
//                cur1 = cur1.next;
//            }
//        }
//    }
}
