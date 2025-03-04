package 二叉树;

public class 路径总和I {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(hasPathSum(root,22));
    }
    public static  boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        //如果到达叶子节点
        if(root.left == null && root.right==null){
            if(targetSum-root.val  == 0){
                return true;
            }else{
                //把target num 加回val
                return false;
            }
        }else{
            targetSum -= root.val;
            return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
        }
    }

}
