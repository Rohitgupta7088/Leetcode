class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> bigll = new ArrayList<>();
        helper(nums, 0, bigll, ll);
        return bigll;
    }

    public void helper(int nums[], int idx, List<List<Integer>> bigll, List<Integer> ll){
        if(idx >= nums.length){
            if(ll.size() > 1 && !set.contains(ll)){
                boolean valid = true;
                for(int i=0; i<ll.size(); i++){
                    if(i>0 && ll.get(i-1) > ll.get(i) ){
                        valid = false;
                        break;
                    }
                }

                if(valid){
                    bigll.add(new ArrayList<>(ll));
                    set.add(new ArrayList<>(ll));
                }
            }

            return;
        }

        ll.add(nums[idx]);
        helper(nums, idx+1, bigll, ll);
        ll.remove(ll.size()-1);
        helper(nums, idx+1, bigll, ll);
    }
}