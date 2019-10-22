package com.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution38 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;//已遍历的结点个数
        int depth = 0;//当前结点所在层数
        int nextCount = 1;//下一层的结点个数
        while(!queue.isEmpty()){
            root = queue.poll();
            count++;
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
            if(count == nextCount){
                depth++;
                count = 0;
                nextCount = queue.size();
            }
        }
        return depth;
    }

    //递归解法
    //递归的思路就是:左子树的最大深度与右子树的最大深度 的最大值 +1(根节点的1个深度)
    public int treeDepth2(TreeNode root) {
        //base case
        if(root == null){
            return 0;
        }
        int leftDepth = treeDepth2(root.left);
        int rightDepth = treeDepth2(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

}
