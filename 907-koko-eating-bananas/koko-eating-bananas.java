class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = 0;
        for(int num: piles){
            high = Math.max(high, num);
        }

        int finalspeed = high;

        while(low <= high){
            int avgspeed = low+(high-low)/2;
            long temphr = 0;
            for(int i=0; i<piles.length; i++){
                temphr += (long)Math.ceil((double)piles[i]/avgspeed);
            }

            if(temphr>h){
                low = avgspeed+1;
            }
            else{
                finalspeed = Math.min(finalspeed, avgspeed);
                high = avgspeed-1;
            }
        }

        return (int)finalspeed;
    }
}