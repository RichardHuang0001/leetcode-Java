package Hot100第一轮复习;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        无重复字符的最长子串 solution = new 无重复字符的最长子串();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int maxLen = 0;
        for(int l = 0,r = 0;r<len;r++){
            char c = s.charAt(r);
            while(set.contains(c) && l<=r){
                set.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(r-l+1,maxLen);
            set.add(c);
        }
        return maxLen;
    }
}
