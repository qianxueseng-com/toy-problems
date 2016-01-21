public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int lowestBefore = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - lowestBefore);
            lowestBefore = Math.min(lowestBefore, prices[i]);
        }
        return res;
    }
}