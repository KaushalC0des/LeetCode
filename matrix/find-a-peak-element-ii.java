class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;// this counts no of colls in matrix
        
        int left = 0;
        int right = cols - 1;
        
        while (left <= right) {
            int midCol = left + (right - left) / 2;
            
            // Find the row with the maximum element in midCol
            int maxRow = 0;
            for (int row = 0; row < rows; row++) {
                if (mat[row][midCol] > mat[maxRow][midCol]) {
                    maxRow = row;
                }
            }
            
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightVal = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;
            
            if (mat[maxRow][midCol] >= leftVal && mat[maxRow][midCol] >= rightVal) {
                return new int[] { maxRow, midCol };
            } else if (leftVal > mat[maxRow][midCol]) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }
        
        return new int[] { -1, -1 }; // Should not reach here
    }
}
