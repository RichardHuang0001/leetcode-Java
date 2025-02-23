package 双指针.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = len-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    while(left < right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right]==nums[right-1]){
                        right--;
                    }
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list;
    }
}
