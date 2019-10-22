package com.jianzhiOffer;

//树的子结构
public class Solution17 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
//        if (pRoot1 == null || pRoot2 == null) {
//            return false;
//        }
        //或者写成这样：二选一就行
        if(pRoot2 == null){
            return false;
        }
        if(pRoot1 == null && pRoot2 != null){//递归停止的条件
            return false;
        }

        boolean flag = false;
        //如果找到了对应Tree2的根节点的点
        if (pRoot1.val == pRoot2.val) {
            //以这个根节点为起点,判断是否包含Tree2
            flag = isPart(pRoot1, pRoot2);
        }
        if (flag == false){
            flag = hasSubtree(pRoot1.left, pRoot2);
        }
        if (flag == false){
            flag = hasSubtree(pRoot1.right, pRoot2);
        }

        return flag;
    }

    public static boolean isPart(TreeNode p1, TreeNode p2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (p2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完(p2 == null return true放在前面)，Tree1却遍历完了。返回false
        if (p1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (p1.val != p2.val) {
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return isPart(p1.left, p2.left) && isPart(p1.right, p2.right);
    }

}
