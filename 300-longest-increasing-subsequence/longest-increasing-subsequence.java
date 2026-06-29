class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        ll.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(ll.get(ll.size()-1) < nums[i]){
                ll.add(nums[i]);
            }
            else{
                helper(ll, 0, ll.size()-1, nums[i]);
            }
        }

        return ll.size();
    }

    public void helper(List<Integer> ll, int si, int ei, int target){
        if(si==ei){
            ll.set(si, target);
            return;
        }

        int mid = si+(ei-si)/2;

        if(mid == 0){
            if(target <= ll.get(mid)){
                ll.set(mid, target);
            }
            else{
                helper(ll, mid+1, ei, target);
            }
            return;
        }

        if(ll.get(mid-1)<target && ll.get(mid)>=target){
            ll.set(mid, target);
        }
        else if(ll.get(mid-1)<target && ll.get(mid)<target){
            helper(ll, mid+1, ei, target);
        }
        else{
            helper(ll, si, mid, target);
        }
    }
}