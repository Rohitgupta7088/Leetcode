class Solution {
    int count = 0;
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ll = new ArrayList<>();
        permutation(nums, ll);
        return count;
    }

    public void permutation(int nums[], List<Integer> ll){
        if(nums.length == 0){
            count++;
            return;
        }

        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];

            if(ll.size()>0){
                int root = (int)Math.sqrt(ll.get(ll.size()-1)+curr);
                if(root*root != ll.get(ll.size()-1)+curr){
                    continue;
                }
            }
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
            permutation(arr, ll);
            ll.remove(ll.size()-1);
        }
    }
}