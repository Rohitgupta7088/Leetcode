class Solution {
    // int count = 0;
    // String op = "+-";
    // public int findTargetSumWays(int[] nums, int target) {
    //     List<Character>ll = new ArrayList<>();
    //     helper(nums, target, ll, 0);
    //     return count;
    // }

    // public void helper(int nums[], int target, List<Character> ll, int idx){
    //     if(idx >= nums.length){
    //         if(valid(ll, nums) == target){
    //             count++;
    //         }
    //         return;
    //     }

    //     for(int i=0; i<op.length(); i++){
    //         ll.add(op.charAt(i));
    //         helper(nums, target, ll, idx+1);
    //         ll.remove(ll.size()-1);
    //     }
    // }

    // public int valid(List<Character> ll, int nums[]){
    //     int temp = 0;
    //     for(int i=0; i<nums.length; i++){
    //         if(ll.get(i) == '+'){
    //             temp += nums[i];
    //         }
    //         else{
    //             temp -= nums[i];
    //         }
    //     }

    //     return temp;
    // }


    int count = 0;
    public int findTargetSumWays(int[] nums, int target){
        helper(nums, target, 0, 0);
        return count;
    }

    public void helper(int nums[], int target, int currsum, int idx){
        if(idx >= nums.length){
            if(currsum == target){
                count++;
            }
            return;
        }

        helper(nums, target, currsum + nums[idx], idx+1);
        helper(nums, target, currsum - nums[idx], idx+1);
    }
}