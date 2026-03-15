class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> biglist = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        subset(nums, biglist, new ArrayList<>(), i);
        return biglist;
    }

    public void subset(int nums[], List<List<Integer>> biglist, List<Integer> list, int i){
        biglist.add(new ArrayList<>(list));
        for(int j=i; j<nums.length; j++){

            if(j>i && nums[j] == nums[j-1]){
                continue;
            }

            list.add(nums[j]);
            subset(nums, biglist, list, j+1);
            list.remove(list.size()-1);
        }
    }
}