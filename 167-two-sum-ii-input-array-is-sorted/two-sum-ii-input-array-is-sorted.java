// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int arr[] = new int[2];
//         if(n==2){
//             if(nums[0] + nums[1] == target){
//                 arr[0] = 1;
//                 arr[1] = 2;
//                 return arr;
//             }
//         }

//         for(int i=n-1; i>=1; i--){
//             arr[1] = i+1;
//             int idx = helper(nums, 0, i-1, target-nums[i]);
//             if(idx != -1){
//                 arr[0] = idx+1;
//                 break;
//             }
//             arr[1] = 0;
//         }

//         return arr;
//     }

//     public int helper(int nums[], int si, int ei, int target){
//         if(si > ei){
//             return -1;
//         }

//         int mid = si+(ei-si)/2;
//         if(nums[mid] == target){
//             return mid;
//         }
//         else if(nums[mid]>target){
//             return helper(nums, si, mid-1, target);
//         }
//         else{
//             return helper(nums, mid+1, ei, target);
//         }
//     }
// }




class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int arr[] = new int[2];
        // if(n==2){
        //     if(nums[0] + nums[1] == target){
        //         arr[0] = 1;
        //         arr[1] = 2;
        //         return arr;
        //     }
        // }

        int left = 0;
        int right = n-1;

        while(left <= right){
            if(nums[left]+nums[right] == target){
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            }
            else if(nums[left]+nums[right] > target){
                right--;
            }
            else{
                left++;
            }
        }

        return arr;
    }
}