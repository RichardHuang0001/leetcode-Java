package 动态规划;

import java.util.Arrays;

public class 分割等和子集 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len <=1){
            return false;
        }
        //获得数组和
        int sum = 0;
        int target;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum %2 ==1){
            return false;
        }else{
            target =sum/2;
        }

        //dpi,j表示从[0,i]的数内，凑出刚好等于j的子集是否可行（true,false)
        boolean[][] dp = new boolean[len+1][target+1];
        //初始化第一列
        for(int j =0;j<=target;j++){
            if(nums[0]==j){
                dp[0][j]=true;
            }else{
                dp[0][j]=false;
            }
        }
        System.out.println(Arrays.toString(dp[0]));

        //从i=1开始填充
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <=target; j++) {
                if(nums[i]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    //不选nums[i]和选nums[i]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
//            System.out.println("i="+i+",dp["+i+"]="+ Arrays.toString(dp[i]));
        }
        return dp[len-1][target];


    }
}
