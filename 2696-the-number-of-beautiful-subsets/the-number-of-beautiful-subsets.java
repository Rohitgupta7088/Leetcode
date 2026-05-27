class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> ll = new ArrayList<>();
        helper(nums, ll, 0, k);
        return count;
    }

    public void helper(int nums[], List<Integer> ll, int si, int k){
        if(si>=nums.length){
            if(ll.size()>0 && !safe(ll, 0, k)){
                count++;
            }
            return;
        }

        ll.add(nums[si]);
        helper(nums, ll, si+1, k);
        ll.remove(ll.size()-1);
        helper(nums, ll, si+1, k);
    }

    public boolean safe(List<Integer> ll, int si, int k){
        if(si >= ll.size()){
            return false;
        }

        int n =  ll.get(si)-k;
        
        if(ll.contains(n)){
            return true;
        }
        else{
            return safe(ll, si+1, k);
        }
    }
}