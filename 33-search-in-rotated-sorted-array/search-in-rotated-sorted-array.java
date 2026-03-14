class Solution {
    public static int search(int nums[], int target){
        int si = 0;
        int ei = nums.length-1;
        return searchidx(nums, si, ei, target);
    }

    public static int searchidx(int nums[], int si, int ei, int target){
        int mid = si + (ei-si)/2;

        if(si > ei){
            return -1;
        }

        if(nums[mid] == target){
            return mid;
        }

        if(nums[si] <= nums[mid]){
            if(nums[si]<=target && target<nums[mid]){
                return searchidx(nums,si,mid-1,target);
            }
            else{
                return searchidx(nums,mid+1,ei,target);
            }
        }
        else{
            if(nums[mid]<target && target<= nums[ei]){
                return searchidx(nums,mid+1,ei,target);
            }
            else{
                return searchidx(nums,si,mid-1,target);
            }
        }
    }
}