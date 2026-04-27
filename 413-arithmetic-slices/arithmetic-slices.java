class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3){
            return 0;
        }

        int left=0;
        int right=0;
        int count=0;
        while(right<n){
            if(right>=2){
                if( (nums[right-2] - nums[right-1]) != (nums[right-1]-nums[right]) ){
                    if(right-left >= 3){
                        count += ((right-left-1)*(right-left-2))/2;
                    }
                    left = right-1;
                }
            }
            right++;
        }

        if(right-left >= 3){
            count += ((right-left-1)*(right-left-2))/2;
        }

        // while(right<n){
        //     if(right>=2){
        //         if( (nums[right-2] - nums[right-1]) == (nums[right-1]-nums[right])){
        //             subarr++;
        //             count+=subarr;
        //         }
        //         else{
        //             subarr=0;
        //         }
        //     }
        //     right++;
        // }
        return count;
    }
}