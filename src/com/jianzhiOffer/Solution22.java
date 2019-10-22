package com.jianzhiOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上到下打印二叉树
public class Solution22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            list.add(root.val);
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
        }
        return list;
    }
}
