package 子数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
* 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。



示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2
* */
public class 和 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1]=preSum[i]+nums[i];
        }
        System.out.println(Arrays.toString(preSum));
        int sum=0;
        //s[j]-s[i]=k   s[i]=s[j]-k
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();//key表示target值，value表示前面见过多少次这个值
        for(int j=0;j<preSum.length;j++){
            int target = preSum[j]-k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(preSum[j],map.getOrDefault(preSum[j],0)+1);
        }

        return count;
    }
}
