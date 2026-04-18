class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left;
        int right;
        int closesum = nums[0] + nums[1] + nums[2];
        for(int i=0; i<=n-3; i++){
            int one = nums[i];
            left = i+1;
            right = n-1;
            while(left < right){
                int sum = one + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                else{
                    if( Math.abs(sum-target) < Math.abs(closesum-target)){
                        closesum = sum;
                    }
                    if(sum < target){
                    left++;
                    }
                    else if(sum > target){
                        right--;
                    }
                }
            }
        }

        return closesum;
    }
}