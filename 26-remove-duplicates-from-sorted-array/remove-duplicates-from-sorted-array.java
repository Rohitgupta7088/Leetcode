class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int count;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]){
                int a=i;
                while(a<n-1){
                    nums[a] = nums[a+1];
                    a++;
                }
                nums[n-1] = 0;
                n--;
                i--;
            }
        }

        count = n;
        return count;
    }
}