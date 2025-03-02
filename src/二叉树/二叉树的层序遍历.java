package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return new ArrayList<List<Integer>>();
        }else{
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            //遍历完一层
            res.add(layer);
        }
        return res;
    }
}
