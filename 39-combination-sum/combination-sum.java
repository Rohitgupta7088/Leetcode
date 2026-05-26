class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(candidates, target, 0, bigll, ll);
        return bigll;
    }

    public void helper(int nums[], int target, int idx, List<List<Integer>> bigll, List<Integer> ll){
        if(idx >= nums.length){
            return;
        }

        if(target == 0){
            bigll.add(new ArrayList<>(ll));
        }
        else if(target > 0){
            ll.add(nums[idx]);
            helper(nums, target-nums[idx], idx, bigll, ll);
            ll.remove(ll.size()-1);
            helper(nums, target, idx+1, bigll, ll);
        }
        else if(target < 0){
            return;
        }

    }
}