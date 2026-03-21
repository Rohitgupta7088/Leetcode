class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int ref = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == ref){
                continue;
            }
            else if(nums[i] == ref+1){
                count++;
                ref = nums[i];
            }
            else{
                ref = nums[i];
                count = 1;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}