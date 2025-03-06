package Hot100第一轮复习;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int layerLen = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < layerLen; i++) {
                TreeNode node = q.poll();
                cur.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(new ArrayList<>(cur));
        }
        return ans;
    }
}
