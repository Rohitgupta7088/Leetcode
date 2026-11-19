// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> bigll = new ArrayList<>();
//         List<Integer> ll = new ArrayList<>();
//         Arrays.sort(nums);
//         helper(0, bigll, ll, nums, target, 0L);
//         return bigll;
//     }

//     public void helper(int idx, List<List<Integer>> bigll, List<Integer> ll, int nums[], int target, long sum){
//         if(ll.size() == 4){
//             if(sum == target){
//                 bigll.add(new ArrayList<>(ll));
//             }
//             return;
//         }

//         if(idx>=nums.length){
//             return;
//         }

//         ll.add(nums[idx]);
//         helper(idx+1, bigll, ll, nums, target, sum+nums[idx]);
//         ll.remove(ll.size()-1);

//         int next = idx+1;
//         while(next<nums.length && nums[idx]==nums[next]){
//             next++;
//         }
//         helper(next, bigll, ll, nums, target, sum);
//     }
// }








class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> bigll = new ArrayList<>();

        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j=i+1; j<n-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = n-1;
                
                while(left<right){
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum>target){
                        right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        List<Integer> ll = new ArrayList<>();
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[left]);
                        ll.add(nums[right]);

                        bigll.add(new ArrayList<>(ll));

                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }

                        while(left<right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }

        return bigll;
    }
}