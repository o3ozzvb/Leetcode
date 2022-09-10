package KakaoBlind2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SheepAndWolf {

    ArrayList<ArrayList<Integer>> graph;
    int maxSheep = Integer.MIN_VALUE;

    public static void main(String[] args) {
        SheepAndWolf saw = new SheepAndWolf();

        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        System.out.println(saw.solution(info, edges));
    }

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        List<Integer> nextPos = new ArrayList<>();

        makeGraph(info, edges);

        nextPos.add(0);
        dfs(info, nextPos, 0, 0, 0);

        return maxSheep;
    }

    private void dfs(int[] info, List<Integer> nextPos, int idx, int sheep, int wolf) {

        if (info[idx] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> list = new ArrayList<>();
        list.addAll(nextPos);
        list.remove(Integer.valueOf(idx)); //다음 탐색 노드에서 현재 idx 제거
        for (Integer pos : graph.get(idx)) {
            list.add(pos); //자식 노드 추가
        }

        for (Integer pos : list) {
            dfs(info, list, pos, sheep, wolf);
        }
    }

    private void makeGraph(int[] info, int[][] edges) {
        graph = new ArrayList<>();
        for (int i=0; i<info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
    }
}
