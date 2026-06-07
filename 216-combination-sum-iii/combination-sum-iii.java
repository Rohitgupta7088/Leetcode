class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(k, n, 1, 0, ll, bigll);
        return bigll; 
    }

    public void helper(int k, int n, int curr, int sum, List<Integer> ll, List<List<Integer>> bigll){
        if(ll.size() == k){
            if(sum == n){
                bigll.add(new ArrayList<>(ll));
            }

            return;
        }

        if(ll.size() > k || curr>9 || sum>n){
            return;
        }

        ll.add(curr);
        helper(k, n, curr+1, sum+curr, ll, bigll);
        ll.remove(ll.size()-1);
        helper(k, n, curr+1, sum, ll, bigll);
    }
}