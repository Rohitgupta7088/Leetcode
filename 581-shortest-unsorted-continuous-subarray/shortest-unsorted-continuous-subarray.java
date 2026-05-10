class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int left = 0;
        int right = 0;
        boolean sorted = true;
        Stack<Integer> ss = new Stack<>();
        for(int i=0; i<n; i++){
            while(!ss.isEmpty() && ss.peek()<=nums[i]){
                ss.pop();
            }
            if(!ss.isEmpty() && ss.peek() > nums[i]){
                left = i-1;
                sorted = false;
                break;
            }
            ss.push(nums[i]);
        }

        if(sorted){
            return 0;
        }
        ss.clear();

        for(int i=n-1; i>=0; i--){
            while(!ss.isEmpty() && ss.peek()>=nums[i]){
                ss.pop();
            }
            if(!ss.isEmpty() && ss.peek() < nums[i]){
                right = i+1;
                break;
            }
            ss.push(nums[i]);
        }

        ss.clear();

        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++){
            minval = Math.min(minval, nums[i]);
            maxval = Math.max(maxval, nums[i]);
        }

        while(left > 0 && nums[left-1]>minval){
            left--;
        }

        while(right<n-1 && nums[right+1]<maxval){
            right++;
        }

        return right-left+1;
    }
}