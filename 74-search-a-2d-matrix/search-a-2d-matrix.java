class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = helperrow(matrix, 0, matrix.length-1, target);
        if(row == -1){
            return false;
        }
        return helperfind(matrix, 0, matrix[0].length-1, row, target);
    }

    public int helperrow(int matrix[][], int si, int ei, int target){
        if(si > ei){
            return ei;
        }

        int mid = si+(ei-si)/2;

        if(matrix[mid][0] == target){
            return mid;
        }

        if(matrix[mid][0]<target){
            return helperrow(matrix, mid+1, ei, target);
        }
        else{
            return helperrow(matrix, si, mid-1, target);
        }
    }

    public boolean helperfind(int matrix[][], int si, int ei, int idx, int target){
        if(si>ei){
            return false;
        }

        int mid = si+(ei-si)/2;

        if(matrix[idx][mid] == target){
            return true;
        }

        if(matrix[idx][mid]<target){
            return helperfind(matrix, mid+1, ei, idx, target);
        }
        else{
            return helperfind(matrix, si, mid-1, idx, target);
        }
    }
}