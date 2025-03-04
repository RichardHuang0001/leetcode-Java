package 二维动态规划;

public class 最小路径和 {
    public static void main(String[] args) {
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n= grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public void print(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
