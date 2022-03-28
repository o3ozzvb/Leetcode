package Programmers.level3;

import java.util.*;

public class Network {

    public int bfs(int[][] computers, int[] visit, int computer) {
        Queue<Integer> q = new LinkedList<>();

        q.add(computer);
        visit[computer] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i=0; i<computers.length; i++) {
                if(computers[cur][i] == 1 && visit[i] == 0) {
                    q.add(i);
                    visit[i] = 1;
                }
            }
        }

        return 1;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visit = new int[n];

        for(int i=0; i<n; i++) {
            if(visit[i] == 0) {
                answer += bfs(computers, visit, i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Network network = new Network();

        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println("network = " + network.solution(n, computers));
    }
}
