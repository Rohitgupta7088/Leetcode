class Solution {
    public int[] twoSum(int[] nums, int target) {
        int total[] = new int[2];
        for(int i=0; i<nums.length; i++){
            int f=0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    total[0] = i;
                    total[1] = j;
                    f = 1;
                }
            }
            if(f == 1){
                return total;
            }
        }

        total[0] = -1;
        total[1] = -1;
        return total;
    }
}