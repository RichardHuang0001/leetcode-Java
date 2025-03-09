package 二叉树;

public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(),n = word2.length();
        int[][] dp = new int[m+1][n+1];//答案是dp[m][n]

        //初始化一下，第0行和第0列，编辑距离就是另一个字符的长度
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        //按行更新按列更新都可以，这里按行
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];//如果相等，就不用编辑了
                }else{
                    //如果不相等，考虑三种情况，从三种情况变成dp ij，都是编辑次数加一，取最小的一个
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
