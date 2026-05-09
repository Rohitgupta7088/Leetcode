class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int result[] = new int[n];
        Stack<Integer> ss = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            int idx = i%n;
            while(!ss.isEmpty() && ss.peek()<=nums[idx]){
                ss.pop();
            }

            if(ss.isEmpty()){
                result[idx] = -1;
            }
            else{
                result[idx] = ss.peek();
            }

            ss.push(nums[idx]);
        }

        return result;
    }
}