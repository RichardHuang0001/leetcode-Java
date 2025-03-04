package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中第K小的元素230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedNums = new ArrayList<>();
        preOrder(root,sortedNums);
        System.out.println(sortedNums.toString());
        return sortedNums.get(k-1);
    }
    public void preOrder(TreeNode node,List<Integer> ans){
        if(node == null){
            return;
        }
        //确保左子树已经加到list了
        preOrder(node.left,ans);
        //轮到中间（父节点加入list）
        ans.add(node.val);
        preOrder(node.right,ans);
    }
}
