class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> zerorow = new ArrayList<>();
        List<Integer> zerocol = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zerorow.add(i);
                    zerocol.add(j);
                }
            }
        }

        for(int i=0; i<zerocol.size(); i++){
           for(int j=0; j<matrix.length; j++){
            matrix[j][zerocol.get(i)] = 0;
           }
        }

        for(int i=0; i<zerorow.size(); i++){
           for(int j=0; j<matrix[0].length; j++){
            matrix[zerorow.get(i)][j] = 0;
           }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}