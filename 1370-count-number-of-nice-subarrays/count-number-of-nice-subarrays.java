class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(n==1 && k==1){
            if(nums[0]%2 == 0){
                return 0;
            }
            else{
                return 1;
            }
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int atmost=0;
        int atmostk=0;

        while(right<n){
            if(nums[right]%2 != 0){
                count++;
            }

            while(count > k){
                if(nums[left]%2 != 0){
                    count--;
                }
                left++;
            }

            atmost += right-left+1;
            right++;
        }

        left = 0;
        right = 0;
        count = 0;
        while(right<n){
            if(nums[right]%2 != 0){
                count++;
            }

            while(count > k-1){
                if(nums[left]%2 != 0){
                    count--;
                }
                left++;
            }

            atmostk += right-left+1;
            right++;
        }

        return atmost-atmostk;
    }
}