package 动态规划;

import java.util.*;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];//dp表示s的前i个字符是否能分割，最后返回dp[len]
        dp[0] = true;
        for (int i = 1; i < len+1; i++) {
            for (int j = 0; j < i; j++) {
                if(set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
