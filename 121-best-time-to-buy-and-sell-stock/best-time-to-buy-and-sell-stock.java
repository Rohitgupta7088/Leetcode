// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxprofit = 0;

//         for(int i=0; i<n; i++){
//             int max = Integer.MIN_VALUE;
//             for(int j=i; j<n; j++){
//                 max = Math.max(max, prices[j]);
//             }
            
//             maxprofit = Math.max(maxprofit, (max-prices[i]));
//         }

//         return maxprofit;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            int profit = 0;
            if(min > prices[i]){
                min = prices[i];
            }

            profit = prices[i]-min;
            maxprofit = Math.max(maxprofit, profit);
        }

        return maxprofit;
    }
}