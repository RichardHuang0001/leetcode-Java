package Hot100第一轮复习;

import java.util.Arrays;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];//dpi表示以nums中[0,i]部分的最长递增子序列长度

        dp[0]=1;

        for (int i = 1; i <len ; i++) {
            int maxLen = 1;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){//numsi可以作为numsj的后继
                    if(dp[j]+1> maxLen){
                        maxLen = dp[j]+1;
                    }
                }
            }
            dp[i] = maxLen;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
