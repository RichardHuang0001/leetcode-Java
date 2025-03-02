package 二叉树;

public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        root.left = invertTree(root.left);
        return isSame(root.left,root.right);

    }
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
    public boolean isSame(TreeNode node1,TreeNode node2){
        if(node1==null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val==node2.val){
            return isSame(node1.left,node2.left) && isSame(node1.right,node2.right);
        }else{
            return false;
        }
    }
}
