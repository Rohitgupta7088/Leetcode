class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int right=0; right<nums.length; right++){
            int j=left;
            if( set.contains(nums[right]) ){
                return true;
            }
            else{
                set.add(nums[right]);
            }
            if(right-left == k){
                set.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}