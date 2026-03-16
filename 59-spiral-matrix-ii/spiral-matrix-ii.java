class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int row1 = 0;
        int row2 = n-1;
        int col1 = n-1;
        int col2 = 0;

        int a=1;

        while(row1 <= row2 && col1 >= col2 && a<=n*n){
            for(int i=col2; i<=col1; i++){
                arr[row1][i] = a;
                a++;
            }
            row1++;

            for(int i=row1; i<=row2; i++){
                arr[i][col1] = a;
                a++;
            }
            col1--;

            if(row1<row2 && col1>col2){
                for(int i=col1; i>=col2; i--){
                    arr[row2][i] = a;
                    a++;
                }
                row2--;

                for(int i=row2; i>=row1; i--){
                    arr[i][col2] = a;
                    a++;
                }
                col2++;
            }
        }

        return arr;
    }
}