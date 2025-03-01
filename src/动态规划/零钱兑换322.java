package 动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 零钱兑换322 {
    public static void main(String[] args) {
        int[] coins={1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];//dp的意义是需要dp[i]个硬币凑成i元
        Set<Integer> set = new HashSet<>();
        //刚好对应一颗硬币的，就最少，直接写入1
        for(int coin : coins){
            if(coin <= amount) {
                dp[coin] = 1;
            }
            set.add(coin);
        }

        for(int i=1;i<=amount;i++){
            if(!set.contains(i)){//跳过刚好是硬币数值的amount
                //遍历可能由减去哪一颗硬币的子问题构成的
                int min = Integer.MAX_VALUE-1;
                for(int coin : coins){
                    if(coin < i){
                        if(dp[i-coin]+1 < min){
                            min = dp[i-coin]+1;
                        }
                    }
                    dp[i] = min;
                }
            }
            System.out.println("i="+i+",dp="+ Arrays.toString(dp));
        }
        return dp[amount]>amount? -1:dp[amount];
    }
}
