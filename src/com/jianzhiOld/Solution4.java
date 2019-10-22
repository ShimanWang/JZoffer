package com.jianzhiOld;

//后继结点
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode father;
      TreeNode(int x) {
          val = x;
      }
}

public class Solution4 {
    public TreeNode inorderSuccessor(TreeNode p) {
        if (p.right != null){
            return rightLeft(p.right);
        }else {
            TreeNode f = p.father;
            while (f != null && f.left != p){
                p = f;
                f = p.father;
            }
            return f;
        }
    }

    public static TreeNode rightLeft(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);

    }
}
