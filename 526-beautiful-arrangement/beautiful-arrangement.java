class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        List<Integer> ll = new ArrayList<>();
        helper(arr, 0, ll);
        return count;
    }

    public void helper(int nums[], int idx, List<Integer> ll){
        if(nums.length == 0){
            count++;
            return;
        }

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];

            if( !(nums[i]%(idx+1) == 0 || (idx+1)%nums[i] == 0) ){
                continue;
            }

            int arr[] = new int[nums.length-1];
            for(int j=0; j<nums.length; j++){
                if(i==j){
                    continue;
                }
                else if(j<i){
                    arr[j] = nums[j];
                }
                else if(j>i){
                    arr[j-1] = nums[j];
                }
            }

            ll.add(nums[i]);
            helper(arr, idx+1, ll);
            ll.remove(ll.size()-1);
        }
    }
}