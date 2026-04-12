class Solution {
    public int kthSmallest(int[][] matrix, int k){
        List<Integer> ll = new ArrayList<>();

        for(int i=0; i<matrix[0].length; i++){
            ll.add(matrix[0][i]);
        }
        helper(matrix, 1, ll);

        return ll.get(k-1);
    }

    public void helper(int matrix[][], int row, List<Integer> ll){
        if(row >= matrix.length){
            return;
        }

        int i=0;
        int j=0;

        List<Integer> sorted = new ArrayList<>();
        while(i < matrix[row].length && j<ll.size()){
            if(ll.get(j) <= matrix[row][i]){
                sorted.add(ll.get(j));
                j++;
            }
            else{
                sorted.add(matrix[row][i]);
                i++;
            }
        }

        while(i < matrix[row].length){
            sorted.add(matrix[row][i++]);
        }
        while(j<ll.size()){
            sorted.add(ll.get(j++));
        }
        ll.clear();
        ll.addAll(sorted);

        helper(matrix, row+1, ll);
    }
}