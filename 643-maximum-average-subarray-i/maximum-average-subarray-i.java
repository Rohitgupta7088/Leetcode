class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1){
            return (double)nums[0];
        }
        double maxavg = 0;
        double windowsum = 0;

        for(int i=0; i<k; i++){
            windowsum += nums[i];
        }

        maxavg = windowsum/k;

        for(int i=k; i<nums.length; i++){
            windowsum -= nums[i-k];
            windowsum += nums[i];
            maxavg = Math.max(maxavg, windowsum/k);
        }

        return maxavg;
    }
}