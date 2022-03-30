package ohouse;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Test3 {
    int answer = 0;
    Queue<Point> queue = new LinkedList<>();

    public void check(int[][] space, int room, int bath, Queue<Point> queue) {
        int w = space[0].length;
        int h = space.length;
        int empty = w * h - (4 * room + 2 * bath);

        int[][] visit = new int[h][w];
        int[] chkArr = new int[room+bath+1];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean border = false;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int i = p.x;
            int j = p.y;
            if(visit[i][j] == 1) continue;

            visit[i][j] = 1;
            empty--;

            if(i == 0 || i == h-1 || j == 0 || j == w-1) border = true;
            for(int k=0; k<4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                int val = space[nx][ny];
                if(val != 0) {
                    chkArr[val] = 1;
                }
                if(space[nx][ny] == 0) queue.offer(new Point(nx, ny));
            }
        }

        boolean flag = true;
        for(int i=1; i<chkArr.length; i++) {
            if(chkArr[i] == 0) flag = false;
        }
        if(border && flag && empty == 0) {
            answer++;
        }
        return;
    }

    public void setBath(int[][] space, int room, int bath, int x, int y, int curBath) {
        int w = space[0].length;
        int h = space.length;
        boolean flag = false;

        if(curBath > room + bath) {
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    System.out.print(space[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("----------------");
            queue.clear();
            for(int i=x; i<h; i++){
                for(int j=y; j<w; j++){
                    if(space[i][j] == 0) {
                        flag = true;
                        queue.add(new Point(i,j));
                        check(space, room, bath, queue);
                        break;
                    }
                }
                if(flag) break;
            }
            return;
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(space[i][j] != 0) continue;

                //세로
                if((i+1 < h) && (i == 0 || i+1 == h-1 || j == 0) && space[i+1][j] == 0) {
                    space[i][j] = curBath;
                    space[i+1][j] = curBath;
                    setBath(space, room, bath, i, j, curBath+1);
                    space[i][j] = 0;
                    space[i+1][j] = 0;
                }
                //가로
                if((j+1 < w) && (i == 0 || j == 0 || j+1 == w-1) && space[i][j+1] == 0) {
                    space[i][j] = curBath;
                    space[i][j+1] = curBath;
                    setBath(space, room, bath, i, j, curBath+1);
                    space[i][j] = 0;
                    space[i][j+1] = 0;
                }
            }
        }

    }
    public void setRoom(int[][] space, int room, int bath, int x, int y, int curRoom) {
        int w = space[0].length;
        int h = space.length;
        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};

        //System.out.println("curRoom = " + curRoom);

        if(curRoom > room) {
            /*
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    System.out.print(space[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("----------------");

             */
            setBath(space, room, bath, 0, 0,room + 1);
            return;
        }

        for(int i=x; i<h; i++) {
            for(int j=y; j<w; j++) {
                if(space[i][j] != 0) continue;
                int empty = 0;
                boolean border = false;
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    //테두리와 인접한지
                    if(nx == 0 || nx == h-1 || ny == 0 || ny == w-1) border = true;
                    if(space[nx][ny] == 0) empty++;
                }
                if(border && empty == 4) {
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        space[nx][ny] = curRoom;
                    }
                    setRoom(space, room, bath, i, j, curRoom+1);
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        space[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public int solution(int n, int m, int room, int bath) {
        int[][] space = new int[n][m];

        setRoom(space, room, bath,0, 0, 1);

        return answer;
    }

    public static void main(String[] args) {
        int n = 2;//4;
        int m = 3;//5;
        int room = 1;
        int bath = 1;
        
        Test3 test3 = new Test3();
        System.out.println("answer = " + test3.solution(n, m ,room, bath));
    }
}
