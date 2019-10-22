package com.jianzhiOffer;

//二叉树的镜像
public class Solution18 {
    static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right==null){
            return;
        }
        if (root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        Mirror(head);
        System.out.println(head.left.val);
    }
}
