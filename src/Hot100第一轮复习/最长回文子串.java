package Hot100第一轮复习;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];//上三角才有意义
        //初始化,对角线上为0
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //长度为2的可以简单判断
        for (int i = 0; i < len-1; i++) {
            dp[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        }
        //按列填充dp数组
        for (int j = 2; j < len; j++) {
            for (int i = 0; i <=j-2 ; i++) {
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
            }
        }
        //从dp中找到最长的为true的答案
        int[] max = new int[3];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(dp[i][j] && j-i+1 > max[0]){
                    max[0] =j-i+1;
                    max[1] = i;
                    max[2] = j;
                }
            }
        }
        return s.substring(max[1],max[2]+1);

    }
}
