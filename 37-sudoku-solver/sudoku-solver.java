class Solution {
    public void solveSudoku(char[][] board){
        if(sudokosolver(board, 0 ,0)){
            print(board);
        }
    }

    public boolean sudokosolver(char[][] sudoko, int row, int col){
        if(row == 9){
            return true;
        }

        int nextrow = row, nextcol = col+1;

        if(col+1 == 9){
            nextrow = row+1;
            nextcol = 0;
        }

        if(sudoko[row][col] != '.'){
            return sudokosolver(sudoko, nextrow, nextcol);
        }

        for(int digit=1; digit<=9; digit++){
            if(issafe(sudoko,row,col,digit)){
                sudoko[row][col] = (char)(digit + '0');
                if(sudokosolver(sudoko,nextrow,nextcol)){
                    return true;
                }
                sudoko[row][col] = '.';
            }
        }

        return false;
    }

    public boolean issafe(char[][] sudoko, int row, int col, int digit){
        for(int i=0; i<9; i++){
            if(sudoko[i][col] == (char)(digit + '0')){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(sudoko[row][i] == (char)(digit + '0')){
                return false;
            }
        }

        int startrow = (row/3)*3;
        int startcol = (col/3)*3;
        for(int i=startrow; i<=startrow+2; i++){
            for(int j=startcol; j<=startcol+2; j++){
                if(sudoko[i][j] == (char)(digit + '0')){
                    return false;
                }
            }
        }

        return true;
    }

    public void print(char[][] sudoko){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoko[i][j]+" ");
            }
            System.out.println();
        }
    }
}