class Solution {
    int count = 0;

    public void nQueens(int n, int row,
                        Set<Integer> cols,
                        Set<Integer> leftDiag,
                        Set<Integer> rightDiag) {

        if (row == n) {
            count++;
            return;
        }

        for (int j = 0; j < n; j++) {

            if (!cols.contains(j)
                && !leftDiag.contains(row - j)
                && !rightDiag.contains(row + j)) {

                cols.add(j);
                leftDiag.add(row - j);
                rightDiag.add(row + j);

                nQueens(n, row + 1, cols, leftDiag, rightDiag);

                cols.remove(j);
                leftDiag.remove(row - j);
                rightDiag.remove(row + j);
            }
        }
    }

    public int totalNQueens(int n) {
        nQueens(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return count;
    }
}