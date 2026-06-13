class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        List<List<Integer>> bigll = new ArrayList<>();
        helper(cookies, k, bigll, 0);
        return ans;
    }

    public void helper(int nums[], int k, List<List<Integer>> bigll, int idx){

        if(idx >= nums.length){
            if(bigll.size()  == k){
                ans = Math.min(ans, calculate(bigll, 0, 0));
            }
            return;
        }

        for(int i=0; i<bigll.size(); i++){
            bigll.get(i).add(nums[idx]);
            helper(nums, k, bigll, idx+1);
            bigll.get(i).remove(bigll.get(i).size()-1);
        }

        if(bigll.size() < k){
            List<Integer> ll = new ArrayList<>();
            ll.add(nums[idx]);
            bigll.add(new ArrayList<>(ll));
            helper(nums, k, bigll, idx+1);
            bigll.remove(bigll.size()-1);
        }
    }

    public int calculate(List<List<Integer>> bigll, int idx, int temp){
        if(idx >= bigll.size()){
            return temp;
        }

        int sum = 0;
        for(int i=0; i<bigll.get(idx).size(); i++){
            sum += bigll.get(idx).get(i);
        }

        temp = Math.max(temp, sum);
        return calculate(bigll, idx+1, temp);
    }
}