class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( helper(board, word, i, j, m, n, 0) ){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int m, int n, int k){
        if( i<0 || j<0 || i>=m || j>=n || board[i][j] != word.charAt(k)){
            return false;
        }

        if(k == word.length()-1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = helper(board, word, i+1, j, m, n, k+1) ||
                        helper(board, word, i, j+1, m, n, k+1) ||
                        helper(board, word, i-1, j, m, n, k+1) ||
                        helper(board, word, i, j-1, m, n, k+1);

        board[i][j] = temp;
         return found;
    }
}