class Solution {
    // public int kthSmallest(int[][] matrix, int k){
    //     List<Integer> ll = new ArrayList<>();

    //     for(int i=0; i<matrix[0].length; i++){
    //         ll.add(matrix[0][i]);
    //     }
    //     helper(matrix, 1, ll);

    //     return ll.get(k-1);
    // }

    // public void helper(int matrix[][], int row, List<Integer> ll){
    //     if(row >= matrix.length){
    //         return;
    //     }

    //     int i=0;
    //     int j=0;

    //     List<Integer> sorted = new ArrayList<>();
    //     while(i < matrix[row].length && j<ll.size()){
    //         if(ll.get(j) <= matrix[row][i]){
    //             sorted.add(ll.get(j));
    //             j++;
    //         }
    //         else{
    //             sorted.add(matrix[row][i]);
    //             i++;
    //         }
    //     }

    //     while(i < matrix[row].length){
    //         sorted.add(matrix[row][i++]);
    //     }

    //     while(j<ll.size()){
    //         sorted.add(ll.get(j++));
    //     }

    //     ll.clear();
    //     ll.addAll(sorted);

    //     helper(matrix, row+1, ll);
    // }


    // 2nd Method

    public int kthSmallest(int[][] matrix, int k){
        int n=matrix.length;
        int m=matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        int res = -1;

        while(low <= high){
            int guess = (low+high)/2;
            int count = helper(matrix, n, m, guess);
            if(count < k){
                low = guess+1;
            }
            else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }

    public int helper(int matrix[][], int n, int m, int guess){
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row>=0 && col<m){
            if(matrix[row][col] <= guess){
                count = count + row +1;
                col++;
            }
            else{
                row--;
            }
        }

        return count;
    }
}