class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(n==1 && m==1 && matrix[0][0] == target){
            return true;
        }

        return helper(matrix, 0, matrix[0].length-1, target);
    }

    public boolean helper(int nums[][],int i, int j, int target){
        if(i>=nums.length || j<0){
            return false;
        }
        if(nums[i][j] == target){
            return true;
        }
        else if(nums[i][j]<target){
            return helper(nums, i+1, j, target);
        }
        else if(nums[i][j]>target){
            return helper(nums, i, j-1, target);
        }
        return false;
    }
}