package Hot100第一轮复习;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subarraySum(nums,3));
    }
    public static int subarraySum(int[] nums, int k) {
        //前缀和+哈希表来解决
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int[] preSum = new int[len+1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(preSum));

        for (int i = 0; i < preSum.length; i++) {
            int target = preSum[i] - k;
            if(map.containsKey(target)){
               count += map.get(target);
            }
            if(map.containsKey(preSum[i])){
                map.put(preSum[i],map.get(preSum[i])+1);
            }else{
                map.put(preSum[i],1);
            }
        }
        return count;
    }
}
