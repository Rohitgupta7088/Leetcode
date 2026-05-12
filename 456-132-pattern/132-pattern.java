class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        if(n<3){
            return false;
        }

        Stack<Integer> ss = new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(nums[i]<second){
                return true;
            }
            else if(nums[i]>=second){
                while(!ss.isEmpty() && nums[i] > ss.peek()){
                    second = Math.max(ss.pop(), second);
                }
                ss.push(nums[i]);
            }
        }

        return false;
    }
}