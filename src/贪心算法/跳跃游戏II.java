package 贪心算法;

public class 跳跃游戏II {

    //方法一：动态规划（比较慢）
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            int min = i;
            for (int j = 0; j < i; j++) {//从第0格遍历到i-1
                if(nums[j]+j >=i){//如果从第j格可以跳到第i格
                    min = Math.min(dp[j]+1,min);//记录从第j格起跳的次数，看看是不是最小
                }
            }
            dp[i] = min;
        }
        return dp[len-1];
    }
    //方法二：贪心算法（每次跳出去最远，看看什么时候能跳到超过len-1）
    public int jump2(int[] nums) {
        int len = nums.length;
        int curEnd = 0,curFurthest=nums[0];
        int jump = 0;
        for (int i = 0; i <len ; i++) {
            if(i>curEnd){
                jump++;
                curEnd = curFurthest;
                if(curEnd>=len-1){
                    return jump;
                }
            }
            curFurthest = Math.max(curFurthest,nums[i]+i);
        }
        return jump;
    }
}
