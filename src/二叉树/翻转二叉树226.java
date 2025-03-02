package 二叉树;

public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode filppedLeft = invertTree(root.left);
        TreeNode filppedRight = invertTree(root.right);
        root.left = filppedRight;
        root.right = filppedLeft;
        return root;
    }

}
