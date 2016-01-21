public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int[] res = new int[prices.length];
        int minBefore = prices[0];
        //calculate maxProfit if we do one transaction and sell at day i
        for(int i = 0; i < res.length; i++) {
            res[i] = Math.max(0, prices[i]-minBefore);
            minBefore = Math.min(minBefore, prices[i]);
        }
        //calculate maxProfit if we do two transactions
        int maxProfitAfter = 0, maxAfter = prices[prices.length-1], maxProfit = 0;
        for(int i = res.length-1; i >= 0; i--) {
            maxProfitAfter = Math.max(maxProfitAfter, maxAfter-prices[i]);
            maxAfter = Math.max(maxAfter, prices[i]);
            maxProfit = Math.max(maxProfit, res[i] + maxProfitAfter);
        }
        return maxProfit;
    }
}