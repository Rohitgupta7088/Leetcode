class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 3){
            return ans;
        }

        for(int i=n-1; i>=0; i--){
            int target = nums[i];

            int left = 0;
            int right = i-1;

            while(left<right){
                if(nums[left]+nums[right] > target){
                    ans += right-left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        return ans;
    }
}