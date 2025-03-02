package 二叉树;

public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
    public TreeNode buildBST(int[] nums,int left,int right){
        if(left > right){return null;}
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums,left,mid-1);
        node.right = buildBST(nums,mid+1,right);
        return node;
    }

}
