package com.jianzhiOffer;

import java.util.HashMap;

//复制含有random指针的链表
public class Solution25 {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //利用HashMap
    public static RandomListNode clone1(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode res = head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while (head!= null){
            map.put(head,new RandomListNode(head.label));
            head = head.next;
        }
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(res);
    }

    //利用链表的结构，省去HashMap的空间
    public static RandomListNode clone2(RandomListNode head){
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        RandomListNode next = null;
        while (cur != null){
            next = cur.next;;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null){
            next = cur.next.next;
            if (cur.random == null){
                cur.next.random = null;
            }else {
                cur.next.random = cur.random.next;
            }
            cur = next;
        }

        RandomListNode res = head.next;

        //split
        cur = head;
        while (cur != null){
            next = cur.next.next;
            if(next == null){
                cur.next.next = null;
            }else {
                cur.next.next = next.next;
            }
            cur.next = next;
            cur = next;

        }

        return res;
    }
}
