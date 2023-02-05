class Solution {
    public int getSum(int a, int b) {
        int x, y;
        if (a > b) {
            x = b;
            y = a;
        } else {
            x = a;
            y = b;
        }

        if (y < 0) {
            for (int i = y; i < 0; i++) {
                x--;
            }

        }
        else {
            for (int i = 0; i < y; i++) {
                x++;
            }
        }
        return x;
    }
}