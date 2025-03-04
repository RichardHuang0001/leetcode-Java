package 动态规划;

import java.util.Arrays;

public class 复习分割等和子集 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target;
        if(sum%2==1){
            return false;
        }else{
            target = sum/2;
        }
        System.out.println(target);

        boolean[][] dp = new boolean[len][target+1];
        //初始化第0行
        for(int j = 0;j<=target;j++){
            dp[0][j] = (nums[0]==j);
        }
        System.out.println(Arrays.toString(dp[0]));
        for(int i=1;i<len;i++){
            for (int j=0;j<=target;j++){
                if(nums[i]>j){
                    dp[i][j]=dp[i-1][j];//这里很关键，当前数太大的话，只是说明这个数不能选了，并非说明一定是false
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            System.out.println("i="+i+","+Arrays.toString(dp[i]));
        }
        return dp[len-1][target];
    }
}
