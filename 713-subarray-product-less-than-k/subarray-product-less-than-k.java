class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k<=1){
            return 0;
        }
        if(n == 1 && nums[0]<k){
            return 1;
        }
        else if(n == 1 && nums[0] >= k){
            return 0;
        }
        
        int left = 0;
        int right = 0;
        int count = 0;

        int product = 1;
        while( right<n ){
            product *= nums[right];
            if(product < k){
                count += right-left+1;
            }
            else if(product >= k){
                while(product >= k){
                    product /= nums[left];
                    left++;
                }
                count += right-left+1;
            }
            right++;
        }

        return count;
    }
}