package 双指针.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串03 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    //我的写法：滑动窗口，双指针，哈希表   abcdef c xegghrh   abcda
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int len = s.length();
        int maxLen = 0;
        for(int l = 0, r=0;r < len;r++){
            char chR = s.charAt(r);
            if(! set.contains(chR)){//没见过的
                set.add(chR);
                maxLen = Math.max(r-l+1,maxLen);
                continue;
            }
            while(set.contains(chR)){
                char chL = s.charAt(l);
                set.remove(chL);
                l++;
            }
            //左边界向右缩减完成之后，当前窗口是无重复的（干净的）
            //把重复的那个加回到set中
            set.add(chR);
        }
        return maxLen;
    }
}
