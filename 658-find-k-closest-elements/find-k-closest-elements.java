class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int n=nums.length;
        List<Integer> ll = new ArrayList<>();
        if(n == k){
            for(int ele: nums){
                ll.add(ele);
            }
            return ll;
        }
        int left = 0;
        int right = n-1;

        while( right-left+1 > k){
            if(Math.abs(nums[left]-x)>Math.abs(nums[right]-x)){
                left++;
            }
            else{
                right--;
            }
        }

        while(left<=right){
            ll.add(nums[left++]);
        }
        return ll;
    }
}