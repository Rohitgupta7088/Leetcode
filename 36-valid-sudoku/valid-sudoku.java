class Solution {
    public boolean isValidSudoku(char[][] board) {
        if( sudokovalid(board,0,0) ){
            return true;
        }
        return false;
    }

    public boolean sudokovalid(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }
        int nextrow = row, nextcol = col+1;
        if(col == 8){
            nextrow = row+1;
            nextcol = 0;
        }

        if(board[row][col] == '.'){
            return sudokovalid(board, nextrow, nextcol);
        }

        for(int i=0; i<9; i++){
            if(i != col && board[row][i] == board[row][col]){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(i != row && board[i][col] == board[row][col]){
                return false;
            }
        }

        int startrow = (row/3)*3;
        int startcol = (col/3)*3;
        for(int i=startrow; i<=startrow+2; i++){
            for(int j=startcol; j<=startcol+2; j++){
                if((i != row || j!= col) && board[i][j] == board[row][col]){
                    return false;
                }
            }
        }

        return sudokovalid(board,nextrow,nextcol);
    }
}