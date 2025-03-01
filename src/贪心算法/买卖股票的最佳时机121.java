package 贪心算法;

import static java.lang.Math.min;

public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            int profit = prices[i] - min;
            if(profit > max){
                max = profit;
            }

        }
        return max;
    }
    //双指针
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int lowest = prices[0],today=1;
        int max = prices[1]-prices[0];

        for(;today<len;today++){
            lowest = min(lowest,prices[today]);
            if(prices[today] - lowest > max){
                max = prices[today] - lowest;
            }
        }
        return max;
    }
}
