package 动态规划;

public class 完全平方数279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int[] dp = new  int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            int sqrtI = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j= 1;j<=sqrtI;j++){
                if(dp[i-j*j]+1<min){
                    min = dp[i-j*j]+1;
                }
            }
            dp[i] = min;
        }
        return dp[n];

    }
}
