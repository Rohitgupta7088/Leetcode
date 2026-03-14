class Solution {
    public int searchInsert(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        return search(nums, si, ei, target);
    }
    public int search(int nums[], int si, int ei, int target){
        int mid = si + (ei-si)/2;

        if(si > ei){
            return si;
        }

        if(nums[mid]==target){
            return mid;
        }

        if(nums[mid] < target){
            return search(nums, mid+1, ei, target);
        }
        else{
            return search(nums, si, mid-1, target);
        }
    }
}