class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> bigll = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, ll, bigll, nums);
        return bigll;
    }

    public void helper(int idx, List<Integer> ll, List<List<Integer>> bigll, int nums[]){
        bigll.add(new ArrayList<>(ll));

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]){
                continue;
            }

            ll.add(nums[i]);
            helper(i+1, ll, bigll, nums);
            ll.remove(ll.size()-1);
        }
    }
}