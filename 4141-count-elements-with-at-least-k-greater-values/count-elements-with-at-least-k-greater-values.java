class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(n==1 && k==0){
            return 1;
        }

        // int elecount = 0;
        // Arrays.sort(nums);

        // for(int i=0; i<n; i++){
        //     int count = 0;
        //     for(int j=i; j<n; j++){
        //         if(nums[j] > nums[i]){
        //             count += 1;
        //         }

        //         if(count >= k ){
        //             elecount += 1;
        //             break;
        //         }
        //     }
        // }

        // int elecount = 0;

        // for(int i=0; i<n; i++){
        //     int count = 0;
        //     for(int j=0; j<n; j++){
        //         if(nums[j] > nums[i]){
        //             count ++;
        //         }

        //         if(count >= k){
        //             elecount += 1;
        //             break;
        //         }
        //     }
        // }

        // return elecount;

        Arrays.sort(nums);
        int elecount = 0;
        int i=0;
        while(i<n){
            int a=i;
            while(a<n && nums[a] == nums[i]){
                a++;
            }
            if(n-a >= k){
                elecount += a-i;
            }
            i=a-1;
            i++;
        }

        return elecount;
    }
}