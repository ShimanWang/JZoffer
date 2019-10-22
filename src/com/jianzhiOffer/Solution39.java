package com.jianzhiOffer;

import org.omg.CORBA.MARSHAL;

//平衡二叉树:输入一棵二叉树，判断该二叉树是否是平衡二叉树
public class Solution39 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int depth(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    //方法2
    public class ReturnData {
        int height;
        boolean isBalance;

        public ReturnData(int height,boolean isBalance){
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public ReturnData process(TreeNode root){
        //base case
        if(root==null){
            return new ReturnData(0,true);
        }

        ReturnData left = process(root.left);
        if(!left.isBalance){
            return new ReturnData(0,false);
        }

        ReturnData right = process(root.right);
        if(!right.isBalance){
            return new ReturnData(0,false);
        }

        if(Math.abs(left.height-right.height)>1){
            return new ReturnData(0,false);
        }

        return new ReturnData(Math.max(left.height,right.height)+1,true);

    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        return process(root).isBalance;
    }


}

