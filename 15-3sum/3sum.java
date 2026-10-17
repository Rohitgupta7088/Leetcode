class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> bigll = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[left]);
                    ll.add(nums[right]);

                    bigll.add(new ArrayList<>(ll));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while(left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
                else{
                    if(nums[i]+nums[left]+nums[right] > 0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }

        return bigll;
    }
}