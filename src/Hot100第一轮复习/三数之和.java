package Hot100第一轮复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        三数之和 solution = new 三数之和();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int left = 0; left <= len-3; left++) {
            if(left>0 && nums[left]==nums[left-1]) continue;
            for (int mid=left+1,right=left+2; right < len; right++) {
                if(nums[left]+nums[mid]+nums[right]==0){
                    res.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    while(right<len-1 && nums[right]==nums[right+1]) right++;
                    while(mid<len-1 && nums[mid]==nums[mid+1]&& mid <right) mid++;
                    mid++;
                    right++;
                } else if (nums[left]+nums[mid]+nums[right]<0) {//太小了，right++
                    right++;
                }else{
                    mid++;
                }
            }
        }
        return res;
    }
}
