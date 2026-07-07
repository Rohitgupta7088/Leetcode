class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int arr[][] = new int[mat.length][2];

        for(int i=0; i<mat.length; i++){
            int sum = 0;
            for(int j=0; j<mat[0].length; j++){
                sum += mat[i][j];
            }
            arr[i][0] = sum;
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b)->Integer.compare(a[0],b[0]));

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = arr[i][1];
        }

        return ans;
    }
}