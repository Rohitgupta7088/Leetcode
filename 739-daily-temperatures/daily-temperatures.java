class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int ans[] = new int[n];
        ans[n-1] = 0;
        Stack<Integer> ss = new Stack<>();
        ss.push(n-1);
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[ss.peek()]){
                ans[i] = ss.peek()-i;
            }
            else{
                while(!ss.isEmpty() && nums[ss.peek()]<=nums[i]){
                    ss.pop();
                }
                if( !ss.isEmpty() ){
                    ans[i] = ss.peek()-i;
                }
                else{
                    ans[i] = 0;
                }
            }
            ss.push(i);
        }
        return ans;
    }
}