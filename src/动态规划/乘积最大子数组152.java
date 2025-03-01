package 动态规划;

public class 乘积最大子数组152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len ==0){
            return 0;
        }else if(len == 1){
            return nums[0];
        }
        int[] minF = new int[len];
        int[] maxF = new int[len];
        //都初始化为自己
        for (int i = 0; i <len ; i++) {
            minF[i] = nums[i];
            maxF[i] = nums[i];
        }
        //从第二个数开始更新
        for (int i = 1; i <len; i++) {
            int prod1 = nums[i]*maxF[i-1];
            int prod2 = nums[i]*minF[i-1];
            maxF[i] = Math.max(Math.max(prod1,nums[i]),prod2);
            minF[i] = Math.min(Math.min(prod1,nums[i]),prod2);
        }
        int ans=maxF[0];
        for (int i = 0; i <len ; i++) {
            if(maxF[i]>ans){
                ans = maxF[i];
            }
        }
        return ans;
    }
}
