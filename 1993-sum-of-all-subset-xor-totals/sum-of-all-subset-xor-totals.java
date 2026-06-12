class Solution {
    int count = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums, 0, 0);
        return count;
    }

    public void helper(int nums[], int temp, int idx){
        if(idx >= nums.length){
            count += temp;
            return;
        }

        helper(nums, temp^nums[idx], idx+1);
        helper(nums, temp, idx+1);
    }
}