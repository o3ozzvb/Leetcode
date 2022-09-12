package KakaoTechInternship2022;

import java.util.ArrayList;
import java.util.List;

public class TwoQueue2 {

    int[] queue;
    int size = 0;
    int max1 = 0, max2 = 0;
    long sum1 = 0, sum2 = 0;
    int answer = Integer.MAX_VALUE;


    public static void main(String[] args) {
        TwoQueue2 tq = new TwoQueue2();
        int[] queue1 = {3, 2, 7, 2};//{1,1};//{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 }; //{1, 2, 1, 2}; //{3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};//{1,5};//{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }; //{1, 10, 1, 2}; //{4, 6, 5, 1};
        System.out.println(tq.solution(queue1, queue2));
    }

    public int solution(int[] queue1, int[] queue2) {
        size = queue1.length;
        int idx1 = 0, idx2 = size, cnt = 0;

        initQueue(queue1, queue2);

        //처음부터 두 큐의 합이 같으면 리턴
        if (sum1 == sum2) return 0;
        //불가능한 경우
        if (max1 > (sum1 + sum2)/2 || max2 > (sum1 + sum2)/2) return -1;

        answer = getMinCount(idx1, idx2, cnt);

        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    private int getMinCount(int idx1, int idx2, int cnt) {
        while (sum1 != sum2) {
            int x = 0;
            if (sum1 > sum2) {
                x= queue[idx1++];
                sum1 -= x;
                sum2 += x;
                if (idx1 == size*2) idx1 = 0;
            } else if (sum2 > sum1) {
                x= queue[idx2++];
                sum1 += x;
                sum2 -= x;
                if (idx2 == size*2) idx2 = 0;
            }
            cnt++;
            if (sum1 == sum2) {
                answer = Math.min(answer, cnt);
            }
            if (cnt == size * 3) return -1;
        }
        return answer;
    }

    private void initQueue(int[] queue1, int[] queue2) {
        queue = new int[size * 2];
        for (int i = 0; i < size; i++) {
            queue[i] = queue1[i];
            sum1 += queue1[i];
        }
        for (int i = 0; i < size; i++) {
            queue[queue1.length + i] = queue2[i];
            sum2 += queue2[i];
        }
    }
}
