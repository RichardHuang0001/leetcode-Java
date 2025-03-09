package Hot100第二轮复习;

import 二叉树.TreeNode;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        //使用递归解法
        //空节点或者叶子节点直接返回
        if(root == null || (root.left==null && root.right==null)){
            return root;
        }
        TreeNode invertedLeft = invertTree(root.left);
        TreeNode invertedRight = invertTree(root.right);
        root.left = invertedRight;
        root.right = invertedLeft;
        return root;
    }
}
