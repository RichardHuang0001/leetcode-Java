package 二叉树;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 从层序遍历数组构建二叉树
     * 例如：[3,9,20,null,null,15,7] 表示：
     * 3
     * / \
     * 9  20
     * / \
     * 15  7
     *
     * @param levelOrder 层序遍历数组，可以包含null（表示为缺少的节点）
     * @return 构建好的二叉树的根节点
     */
    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(levelOrder[0]);

        // 使用队列进行层序构建
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 从数组的第二个元素开始构建（索引1开始）
        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            // 取出当前要处理的节点
            TreeNode current = queue.poll();

            // 处理左子节点
            if (i < levelOrder.length) {
                Integer leftVal = levelOrder[i++];
                if (leftVal != null) {
                    current.left = new TreeNode(leftVal);
                    queue.offer(current.left);
                }
            }

            // 处理右子节点
            if (i < levelOrder.length) {
                Integer rightVal = levelOrder[i++];
                if (rightVal != null) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    /**
     * 使用前序和中序遍历构建二叉树
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 构建好的二叉树的根节点
     */
    public static TreeNode buildTreeFromPreorderAndInorder(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        // 使用HashMap存储中序遍历中值到索引的映射，提高查找效率
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                            int[] inorder, int inStart, int inEnd,
                                            Map<Integer, Integer> inorderMap) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的第一个元素是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int rootIndex = inorderMap.get(rootVal);

        // 计算左子树的大小
        int leftSize = rootIndex - inStart;

        // 递归构建左右子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd, inorderMap);

        return root;
    }

    /**
     * 打印树的层序遍历（方便验证树的构建是否正确）
     */
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    result.add("null");
                } else {
                    result.add(String.valueOf(node.val));

                    // 即使子节点为null也加入队列，以便正确表示树的结构
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        // 移除末尾的null值
        while (result.size() > 0 && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    /**
     * 示例用法
     */
    public static void main(String[] args) {
        // 示例1：从层序遍历构建树
        Integer[] levelOrder = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = buildTree(levelOrder);
        System.out.println("从层序遍历构建的树：");
        printLevelOrder(root1);

        // 示例2：从前序和中序遍历构建树
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root2 = buildTreeFromPreorderAndInorder(preorder, inorder);
        System.out.println("从前序和中序遍历构建的树：");
        printLevelOrder(root2);
    }
}