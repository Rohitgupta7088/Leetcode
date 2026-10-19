// class Solution {
//     int count = 0;
//     public int uniquePaths(int m, int n) {
//         int move[][] = { {1, 0}, {0, 1} };
//         helper(0, 0, move, m, n);
//         return count;
//     }

//     public void helper(int row, int col, int move[][], int m, int n){
//         if(row == m-1 && col == n-1){
//             count++;
//             return;
//         }

//         for(int i=0; i<2; i++){
//             int newrow = row+move[i][0];
//             int newcol = col+move[i][1];

//             if(newrow >= m || newcol >= n){
//                 continue;
//             }

//             helper(newrow, newcol, move, m, n);
//         }
//     }
// }





class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1){
            return 1;
        }
        int move[][] = { {1, 0}, {0, 1} };
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        helper(0, 0, move, dp, m, n);
        return dp[0][0];
    }

    public int helper(int row, int col, int move[][], int dp[][], int m, int n){
        if(row == m-1 && col == n-1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        dp[row][col] = 0;

        for(int i=0; i<2; i++){
            int newrow = row+move[i][0];
            int newcol = col+move[i][1];

            if(newrow >= m || newcol >= n){
                continue;
            }

            dp[row][col] += helper(newrow, newcol, move, dp, m, n);
        }

        return dp[row][col];
    }
}