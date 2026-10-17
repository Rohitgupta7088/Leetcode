class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        ll.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(ll.get(ll.size()-1) == nums[i]){
                continue;
            }

            ll.add(nums[i]);
        }

        for(int i=0; i<ll.size(); i++){
            nums[i] = ll.get(i);
        }

        return ll.size();
    }
}