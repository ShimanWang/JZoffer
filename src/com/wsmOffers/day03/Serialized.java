package com.wsmOffers.day03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//序列化---从上到下打印二叉树
public class Serialized {

    public static class Node{
        private Node left;
        private Node right;
        private int value;

        public Node(int value){
            this.value = value;
        }

        public static ArrayList<Integer> printBT(Node head){
            Queue<Node> queue = new LinkedList<Node>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            queue.offer(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                System.out.print(head.value+" ");
                list.add(head.value);
                if (head.left != null){
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }
            return list;
        }

        //按层序列化二叉树
        public static String seriaByLevel(Node head){
            if (head == null){
                return "#_";
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(head);
            String res = head.value + "_";
            while (!queue.isEmpty()){
                head = queue.poll();
                if (head.left != null){
                    res = res  + head.left.value + "_";
                    queue.offer(head.left);
                }else {
                    res = res + "#_";
                }
                if (head.right!= null){
                    res = res + + head.right.value + "_";
                    queue.offer(head.right);
                }else {
                    res = res + "#_";
                }
            }
            return  res;
        }

        public static Node reco(String str){
            String[] arr = str.split("_");
            int index = 0;
            Node head = creatNodeByString(arr[index++]);
            Node node = null;
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(head);
            while (!queue.isEmpty()){
                node = queue.poll();
                node.left = creatNodeByString(arr[index++]);
                node.right = creatNodeByString(arr[index++]);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return head;
        }

        public static Node creatNodeByString(String str){
            if (str.equals("#")){
                return null;
            }else {
                return new Node(Integer.valueOf(str));
            }
        }

        //按前序遍历方式序列化
        public static String seriaByFront(Node head){
            if (head == null){
                return "#_";
            }
            String res = head.value + "_";
            res = res + seriaByFront(head.left);
            res = res + seriaByFront(head.right);
            return res;
        }

        //前序遍历的反序列化
        public static Node recoProcess(Queue<String> queue){
            String res = queue.poll();
            if (res.equals("#")){
                return null;
            }
            Node head = new Node(Integer.valueOf(res));
            head.left = recoProcess(queue);
            head.right = recoProcess(queue);
            return head;
        }

        public static Node reco2(String str){
            String[] arr = str.split("_");
            Queue<String> queue = new LinkedList<String>();
            for(int i = 0; i<arr.length; i++){
                queue.offer(arr[i]);
            }

            return recoProcess(queue);
        }

        public static void main(String[] args) {
            Node head1 = new Node(1);
            head1.left = new Node(2);
            head1.right = new Node(3);
            head1.left.left = new Node(4);
            head1.left.right = new Node(5);
            head1.right.right = new Node(6);
//            ArrayList<Integer> list = printBT(head1);
//            for(int i = 0; i<list.size(); i++){
//                System.out.println(list.get(i));
//            }
//            System.out.println(seriaByLevel(head1));
//
//            Node head2 = reco(seriaByLevel(head1));
//            printBT(head2);
            String res = seriaByFront(head1);
            System.out.println(res);
            Node head2 = reco2(res);
            System.out.println(seriaByFront(head2));
        }
    }
}
