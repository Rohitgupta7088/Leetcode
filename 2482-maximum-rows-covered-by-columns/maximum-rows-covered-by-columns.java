class Solution {
    int count = 0;
    public int maximumRows(int[][] matrix, int numSelect) {
        List<Integer> ll = new ArrayList<>();
        helper(matrix, 0, matrix[0].length, ll, numSelect);
        return count;
    }

    public void helper(int matrix[][], int col, int maxcol, List<Integer> ll, int numSelect){
        if(ll.size() == numSelect){
            count = Math.max(count, calculate(ll, matrix, 0, 0));
            return;
        }

        if(col >= maxcol){
            return;
        }

        ll.add(col);
        helper(matrix, col+1, maxcol, ll, numSelect);
        ll.remove(ll.size()-1);
        helper(matrix, col+1, maxcol, ll, numSelect);
    }

    public int calculate(List<Integer> ll, int matrix[][], int row, int tempcount){

        if(row >= matrix.length){
            return tempcount;
        }

        
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[row][j] == 1 && !ll.contains(j)){
                return calculate(ll, matrix, row+1, tempcount);
            }
        }

        return calculate(ll, matrix, row+1, tempcount+1);
    }
}