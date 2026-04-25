class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 1 && nums[0] >= target){
            return 1;
        }
        else if(n == 1 && nums[0] < target){
            return 0;
        }

        int left = 0;
        int right = 0;
        int minlen = Integer.MAX_VALUE;

        int sum = 0;
        while(right<n){
            sum += nums[right];
            if(sum >= target){
                while(sum >= target){
                    sum -= nums[left];
                    minlen = Math.min(minlen, right-left+1);
                    left++;
                }
            }
            right++;
        }

        if(minlen == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minlen;
        }
    }
}