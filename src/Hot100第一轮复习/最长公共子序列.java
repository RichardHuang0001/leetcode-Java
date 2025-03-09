package Hot100第一轮复习;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        //二维dp,dp ij表示t1的前i个和t2的前j个的最长公共子序列，答案是dp m,n
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m+1][n+1];
        //初始化
        dp[1][1] = (text1.charAt(0)==text2.charAt(0))? 1:0;

        //按行更新
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
