class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && k == 1){
            return 1;
        }
        else if(n == 1 && k == 0){
            if(nums[0] == 1){
                return 1;
            }
            else{
                return 0;
            }
        }

        int left = 0;
        int right = 0;
        int length = 0;
        int count = 0;
        while(right<n){
            if(nums[right] == 0){
                count+=1;
            }

            if(count <= k){
                length = Math.max(length, right-left+1);
            }
            else if(count > k){
                while(count > k){
                    if(nums[left] == 0){
                        count--;
                    }
                    left++;
                }
                length = Math.max(length, right-left+1);
            }
            right++;
        }

        return length;
    }
}