package com.wsmOffers.day03;

public class XuLieHua {
    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    //前序序列化
    public static String xuLieHua(Node head){
        if (head == null){
            return "#_";
        }
        String res = head.value + "_";
        res = res + xuLieHua(head.left);
        res = res + xuLieHua(head.right);
        return res;
    }
}
