class Solution {
    public static int search(int nums[], int target){
        int si = 0;
        int ei = nums.length-1;
        return helper(si, ei, nums, target);
    }

    public static int helper(int si, int ei, int nums[], int target){
        if(si>ei){
            return -1;
        }
        int mid = si+(ei-si)/2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[si]<=nums[mid]){
            if(nums[si]<=target && target<nums[mid]){
                return helper(si, mid-1, nums, target);
            }
            else{
                return helper(mid+1, ei, nums, target);
            }
        }
        else{
            if(nums[mid]<target && target<=nums[ei]){
                return helper(mid+1, ei, nums, target);
            }
            else{
                return helper(si, mid-1, nums, target);
            }
        }
    }
}