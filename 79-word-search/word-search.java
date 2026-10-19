class Solution {
    public boolean exist(char[][] board, String word) {
        int move[][] = { {1,0}, {0,1}, {-1,0}, {0,-1} };
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && helper(i, j, m, n, board, word, 0, move)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int row, int col, int m, int n, char board[][], String word, int k, int move[][]){

        if(board[row][col] != word.charAt(k)){
            return false;
        }

        if(k == word.length()-1){
            return true;
        }

        boolean found = false;
        char ch = board[row][col];
        board[row][col] = '#';

        for(int i=0; i<move.length; i++){
            int newrow = row+move[i][0];
            int newcol = col+move[i][1];

            if(newrow>=m || newcol>=n || newrow<0 || newcol<0){
                continue;
            }

            if(board[newrow][newcol] != '#' && helper(newrow, newcol, m, n, board, word, k+1, move)){
                found = true;
            }
        }

        board[row][col] = ch;
        return found;
    }
}