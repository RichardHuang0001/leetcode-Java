package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return Helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode Helper(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight){// 递归终止条件：当前子树范围为空
        if (preLeft > preRight || inLeft > inRight) {
            return null;  // 返回空节点
        }
        int rootVal = preorder[preLeft];
        TreeNode rootNode = new TreeNode(rootVal);
        // 在中序遍历中找到根节点的位置
        int rootInorderIndex = map.get(rootVal);
        // 计算左子树的大小
        int leftSubtreeSize = rootInorderIndex - inLeft;
        // 递归构建左子树
        rootNode.left = Helper(preorder, inorder, preLeft + 1, preLeft + leftSubtreeSize, inLeft, rootInorderIndex - 1);
        // 递归构建右子树
        rootNode.right = Helper(preorder,inorder,preLeft+leftSubtreeSize+1,preRight,rootInorderIndex+1,inRight);
        return rootNode;
    }
}
