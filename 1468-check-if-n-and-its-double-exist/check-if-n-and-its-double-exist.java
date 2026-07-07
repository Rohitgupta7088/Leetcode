class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]>=0){
                if(helper(arr, 0, i-1, arr[i])){
                    return true;
                }
            }
            else{
                if(helper(arr, i+1, arr.length-1, arr[i])){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int arr[], int si, int ei, int target){
        if(si>ei){
            return false;
        }

        int mid=si+(ei-si)/2;

        if((long)2*arr[mid] == (long)target){
            return true;
        }

        if((long)2*arr[mid] < (long)target){
            return helper(arr, mid+1, ei, target);
        }
        else{
            return helper(arr, si, mid-1, target);
        }
    }
}