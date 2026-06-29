class Solution {
    // public int singleNonDuplicate(int[] nums) {
    //     int n=nums.length;
    //     if(n==1) return nums[0];

    //     for(int i=0; i<n; i++){
    //         if(i==0){
    //             if(nums[i] != nums[i+1]){
    //                 return nums[i];
    //             }
    //             continue;
    //         }
            
    //         if(i==n-1){
    //             if(nums[i-1] != nums[i]){
    //                 return nums[i];
    //             }
    //         }

    //         if(!(nums[i-1]==nums[i] || nums[i]==nums[i+1])){
    //             return nums[i];
    //         }
    //     }

    //     return -1;
    // }


    public int singleNonDuplicate(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int nums[], int si, int ei){
        if(si >= ei){
            return nums[si];
        }

        int mid = si+(ei-si)/2;

        if(mid == 0){
            if(nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            else{
                helper(nums, mid+1, ei);
            }
        }

        if(mid == nums.length-1){
            if(nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            else{
                helper(nums, si, mid-1);
            }
        }

        if(nums[mid-1] == nums[mid]){
            if(mid%2 != 0){
                return helper(nums, mid+1, ei);
            }
            else{
                return helper(nums, si, mid-1);
            }
        }
        else if(nums[mid] == nums[mid+1]){
            if(mid%2 != 0){
                return helper(nums, si, mid-1);
            }
            else{
                return helper(nums, mid+1, ei);
            }
        }

        return nums[mid];

    }
}