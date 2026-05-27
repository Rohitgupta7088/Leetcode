class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        helper(nums, bigll, ll, 0, nums.length);
        return bigll;
    }

    public void helper(int nums[], List<List<Integer>> bigll, List<Integer> ll, int si, int ei){
        if(si >= ei){
            bigll.add(new ArrayList<>(ll));
            return;
        }

        ll.add(nums[si]);
        helper(nums, bigll, ll, si+1, ei);
        ll.remove(ll.size()-1);
        helper(nums, bigll, ll, si+1, ei);
    }
}