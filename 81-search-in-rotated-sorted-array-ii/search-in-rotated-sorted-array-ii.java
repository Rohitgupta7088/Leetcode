class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }
    public boolean helper(int nums[], int si, int ei, int target){
        if(si>ei){
            return false;
        }

        int mid = si+(ei-si)/2;

        if(nums[mid] == target){
            return true;
        }

        while(si<ei && nums[si] == nums[mid] && nums[mid] == nums[ei]){
            si++;
            ei--;
        }

        if(nums[si] <= nums[mid]){
            if(nums[si]<=target && target < nums[mid]){
                return helper(nums, si, mid-1, target);
            }
            else{
                return helper(nums, mid+1, ei, target);
            }
        }
        else{
            if(nums[mid] < target && nums[ei] >= target){
                return helper(nums, mid+1, ei, target);
            }
            else{
                return helper(nums, si, mid-1, target);
            }
        }
    }
}