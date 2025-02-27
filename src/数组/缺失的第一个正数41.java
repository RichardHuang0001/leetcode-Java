package 数组;

public class 缺失的第一个正数41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一步：将数值 x 放到索引 x-1 的位置上
        for (int i = 0; i < n; i++) {
            // 我们只关心 1 到 n 之间的正整数
            // nums[i] != nums[nums[i]-1] 避免无限循环（处理重复数字）
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                // 交换 nums[i] 和 nums[nums[i]-1]
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        // 第二步：找到第一个不在正确位置上的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都正确，则返回 n+1
        return n + 1;
    }
}
