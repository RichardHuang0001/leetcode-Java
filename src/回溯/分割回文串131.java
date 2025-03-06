package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        //先计算好是否回文的dp矩阵存下来
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
        }
        for (int i = s.length()-3; i >= 0; i--) {
            for (int j = i+2; j < s.length(); j++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }

        backtrack(ans,cur,s,0,dp);
        return  ans;
    }
    public void backtrack(List<List<String>> ans,List<String> cur,String s,int start,boolean[][] dp) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                cur.add(s.substring(start, i + 1));
                backtrack(ans, cur, s, i + 1,dp);
                cur.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
