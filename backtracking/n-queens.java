class Solution {
    public void nQueens(int n, int row, char[][] board, 
                        Set<Integer> cols, Set<Integer> leftDiag, Set<Integer> rightDiag,
                        List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!cols.contains(j) && !leftDiag.contains(row - j) && !rightDiag.contains(row + j)) {
                board[row][j] = 'Q';
                cols.add(j);
                leftDiag.add(row - j);
                rightDiag.add(row + j);

                nQueens(n, row + 1, board, cols, leftDiag, rightDiag, result);

                board[row][j] = '.';
                cols.remove(j);
                leftDiag.remove(row - j);
                rightDiag.remove(row + j);
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> boardList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boardList.add(new String(board[i]));
        }
        return boardList;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        nQueens(n, 0, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), result);
        return result;
    }
}