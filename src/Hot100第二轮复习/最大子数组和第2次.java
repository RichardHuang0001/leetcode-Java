package Hot100第二轮复习;

import java.util.Arrays;

public class 最大子数组和第2次 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];//最后返回dp数组的最大值
        dp[0] = nums[0];
        for (int i = 1; i < len ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int  max = Arrays.stream(dp).max().getAsInt();
        return max;
    }
}
