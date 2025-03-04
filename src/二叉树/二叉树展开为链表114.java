package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表114 {
    public void flatten(TreeNode root) {
        //要求按照根左右的顺序展开为链表
        List<TreeNode> ans = new ArrayList<>();
        Helper(root,ans);
        System.out.println(ans.toString());
        int len = ans.size();
        for (int i = 1; i < len; i++) {
            TreeNode prev= ans.get(i-1),curr = ans.get(i);
            prev.left=null;
            prev.right = curr;
        }

    }
    public void Helper(TreeNode root, List<TreeNode> ans){
        if(root == null){
            return;
        }
        ans.add(root);
        Helper(root.left,ans);
        Helper(root.right,ans);
    }

}
