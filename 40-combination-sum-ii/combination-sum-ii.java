class Solution {
    // HashSet<List<Integer>> seen = new HashSet<>();
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     List<List<Integer>> bigll = new ArrayList<>();
    //     List<Integer> ll = new ArrayList<>();
    //     helper(candidates, target, bigll, ll , 0);
    //     return bigll;
    // }

    // public void helper(int[] nums, int target, List<List<Integer>> bigll, List<Integer> ll, int idx){
    //     if(idx >= nums.length){
    //         if(ll.size() > 0){
    //             int sum = 0;
    //             for(int i=0; i<ll.size(); i++){
    //                 sum += ll.get(i);
    //             }

    //             if(sum == target){
    //                 List<Integer> temp = new ArrayList<>(ll);
    //                 Collections.sort(temp);
    //                 if(seen.contains(temp)){
    //                     return;
    //                 }
    //                 seen.add(temp);
    //                 bigll.add(new ArrayList<>(temp));
    //                 return;
    //             }
    //             else{
    //                 return;
    //             }
    //         }
    //         return;
    //     }
    //     ll.add(nums[idx]);
    //     helper(nums, target, bigll, ll , idx+1);
    //     ll.remove(ll.size()-1);
    //     helper(nums, target, bigll, ll , idx+1);
    // }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(candidates, target, bigll, ll , 0);
        return bigll;
    }

    public void helper(int[] nums, int target, List<List<Integer>> bigll, List<Integer> ll, int idx){
        
        if(target == 0){
            bigll.add(new ArrayList<>(ll));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i-1] == nums[i]){
                continue;
            }

            if(nums[i] > target){
                break;
            }

            ll.add(nums[i]);
            helper(nums, target-nums[i], bigll, ll , i+1);
            ll.remove(ll.size()-1);
        }
    }
}