package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root,result);
        return result;
    }
    public void inorderTraversalHelper(TreeNode node,List<Integer>result){
        if(node == null){
            return;
        }
        inorderTraversalHelper(node.left,result);
        result.add(node.val);
        inorderTraversalHelper(node.right,result);
    }
}
