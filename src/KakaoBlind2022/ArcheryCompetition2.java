package KakaoBlind2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArcheryCompetition2 {
    private final int N = 11;
    int maxValue = Integer.MIN_VALUE;
    int[] answer = {-1};

    public static void main(String[] args) {
        ArcheryCompetition2 ac = new ArcheryCompetition2();

        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        //{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        //{0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0}; //{0,0,0,0,0,0,0,0,3,4,3};
        ////{1,0,0,0,0,0,0,0,0,0,0}; //{2,1,1,1,0,0,0,0,0,0,0};
        int[] answer = ac.solution(n, info);

        for (int i : answer) {
            System.out.print(i + ", ");
        }
    }

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[N];
        dfs(0, n, ryan, info);

        return answer;
    }

    public void dfs(int idx, int arrow, int[] ryan, int[] info) {
        if (idx == N || arrow == 0) {
            //남은 화살은 모두 0점 과녁
            ryan[N-1] += arrow;
            calcScore(ryan, info);
            ryan[N-1] -= arrow;
            return;
        }

        // 어피치의 점수가 남은 화살 수 보다 작다면 점수 얻기
        if (info[idx] < arrow) {
            ryan[idx] += (info[idx] + 1);
            dfs(idx+1, arrow-(info[idx]+1), ryan, info);
            ryan[idx] -= (info[idx] + 1);
        }

        // 점수 얻지 않을 경우
        dfs(idx+1, arrow, ryan, info);
    }

    private void calcScore(int[] ryan, int[] info) {
        int ryanScore = 0, apeachScore = 0;
        for (int i=0; i<N; i++) {
            if (info[i] >= ryan[i] && info[i] > 0) {
                apeachScore += 10-i;
            } else if (ryan[i] > 0) {
                ryanScore += 10-i;
            }
        }

        int diff = ryanScore - apeachScore;
        if (diff > 0 && diff >= maxValue) {
            if (diff == maxValue && !isBetter(ryan)) return;

            maxValue = diff;
            answer = Arrays.copyOf(ryan, N);
        }
    }

    private boolean isBetter(int[] ryan) {
        for (int i=10; i>=0; i--) {
            if (ryan[i] > answer[i]) return true;
            else if (ryan[i] < answer[i]) return false;
        }
        return false;
    }
}
