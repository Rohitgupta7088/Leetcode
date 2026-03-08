class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(buy >= prices[j]){
                    buy = prices[j];
                }
                else{
                    profit += (prices[j]-buy);
                    buy = prices[j];
                }
                i++;
            }
        }
        return profit;
    }
}