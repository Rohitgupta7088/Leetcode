class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> List = new ArrayList<>();

        int row1 = 0;
        int row2 = matrix.length-1;
        int col1 = matrix[0].length-1;
        int col2 = 0;

        while(row1 <= row2 && col1 >= col2){
            for(int i=col2; i<=col1; i++){
                List.add(matrix[row1][i]);
            }
            row1++;

            for(int i=row1; i<=row2; i++){
                List.add(matrix[i][col1]);
            }
            col1--;

            if(row2 >= row1){
                for(int i=col1; i>=col2; i--){
                List.add(matrix[row2][i]);
                }
                row2--;
            }

            if(col1 >= col2){
                for(int i=row2; i>=row1; i--){
                List.add(matrix[i][col2]);
                }
                col2++;
            }
        }

        return List;
    }
}