class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int left=0;
        int right=1;
        int maxlength=1;
        while(right<n){
           if(nums[right-1] == nums[right]){
            left = right;
           }
           else{
            if(right>=2){
                if((nums[right-2]>nums[right-1] && !(nums[right-1]<nums[right])) ||  (nums[right-2]<nums[right-1] && !(nums[right-1]>nums[right]))){
                left = right-1;
                }
           }
            }

           maxlength = Math.max(maxlength, right-left+1);
           right++;
        }

        return maxlength;
    }
}