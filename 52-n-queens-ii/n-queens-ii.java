class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char chess[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chess[i][j] = '.';
            }
        }
        helper(chess, 0);
        return count;
    }

    public void helper(char chess[][], int row){
        if(row >= chess.length){
            count++;
            return;
        }

        for(int i=0; i<chess.length; i++){
            if(issafe(chess, row, i)){
                chess[row][i] = 'Q';
                helper(chess, row+1);
                chess[row][i] = '.';
            }
        }
    }

    public boolean issafe(char chess[][], int row, int col){
        for(int i=row-1; i>=0; i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<chess[0].length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}