class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int row = n;
        int col = 0;

        while(row >= 0 && col < matrix[0].length) {  // Fixed condition
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}