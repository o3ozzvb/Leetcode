package Programmers.level3;

import java.util.Arrays;

public class Immigration {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0, right = (long)times[times.length-1] * n;
        long answer = right;

        while(left <= right) {
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);
            long cnt = 0;
            long mid = (left + right) / 2;
            for(int i=0; i<times.length; i++) {
                cnt += mid / times[i];
            }
//            System.out.println("cnt = " + cnt);
//            System.out.println("mid = " + mid);
            if(cnt < n) {
                left = mid+1;
            } else {
                right = mid-1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Immigration im = new Immigration();
        int n = 2;
        int[] times = {1, 2, 2, 2, 2, 100};

        System.out.println("answer = " + im.solution(n, times));
    }
}
