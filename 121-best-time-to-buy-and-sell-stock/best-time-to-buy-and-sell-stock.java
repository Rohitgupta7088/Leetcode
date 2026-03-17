class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int max = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            int profit = 0;
            if(max > prices[i]){
                max = prices[i];
            }
            profit = prices[i]-max;
            maxprofit = Math.max(profit, maxprofit);
        }

        return maxprofit;
    }
}