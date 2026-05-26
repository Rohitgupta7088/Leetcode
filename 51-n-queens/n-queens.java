class Solution {
    public List<List<String>> solveNQueens(int n){
        char chess[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chess[i][j] = '.';
            }
        }

        List<List<String>> bigll = new ArrayList<>();
        helper(chess, 0, bigll);
        return bigll;
    }

    public void helper(char chess[][], int row, List<List<String>> bigll){
        if(row ==chess.length){
            List<String> ll = new ArrayList<>();
            for(int i=0; i<chess.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<chess[0].length; j++){
                   sb.append(chess[i][j]);
                }
                ll.add(sb.toString());
            }

            bigll.add(ll);

            return;
        }

        for(int j=0; j<chess[0].length; j++){
            if(issafe(chess, row, j)){
                chess[row][j] = 'Q';
                helper(chess, row+1, bigll);
                chess[row][j] = '.';
            }
        }
    }

    public boolean issafe(char chess[][], int row, int col){

        for(int i=row-1; i>=0; i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1; i>=0 && j<chess[0].length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}