package Hot100第一轮复习;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        Set<Integer> set  = new HashSet<>();
        for(int n :nums){
            set.add(n);
        }
        int max = 0;
        for(int n :set){
            if(set.contains(n-1)){
                continue;
            }else{
                int curr = 0;
                while(set.contains(n)){
                    curr++;
                    n++;
                }
                max = Math.max(max,curr);

            }
        }
        return max;

    }
}
