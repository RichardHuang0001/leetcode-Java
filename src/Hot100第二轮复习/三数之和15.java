package Hot100第二轮复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先对数组进行排序，O(nlogn)
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        //锚定一个数i，然后剩下两个数用双指针找
        int len = nums.length;
        for (int i = 0; i <=len-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //定义两边向中间靠拢的双指针
            int left = i+1,right = len-1;
            while(left<right){
                //如果找到一个答案,添加到ans，
                if(nums[i]+nums[left]+nums[right]==0){
                    ans.add(List.of(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right&&nums[right-1]==nums[right]){
                        right--;
                    }
                    left++;
                    right-- ;
                } else if (nums[i]+nums[left]+nums[right]<=0&&left<right) {//如果太小，左边增加
                    left++;
                }else{
                    right-- ;
                }
            }
        }
        return ans;
    }
}
