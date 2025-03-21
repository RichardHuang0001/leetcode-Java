package Hot100第三轮复习;

import Hot100第一轮复习.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int maxCount = 0;
        for(int x : set){
            if(set.contains(x-1)){
                continue;
            }
            int count = 0;
            while(set.contains(x)){
                count++;
                x++;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
