package 二叉树;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //分别计算左右子树的高度，取最大值并加一作为当前树的高度返回
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
