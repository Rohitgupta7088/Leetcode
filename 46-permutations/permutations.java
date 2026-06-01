class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> bigll = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        permutation(nums, bigll, ll);
        return bigll;
    }

    public void permutation(int nums[], List<List<Integer>> bigll, List<Integer> ll){
        if(nums.length == 0){
            bigll.add(new ArrayList<>(ll));
            return;
        }

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int arr[] = new int[nums.length-1];
            for(int j=0; j<nums.length; j++){
                if(j==i){
                    continue;
                }
                else if(j<i){
                    arr[j] = nums[j];
                }
                else if(j>i){
                    arr[j-1] = nums[j];
                }
            }

            ll.add(curr);
            permutation(arr, bigll, ll);
            ll.remove(ll.size()-1);
        }
    }
}