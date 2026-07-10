class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length-1];

        int prefixsum[] = new int[arr.length+1];
        prefixsum[0] = 0;

        for(int i=0; i<arr.length; i++){
            prefixsum[i+1] = prefixsum[i]+arr[i];
        }

        int dis = Integer.MAX_VALUE;
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;

            int idx = helper(arr, 0, arr.length-1, mid);

            int sum = prefixsum[idx]+(arr.length-idx)*mid;

            int tempdiff =  Math.abs(sum-target);

            if(tempdiff == 0){
                return mid;
            }

            if(dis>tempdiff){
                ans = mid;
                dis = tempdiff;
            }

            if(dis == tempdiff && mid<=ans){
                ans = mid;
            }
            
            if(sum<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return ans;
    }

    public int helper(int arr[], int si, int ei, int target){
        if(si>ei){
            return si;
        }

        int mid = si+(ei-si)/2;

        if(arr[mid]<=target){
            return helper(arr, mid+1, ei, target);
        }
        else{
            return helper(arr, si, mid-1, target);
        }
    }
}