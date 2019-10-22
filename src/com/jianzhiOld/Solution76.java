package com.jianzhiOld;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Solution76 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归到了叶子节点
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左边和右边同时存在
        if (left != null && right != null) {
            return root;
        } else {//否则的话就是 p q 在同一边的，返回的就是最低公共祖先
            if (left != null) {
                return left;
            }else if(right!=null) {
                return right;
            }else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(12);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(4);

        //lowestCommonAncestor(head,head.right.left,head.right.right);
        //lowestCommonAncestor(head,head.right.left,head.left);
        lowestCommonAncestor(head,head.right,head.right.left);
    }
}
