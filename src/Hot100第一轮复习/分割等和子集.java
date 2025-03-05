package Hot100第一轮复习;

import java.util.Arrays;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum ==0 || sum %2==1){
            return false;
        }
        int target = sum/2;

        boolean [][] dp = new boolean[len][target+1];//最终要dp[len-1][target]
        for (int i = 0; i < target+1; i++) {
            dp[0][i] = nums[0] == i;
        }
        for (int i = 0 ; i<len ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < target+1; j++) {
                if(nums[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
