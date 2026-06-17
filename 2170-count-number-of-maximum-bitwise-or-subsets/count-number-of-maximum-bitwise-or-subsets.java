class Solution {
    int maxor = Integer.MIN_VALUE;
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        helper(nums, 0, 0);
        return count;
    }

    public void helper(int nums[], int tempor, int idx){
        if(idx >= nums.length){
            if(maxor < tempor){
                maxor = tempor;
                count = 1;
            }
            else if(maxor == tempor){
                count++;
            }
            return;
        }

        helper(nums, tempor | nums[idx], idx+1);
        helper(nums, tempor, idx+1);
    }
}