package 二维动态规划;

import java.util.Arrays;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
    System.out.println(new 最长回文子串().longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //初始化dp矩阵,下三角矩阵无效（当i>j时矩阵内容无效）
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < len ; i++) {
            dp[i-1][i] = s.charAt(i-1)==s.charAt(i);
        }
        for (int j = 2; j < len; j++) {
            for (int i = j-2; i >=0; i--) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }
        int[] maxLen = new int[3];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(dp[i][j] && j-i+1>maxLen[0]){
                    maxLen[0] = j-i+1;
                    maxLen[1] = i;
                    maxLen[2] = j;
                }
            }
        }
        return s.substring(maxLen[1],maxLen[2]+1);
    }
    public static void print(boolean[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
