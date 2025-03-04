package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 路径总和III_hot100 {
    public int pathSum(TreeNode root, int targetSum) {
        // 创建哈希表存储前缀和及其出现次数
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();

        // 初始化前缀和为0的路径出现1次（表示空路径）
        prefixSumMap.put(0L, 1);

        // 开始DFS遍历，初始前缀和为0
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        // 基础情况：如果节点为空，返回0
        if (node == null) {
            return 0;
        }

        // 更新当前路径的前缀和
        currentSum += node.val;

        // 查找有多少条以当前节点结尾的路径的和等于targetSum
        // 即找出有多少个前缀和为(currentSum - targetSum)的路径
        int count = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // 将当前前缀和加入哈希表或更新其频率
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // 递归遍历左右子树，并累加有效路径数
        count += dfs(node.left, currentSum, targetSum, prefixSumMap);
        count += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // 回溯：移除当前前缀和（减少其频率）
        // 这是因为我们要回到父节点，当前路径不再考虑
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return count;
    }
}
