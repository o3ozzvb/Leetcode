package DevMatching2021;

import java.util.Arrays;

public class BorderRotation {

    int[][] arr;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int rotate(int row, int col, int[] query) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int x = x1, y = y1;
        int tmp = arr[x][y];
        int answer = tmp;
        for(int dir=0; dir<4; dir++) {
            int cnt;
            if(dir == 1 || dir == 3) {
                cnt = x2 - x1;
            } else {
                cnt = y2 - y1;
            }

            for(int i=0; i<cnt; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int tmp2 = arr[nx][ny];
                arr[nx][ny] = tmp;
                tmp = tmp2;

                answer = Math.min(tmp, answer);
                x = nx;
                y = ny;
            }
        }
        return answer;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        arr = new int[rows+1][columns+1];

        int num = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                arr[i][j] = num++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(rows, columns, queries[i]);

        }

        return answer;
    }

    public static void main(String[] args) {
        BorderRotation br = new BorderRotation();

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] answer = br.solution(rows, columns, queries);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}

