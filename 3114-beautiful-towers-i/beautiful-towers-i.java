class Solution {
    long result = 0;
    public long maximumSumOfHeights(int[] heights) {
        int n=heights.length;
        mountainMaxHeight(heights, 0, n);
        return result;
    }

    public void mountainMaxHeight(int heights[], int si, int n){

        if(si>=n){
            return;
        }

        int arr[] = new int[n];
        arr[si] = heights[si];

        for(int i=si-1; i>=0; i--){
            arr[i] = Math.min(heights[i], arr[i+1]);
        }

        for(int i=si+1; i<n; i++){
            arr[i] = Math.min(heights[i], arr[i-1]);
        }

        long temp = 0;
        for(int i=0; i<n; i++){
            temp = temp + (long)(arr[i]);
        }

        result = Math.max(result, temp);

        mountainMaxHeight(heights, si+1, n);
    }
}