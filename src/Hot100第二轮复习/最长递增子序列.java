package Hot100第二轮复习;

import java.util.Arrays;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i <len ; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){//i可以排在j后面
                    max = Math.max(dp[j]+1,max);
                }
            }
            //遍历完i之前的所有j之后，更新dp i
            dp[i] = max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
