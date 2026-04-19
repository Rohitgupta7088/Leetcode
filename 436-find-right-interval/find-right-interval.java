class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            int index = -1;
            int minstart = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                int a[] = intervals[i];
                int b[] = intervals[j];

                if(right(a,b)){
                    if(b[0] < minstart || (b[0] == minstart && j < index)){
                        minstart = b[0];
                        index = j;
                    }
                }
            }
            arr[i] = index;
        }
        return arr;
    }

    public boolean right(int arr1[], int arr2[]){
        if(arr2[0] >= arr1[1]){
            return true;
        }
        return false;
    }
}