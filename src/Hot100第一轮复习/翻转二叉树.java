package Hot100第一轮复习;

import 二叉树.TreeNode;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        //空节点或叶子节点返回自身
        if(root == null || (root.left==null&&root.right==null)){
            return root;
        }
        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);
        root.left = newRight;
        root.right = newLeft;
        return root;
    }
}
