class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row1 = 0;
        int col1 = matrix[0].length-1;
        int row2 = matrix.length-1;
        int col2 = 0;

        List<Integer> ll = new ArrayList<>();

        while(row1<=row2 && col2<=col1){

            for(int i=col2; i<=col1; i++){
                ll.add(matrix[row1][i]);
            }
            row1++;

            for(int i=row1; i<=row2; i++){
                ll.add(matrix[i][col1]);
            }
            col1--;

            if(row1<=row2){
                for(int i=col1; i>=col2; i--){
                    ll.add(matrix[row2][i]);
                }
                row2--;
            }
            
            if(col2<=col1){
                for(int i=row2; i>=row1; i--){
                    ll.add(matrix[i][col2]);
                }
                col2++;
            }
        }

        return ll;
    }
}