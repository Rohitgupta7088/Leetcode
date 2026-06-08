class Solution {
    long strength = Long.MIN_VALUE;
    public long maxStrength(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        helper(nums, ll, 0);
        return strength;
    }

    public void helper(int nums[], List<Integer> ll, int idx){
        if(idx >= nums.length){

            if(ll.size() == 0){
                return;
            }
            long temp = 1;
            for(int num: ll){
                temp *= (long)num;
            }

            strength = Math.max(temp, strength);
            return;
        }

        ll.add(nums[idx]);
        helper(nums, ll, idx+1);
        ll.remove(ll.size()-1);
        helper(nums, ll, idx+1);
    }
}