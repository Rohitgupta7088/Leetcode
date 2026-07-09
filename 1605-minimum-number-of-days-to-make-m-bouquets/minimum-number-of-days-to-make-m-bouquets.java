class Solution {
    public int minDays(int[] bloomday, int m, int k){
        int n = bloomday.length;
        if((long)m*k > n){
            return -1;
        }

        int minday = Integer.MAX_VALUE;
        int maxday = 0;

        int finalday = Integer.MAX_VALUE;

        for(int num: bloomday){
            minday = Math.min(minday, num);
            maxday = Math.max(maxday, num);
        }

        while(minday<=maxday){
            int avgday = minday+(maxday-minday)/2;
            int count = 0;
            int flower = 0;

            for(int num: bloomday){
                if(num<=avgday){
                    flower++;
                }
                else{
                    flower = 0;
                }

                if(flower==k){
                    count++;
                    flower = 0;
                }
            }

            if(count>=m){
                finalday = Math.min(finalday, avgday);
                maxday = avgday-1;
            }
            else{
                minday = avgday+1;
            }
        }

        return finalday;
    }
}