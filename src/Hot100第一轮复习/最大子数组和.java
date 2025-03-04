package Hot100第一轮复习;

import java.util.Arrays;
import java.util.OptionalInt;

public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1]>0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            System.out.println("i="+i+"dp="+Arrays.toString(dp));
        }
        int max = Arrays.stream(dp).max().getAsInt();
        return max;
    }
}
