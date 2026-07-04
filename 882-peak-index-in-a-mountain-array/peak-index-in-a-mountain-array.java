class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       return helper(arr, 0, arr.length-1);
    }

    public int helper(int nums[], int si, int ei){
        if(si==ei){
            return si;
        }

        int mid = si+(ei-si)/2;


        if(mid == 0){
            if(nums[mid]<nums[mid+1]){
                return helper(nums, mid+1, ei);
            }
            else{
                return mid;
            }
        }
        
        if(mid==nums.length-1){
            if(nums[mid]<nums[mid-1]){
                return helper(nums, si, mid-1);
            }
            else{
                return mid;
            }
        }

        if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
            return mid;
        }

        if(mid<nums.length-1 && nums[mid]<nums[mid+1]){
            return helper(nums, mid+1, ei);
        }
        else{
            return helper(nums, si, mid-1);
        }
    }
}