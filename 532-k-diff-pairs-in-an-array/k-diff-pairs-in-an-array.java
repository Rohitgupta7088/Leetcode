class Solution {
    // int count = 0;
    // public int findPairs(int[] nums, int k) {
    //     List<Integer> ll = new ArrayList<>();
    //     Arrays.sort(nums);
    //     for(int i=nums.length-1; i>0; i--){
    //         if(!ll.contains(nums[i])){
    //             ll.add(nums[i]);
    //             int idx = helper(nums, 0, i-1, nums[i]-k);
    //             if(idx == -1) continue;
    //             else count++;
    //         }
    //     }

    //     return count;
    // }

    // public int helper(int nums[], int si, int ei, int target){
    //     if(si > ei){
    //         return -1;
    //     }

    //     int mid = si+(ei-si)/2;

    //     if(nums[mid] == target){
    //         return mid;
    //     }

    //     if(nums[mid] < target){
    //         return helper(nums, mid+1, ei, target);
    //     }
    //     else{
    //         return helper(nums, si, mid-1, target);
    //     }
    // }





    int count = 0;
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int left =  0;
        int right = 1;

        List<Integer> ll = new ArrayList<>();
        while(right < nums.length && left<nums.length){
            if( !ll.contains(nums[left]) ){

                if(left == right){
                    right++;
                    continue;
                }

                if(nums[right]-nums[left] == k){
                    ll.add(nums[left]);
                    count++;
                    right++;
                    left++;
                    continue;
                }

                if(nums[right]-nums[left] < k){
                    right++;
                }
                else if(nums[right]-nums[left] >k){
                    left++;
                }
            }
            else{
                left++;
                continue;
            }
        }

        return count;
    }
}