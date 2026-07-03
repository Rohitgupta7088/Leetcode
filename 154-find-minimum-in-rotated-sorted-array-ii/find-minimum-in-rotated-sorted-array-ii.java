class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int nums[], int si, int ei){
        if( si == ei){
            return nums[si];
        }

        int mid = si+(ei-si)/2;

        if(mid>0 && mid<nums.length-1 && nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]){
            return nums[mid];
        }

        while(si<ei && nums[si] == nums[mid] && nums[mid] == nums[ei]){
            si++;
            ei--;
            mid = si+(ei-si)/2;
        }

        if(nums[si]<=nums[mid]){
            if(nums[mid]>nums[ei]){
                return helper(nums, mid+1, ei);
            }
            else{
                return helper(nums, si, mid);
            }
        }
        else{
            return helper(nums, si, mid);
        }
    }
}



// if(mid == 0){
        //     if(nums[mid] >= nums[nums.length-1]){
        //         if(nums[mid]<nums[ei]){
        //             return helper(nums, ei, nums.length-1)
        //         }
        //         else{
        //             return helper(nums, 0, ei);
        //         }
        //     }
        //     else{
        //         return nums[mid];
        //     }
        // }