package KakaoBlind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SharedTaxFare {
    List<ArrayList<Path>> graph;
    int[] distS, distA, distB;

    public static void main(String[] args) {
        SharedTaxFare stf = new SharedTaxFare();

        int n = 6, s = 4, a = 6, b = 2;
        int[][] fare = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(stf.solution(n, s, a, b, fare));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        initGraph(n, fares);
        initDistArr(n);

        distS = dijkstra(s, distS);
        distA = dijkstra(a, distA);
        distB = dijkstra(b, distB);

       /* for (int dist : distS) {
            System.out.print(dist + ", ");
        }
        System.out.println();
        for (int dist : distA) {
            System.out.print(dist + ", ");
        }
        System.out.println();
        for (int dist : distB) {
            System.out.print(dist + ", ");
        }*/

        answer = distS[a] + distS[b]; // S -> A + S -> B
        for(int i=1; i<distS.length; i++)
            answer = Math.min(answer,(distS[i]+distA[i]+distB[i]));

        return answer;
    }

    private int[] dijkstra(int s, int[] dist) {
        dist[s] = 0;
        PriorityQueue<Path> pq = new PriorityQueue<Path>();
        pq.add(new Path(s, 0));

        while (!pq.isEmpty()) {
            Path now = pq.poll();
            for (Path next : graph.get(now.i)) {
//                System.out.println("next = " + next.i + ", " + next.v);
                if (dist[next.i] > now.v + next.v) {
                    dist[next.i] = now.v + next.v;
//                    System.out.println("(now.v + next.v) = " + (now.v + next.v));
                    pq.add(new Path(next.i, dist[next.i]));
//                    System.out.println(next.i + ", " + dist[next.i]);
                }
            }
        }

        return dist;
    }

    private void initDistArr(int n) {
        distS = new int[n+1];
        distA = new int[n+1];
        distB = new int[n+1];

        Arrays.fill(distS, Integer.MAX_VALUE);
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
    }

    private void initGraph(int n, int[][] fares) {
        graph = new ArrayList<>(n+1);
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Path>());
        }

        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];

            graph.get(c).add(new Path(d, f));
            graph.get(d).add(new Path(c, f));
        }
    }
}

class Path implements Comparable<Path> {
    int i;
    int v;

    public Path(int i, int v) {
        this.i = i;
        this.v = v;
    }

    @Override
    public int compareTo(Path o) {
        return this.v - o.v; //오름차순 (가중치 작은 게 앞)
    }
}
