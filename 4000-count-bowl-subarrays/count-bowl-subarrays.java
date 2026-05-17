class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> ss = new Stack<>();

        int leftmax[] = new int[n];
        for(int i=0; i<n; i++){
            while(!ss.isEmpty() && nums[ss.peek()]<=nums[i]){
                ss.pop();
            }
            leftmax[i] = ss.isEmpty() ? -1 : ss.peek();
            ss.push(i);
        }

        ss.clear();

        int rightmax[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!ss.isEmpty() && nums[ss.peek()]<=nums[i]){
                ss.pop();
            }
            rightmax[i] = ss.isEmpty() ? n : ss.peek();
            ss.push(i);
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            if(leftmax[i] != -1 && rightmax[i] != n){
                ans++;
            }
        }

        return ans;
    }
}