class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public int helper(int nums[], int si, int ei){
        if(si>ei){
            return nums[si];
        }

        int mid = si+(ei-si)/2;

        if( mid>0 && nums[mid-1] > nums[mid]){
            return nums[mid];
        }

        if(nums[mid] > nums[ei]){
            return helper(nums, mid+1,ei);
        }
        else{
            return helper(nums, si, mid-1);
        }
    }
}