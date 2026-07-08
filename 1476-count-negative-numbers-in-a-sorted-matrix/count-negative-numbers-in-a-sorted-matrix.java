class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int lastidx = -1;
        for(int i=0; i<grid.length; i++){
            int idx = -1;
            if(lastidx == -1){
                idx = helper(grid[i], 0, grid[0].length-1);
                if(idx != -1){
                    count += ((grid[0].length-idx)*(grid.length-i));
                    lastidx = idx;
                }
            }
            else{
                idx = helper(grid[i], 0, lastidx-1);
                if(idx != -1){
                    count += ((lastidx-idx)*(grid.length-i));
                    lastidx = idx;
                }
            }
        }

        return count;
    }

    public int helper(int arr[], int si, int ei){
        if(si>ei){
            return -1;
        }

        int mid = si+(ei-si)/2;

        if(mid == 0){
            if(arr[mid]<0){
                return mid;
            }
            else{
                return helper(arr, mid+1, ei);
            }
        }

        if(arr[mid]<0 && arr[mid-1]>=0){
            return mid;
        }

        if(arr[mid]>=0){
            return helper(arr, mid+1, ei);
        }
        else{
            return helper(arr, si, mid-1);
        }
    }
}