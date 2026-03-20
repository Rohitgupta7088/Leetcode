class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums,0,nums[0]);
    }
    public int helper(int nums[], int si, int ref){
        if(si >= nums.length){
            return -1;
        }
        int count = 0;
        for(int i=si; i<nums.length; i++){
            if(nums[i] == ref){
                count ++;
            }
            else{
                count --;
            }

            if(count < 0){
                return helper(nums,i,nums[i]);
            }
        }
        return ref;
    }
}