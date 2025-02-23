package 双指针.滑动窗口;

import java.util.*;

/*
* 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。*/
public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int lenP = p.length();
        int lenS = s.length();
        int [] setP = new int[26];
        int [] setS = new int[26];
        for (char ch :p.toCharArray()){
            setP[(int)ch-(int)'a']+=1;
        }
        int l=0,r=-1;
        while(r-l+1<lenP){
            r++;
            char chR = s.charAt(r);
            setS[chR-'a']+=1;
        }
        while(r<lenS){
            if(Arrays.equals(setP,setS)){
                ans.add(l);
            }
            r++;
            if(r<lenS) {
                char chR = s.charAt(r);
                setS[chR - 'a'] += 1;
            }
            char chL = s.charAt(l);
            setS[chL-'a']-=1;
            l++;
        }
        return ans;
    }
}
