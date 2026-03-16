class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> biglist = new ArrayList<>();
        Arrays.sort(nums);
        int left;
        int right;
        for(int i=0; i<nums.length; i++){

            if( i>0 && nums[i] == nums[i-1]){
                continue;
            }

            left = i+1;
            right = nums.length-1;
            while(left < right){
                if( (nums[i] + nums[left] + nums[right]) == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    biglist.add(list);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
                else{
                    if( (nums[i] + nums[left] + nums[right]) >0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }

        return biglist;
    }
}