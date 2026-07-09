class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num: nums){
            high = Math.max(high, num);
        }

        int ans = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low+(high-low)/2;

            int sum = 0;
            boolean foundbug = false;
            for(int num: nums){
                sum += Math.ceil((double)num/mid);
                if(sum>threshold){
                    foundbug = true;
                    break;
                }
            }

            if(!foundbug){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}