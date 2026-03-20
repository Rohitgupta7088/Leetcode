class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            arr[i][j] = -1;
            }
        }
        return helper(0,0,m,n,arr);
    }
    public int helper(int i, int j, int m, int n, int arr[][]){
        if(i == m-1 && j == n-1){
            return 1;
        }
        else if(i > m-1 || j > n-1){
            return 0;
        }

        if(arr[i][j] != -1){
            return arr[i][j];
        }
        int row = helper(i+1, j, m, n, arr);
        int col = helper(i, j+1, m, n, arr);
        
        arr[i][j] = row + col;
        return arr[i][j];
    }
}