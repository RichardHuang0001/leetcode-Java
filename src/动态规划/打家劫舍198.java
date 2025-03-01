package 动态规划;

public class 打家劫舍198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len <=1){
            return nums[len];
        }
        int[] dp = new  int[len+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<len;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
    //打家劫舍II ，房子首尾相连，思路：分两步计算，如果打最后一个房子，那么第一个房子就不能打，相当于从第二个到最后一个的序列
    //如果不打最后一个，那么第一个房子就可以打，相当于从第一个到倒数第二个的序列
    public int rob2(int[] nums) {
        int len = nums.length;
        if(len <=1){
            return nums[len];
        }
        int[] dp1 = new  int[len+1];//打最后一个房子
        int[] dp2 = new  int[len+1];
        dp1[2] = nums[2];//从第二个房子开始打
        dp1[3] = Math.max(nums[2],nums[3]);
        for(int i = 4;i<len;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }

        //不打最后一个房子
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i = 3;i<len;i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }

        return Math.max(dp1[len-1],dp2[len-2]);
    }
}
