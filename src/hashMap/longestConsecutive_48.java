package hashMap;

import java.util.*;

public class longestConsecutive_48 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int maxLen = 1;

        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if(set.contains(num-1)){
                continue;
            }
            int start = num;
            int curLen = 1;
            while (set.contains(start + 1)) {
                curLen++;
                start++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

}
