class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int arr[] = new int[2];

        if(n==0){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        int idx = helper(nums, 0, n-1, target);

        if(idx == -1){
            arr[0] = -1;
            arr[1] = -1;
        }
        else{
            int left = idx;
            int right = idx;

            while(left>=0 && nums[left] == target){
                left--;
            }

            while(right<n && nums[right] == target){
                right++;
            }

            arr[0] = left+1;
            arr[1] = right-1;
        }

        return arr;
    }

    public int helper(int nums[], int si, int ei, int target){
        if(si>ei){
            return -1;
        }

        int mid = si+(ei-si)/2;

        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid]<target){
            return helper(nums, mid+1, ei, target);
        }
        else{
            return helper(nums, si, mid-1, target);
        }
    }
}