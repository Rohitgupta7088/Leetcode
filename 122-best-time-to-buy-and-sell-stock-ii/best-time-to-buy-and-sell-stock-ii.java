class Solution {
    public int maxProfit(int[] prices){
        int profit = 0;
        int n = prices.length;
        int buy = prices[0];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(buy<prices[j]){
                    profit += (prices[j]-buy);
                }
                buy = prices[j];
                i++;
            }
        }
        return profit;
    }
}