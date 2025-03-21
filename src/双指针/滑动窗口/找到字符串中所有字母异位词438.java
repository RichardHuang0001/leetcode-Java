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

        // 统计字符串 p 中每个字符出现的次数
        for (char ch :p.toCharArray()){
            setP[(int)ch-(int)'a']+=1;
        }

        // 初始化滑动窗口的左右指针
        int l=0,r=-1;

        // 使用滑动窗口遍历字符串 s
        while(r<lenS){
            // 如果窗口大小小于 p 的长度，右指针右移
            if(r-l+1<lenP){
                r++;
                if(r<lenS) {
                    // 统计窗口内字符出现的次数
                    char chR = s.charAt(r);
                    setS[chR - 'a'] += 1;
                }
            }
            // 如果窗口大小等于 p 的长度，检查窗口内字符是否与 p 的字符出现次数相同
            else {
                if(Arrays.equals(setP,setS)){
                    // 如果相同，将左指针加入结果列表
                    ans.add(l);
                }
                // 移动左指针，并更新窗口内字符出现的次数
                char chL = s.charAt(l);
                setS[chL-'a']-=1;
                l++;
            }
        }
        return ans;
    }
}
