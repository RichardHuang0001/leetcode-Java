package 二叉树;

public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode node,int lower,int upper){
        if(node==null){
            return true;
        }
        if(node.val<lower || node.val>upper){
            return  false;
        }
        return isValid(node.left,lower,node.val) && isValid(node.right, node.val, upper);
    }
}
