class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=a){
                a = nums[i];
            }
            else if((nums[i]>a) && (nums[i]<=b)){
                b = nums[i];
            }
            else{
                return true;
            }
        }

        return false;
    }
}





// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         List<Integer> ll = new ArrayList<>();
//         return helper(0, ll, nums);
//     }

//     public boolean helper(int idx, List<Integer> ll, int nums[]){
//         if(ll.size() == 3){
//             return true;
//         }

//         if(idx == nums.length){
//             return false;
//         }

//         if(ll.size() == 0 || nums[idx] > ll.get(ll.size()-1)){
//             ll.add(nums[idx]);
//             if(helper(idx+1, ll, nums)){
//                 return true;
//             }
//             ll.remove(ll.size()-1);
//         }

//         return helper(idx+1, ll, nums);
//     }
// }