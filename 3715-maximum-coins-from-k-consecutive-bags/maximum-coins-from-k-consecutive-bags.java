class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a,b)->Integer.compare(a[0],b[0]));
        long ans = 0;
        int n = coins.length;

        long sum = 0;
        int j = 0;

        for(int i=0; i<n; i++){
            long L = coins[i][0];
            long R = coins[i][0]+k-1;

            if(j<i){
                j = i;
            }

            while(j<n && coins[j][1]<=R){
                long count = (long) coins[j][1]-coins[j][0]+1;
                sum += count * coins[j][2];
                j++;
            }

            long partial = 0;

            if(j<n && coins[j][0]<=R){
                long count = R-coins[j][0]+1;
                partial = count * coins[j][2];
            }

            ans = Math.max(ans, sum + partial);

            if(coins[i][1] <= R){
                long count = (long) coins[i][1]-coins[i][0]+1;
                sum -= count*coins[i][2];
            }

        }

        sum = 0;
        j = n-1;

        for(int i=n-1; i>=0; i--){
            long R = coins[i][1];
            long L = R-k+1;

            if(j>i){
                j = i;
            }

            while(j>=0 && coins[j][0] >= L){
                long count = (long)coins[j][1]-coins[j][0]+1;
                sum += count*coins[j][2];
                j--;
            }

            long partial = 0;

            if(j>=0 && coins[j][1]>= L){
                long count = coins[j][1]-L+1;
                partial = count*coins[j][2];
            }

            ans = Math.max(ans, sum + partial);

            if(coins[i][0]>=L){
                long count = (long)coins[i][1]-coins[i][0]+1;
                sum -= count*coins[i][2];
            }
        }

        return ans;
    }
}