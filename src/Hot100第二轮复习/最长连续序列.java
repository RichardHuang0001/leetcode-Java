package Hot100第二轮复习;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=0){
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 1;
        int curLen = 1;
        for(int n : set){
            if(set.contains(n-1)){
                continue;
            }
            //不包含n-1,从这个数n开始找n+1,n+2，看看能找多长
            curLen=1;
            while(set.contains(n+1)){
                curLen+=1;
                n++;
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;
    }
}
