class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != val){
                count ++;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == val){
                int a=i;
                while(a<n-1){
                    nums[a] = nums[a+1];
                    a++;
                }
                i--;
                n--;
            }
        }
        return count;
    }
}