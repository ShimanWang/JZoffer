package com.wsmOffers.day02;

public class SmallerEqualBigger {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public static Node listPartition(Node head, int num) {

            Node cur = head;
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            Node[] nodeArr = new Node[len];

            for (int j = 0; j < len; j++) {
                nodeArr[j] = cur;
                cur = cur.next;
            }
            partition(nodeArr, num);

            int k = 1;
            for (k = 1; k < len; k++) {
                nodeArr[k - 1].next = nodeArr[k];
            }
            nodeArr[k-1].next = null;

            return nodeArr[0];
        }


        public static void partition(Node[] nodeArr, int num) {
            int less = -1;
            int more = nodeArr.length;
            int left = 0;
            while (left < more) {
                if (nodeArr[left].value == num) {
                    left++;
                } else if (nodeArr[left].value < num) {
                    swap(nodeArr, ++less, left++);
                } else {
                    swap(nodeArr, left, --more);
                }
            }

        }

        public static void swap(Node[] arr, int i, int j) {
            Node temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void printLinkedList(Node node) {
            System.out.print("Linked List: ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Node head1 = new Node(7);
            head1.next = new Node(9);
            head1.next.next = new Node(1);
            head1.next.next.next = new Node(8);
            head1.next.next.next.next = new Node(5);
            head1.next.next.next.next.next = new Node(2);
            head1.next.next.next.next.next.next = new Node(5);
            printLinkedList(head1);
            Node res = listPartition(head1,5);
            printLinkedList(res);
        }

    }
}
