package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root,result);
        return result;

    }
    public void preorderTraversalHelper(TreeNode node,List<Integer>result){
        if(node == null){return;}
        result.add(node.val);
        preorderTraversalHelper(node.left,result);
        preorderTraversalHelper(node.right,result);
    }
}
