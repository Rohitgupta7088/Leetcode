class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            if(!helper(arr2, 0, arr2.length-1, arr1[i], d)){
                count++;
            }
        }
        return count;
    }

    public boolean helper(int arr2[], int si, int ei, int val, int d){

        while(si<=ei){
            int mid = si+(ei-si)/2;
            int tempdis = Math.abs(val-arr2[mid]);
            if(tempdis<=d){
                return true;
            }

            if(arr2[mid]<val){
                si=mid+1;
            }
            else{
                ei = mid-1;
            }
        }

        return false;
    }
}