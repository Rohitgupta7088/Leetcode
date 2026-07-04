class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(days == 1){
            int sum = 0;
            for(int num: weights){
                sum += num;
            }
            return sum;
        }

        long low = 0;
        for(int num: weights){
            low = Math.max(low, num);
        }
        
        long maxweight = 0;
        for(int num: weights){
            maxweight += (long)num;
        }

        int finalweight = Integer.MAX_VALUE;
        while(low<=maxweight){
           long avgweight = low + (maxweight-low)/2;
           int day = 1;
           long sum = 0;
           for(int i=0; i<weights.length; i++){
            sum += (long)weights[i];
            if(sum>avgweight){
                day += 1;
                sum = (long)weights[i];
            }
           }

           if(day>days){
            low = avgweight+1;
           }
           else{
                finalweight = Math.min((int)avgweight, finalweight);
                maxweight = avgweight-1;
            }
        }

        return finalweight;
    }
}