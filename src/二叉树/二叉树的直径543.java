package 二叉树;

public class 二叉树的直径543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        int curDepth = Math.max(leftDepth,rightDepth)+1;
        int curLen = leftDepth+rightDepth;
        if(curLen>max){
            max = curLen;
        }
        return curDepth;
    }
}
