package Hot100第一轮复习;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for( int num :set){
            if(!set.contains(num-1)){
                int curLen = 1;
                while(set.contains(num+1)){
                    curLen++;
                    num++;
                }
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;

    }
}
