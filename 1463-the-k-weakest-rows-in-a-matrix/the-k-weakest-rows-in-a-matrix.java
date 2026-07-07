class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int arr[][] = new int[mat.length][2];

        for(int i=0; i<mat.length; i++){
            arr[i][0] = helpercount(mat[i], 0, mat[0].length-1);
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b)->Integer.compare(a[0],b[0]));

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = arr[i][1];
        }

        return ans;
    }

    public int helpercount(int matrow[], int si, int ei){
        if(si>ei){
            return si;
        }

        int mid = si+(ei-si)/2;

        if(matrow[mid] == 1){
            return helpercount(matrow, mid+1, ei);
        }
        else{
            return helpercount(matrow, si, mid-1);
        }
    }
}