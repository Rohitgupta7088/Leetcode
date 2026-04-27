class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3){
            return 0;
        }

        int left=0;
        int right=0;
        int subarr = 0;
        int count=0;
        // while(right<n){
        //     if(right>=2){
        //         if( (nums[right-2] - nums[right-1]) != (nums[right-1]-nums[right]) ){
        //             if(right-left+1 >= 3){
        //                 subarr = (int)(((long)(right-left)*(right-left-1))/2);
        //                 count += subarr;
        //             }
        //             left = right-1;
        //         }
        //     }
        //     if(right==n-1 && right-left+1 >= 3){
        //         subarr = (int)(((long)(right-left)*(right-left-1))/2);
        //         count += subarr;
        //     }
        //     right++;
        // }

        while(right<n){
            if(right>=2){
                if( (nums[right-2] - nums[right-1]) == (nums[right-1]-nums[right])){
                    subarr++;
                    count+=subarr;
                }
                else{
                    subarr=0;
                }
            }
            right++;
        }
        return count;
    }
}