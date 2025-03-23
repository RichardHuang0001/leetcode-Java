package Hot100第二轮复习;

import java.util.Arrays;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        //使用一维动态规划，dp[i]的意义是以i结尾的子数组的最大和，返回结果是max(dp)
        int len = nums.length;
        int[] dp = new int[len];
        //初始化第一个只能包含它自身
        dp[0] = nums[0];
        for (int i = 1; i <len ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
