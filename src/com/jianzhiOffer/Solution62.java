package com.jianzhiOffer;

import java.util.Stack;

//二叉搜索树的第k个结点
//默认条件：树和k都存在，并且1≤k≤树的总结点数
public class Solution62 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode kthNode(TreeNode root, int k) {
        if(k<0 || root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.add(root);
                root = root.left;
            }else {
                root = stack.pop();
                k--;
                if(k==0){break;}
                root = root.right;
            }
        }
        return root;
    }

    int index = 0;
    //递归解法
    public TreeNode kthNode2(TreeNode root, int k) {
        if(root!=null){
            TreeNode node = kthNode2(root.left,k);
            if(node != null)  return node;
            //System.out.println(root.val);
            index++;
            if(index==k){
                return root;
            }
            node = kthNode2(root.right,k);
            if(node != null)  return node;
        }
        return null;
    }
}
