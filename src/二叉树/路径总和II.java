package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNode.buildTree(nums);
        pathSum(root,22);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        hasPathSum(root,targetSum,current,ans);
        return ans;
    }
    public static void hasPathSum(TreeNode root, int targetSum,List<Integer> current,List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        //如果到达叶子节点
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                current.add(root.val);
                ans.add(new ArrayList<>(current));
                current.removeLast();//返回上级之前删掉
                return;
            } else {
                //把target num 加回val
                return;
            }
        } else {
            targetSum -= root.val;
            current.add(root.val);
            hasPathSum(root.left, targetSum, current,ans);
            hasPathSum(root.right, targetSum, current,ans);
            current.removeLast();
            return;
        }
    }
}
