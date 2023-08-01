class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] col = new int[10];
            int[] row = new int[10];

            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int idxC = board[j][i] - '0';
                    col[idxC]++;
                    if (col[idxC] > 1) return false;
                }
                if (board[i][j] != '.') {
                    int idxR = board[i][j] - '0';
                    row[idxR]++;
                    if (row[idxR] > 1) return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] area = new int[10];
            int x = i % 3;
            int y = i / 3;
            for (int j = 0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    if (board[3*x+j][3*y+k] != '.') {
                        int idx = board[3*x+j][3*y+k] - '0';
                        area[idx]++;
                        if(area[idx] > 1) return false;
                    }
                }
            }
        }

        return true;
    }
}