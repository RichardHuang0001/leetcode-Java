package 数组;

import java.util.Arrays;

public class 最长递增子序列300_Tx一面挂 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }else if(len == 1){
            return 1;
        }

        int[] dp = new int[len];
        for (int i = 0; i <len ; i++) {
            dp[i]=1;
        }
        for(int i= 1;i<len;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){//说明i有资格做j的后面
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            System.out.println(Arrays.toString(dp));
        }
        int ans = 1;
        for (int i = 0; i < len; i++) {
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        return ans;
    }
}
