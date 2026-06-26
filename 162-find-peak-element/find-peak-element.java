class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        return helper(nums, 0, n-1);
    }

    public int helper(int nums[], int si, int ei){
        if(si > ei){
            return -1;
        }

        if(si == ei){
            return si;
        }

        int mid = si+(ei-si)/2;

        if(mid == 0 && nums[mid]<=nums[mid+1]){
            return helper(nums, mid+1, ei);
        }
        else if(mid == 0 && nums[mid]>=nums[mid+1]){
            return mid;
        }

        if(mid == nums.length-1 && nums[mid-1]>=nums[mid]){
            return helper(nums, si, mid-1);
        }
        else if(mid == nums.length-1 && nums[mid-1]<=nums[mid]){
            return mid;
        }

        if(nums[mid-1] >= nums[mid] && nums[mid] >= nums[mid+1]){
            return helper(nums, si, mid-1);
        }
        else if(nums[mid-1]<=nums[mid] && nums[mid]<=nums[mid+1]){
            return helper(nums, mid+1, ei);
        }
        else if(nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]){
            return helper(nums, mid+1, ei);
        }
        else if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
            return mid;
        }

        return helper(nums, mid+1, ei);
    }
}