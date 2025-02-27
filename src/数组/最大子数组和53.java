package 数组;

import java.util.Arrays;
import java.util.OptionalInt;

public class 最大子数组和53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        //计算前缀和
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(preSum));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<preSum.length;i++){
            for(int j=i+1;j<preSum.length;j++){
                if(preSum[j]-preSum[i]>max){
                    max = preSum[j]-preSum[i];
                }
            }
        }
        return max;
    }
    //max[i]表示i结尾的子数组和，max[i]=max[i-1]+nums[i]if max[i-1]>0 else nums[i]
    public static int maxSubArray2(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(max[i-1]>0){
                max[i] = max[i-1] + nums[i];
            }else{
                max[i] = nums[i];
            }
        }
        int max1 = Arrays.stream(max).max().getAsInt();
        return max1;
    }
}
