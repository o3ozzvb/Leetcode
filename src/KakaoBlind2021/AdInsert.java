package KakaoBlind2021;

import java.util.*;

public class AdInsert {

    int[] video;

    public static void main(String[] args) {
        AdInsert ai = new AdInsert();
        String play_time = "02:03:55", adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(ai.solution(play_time, adv_time, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int n = parseSecond(play_time);
        video = new int[n + 1];
        String answer = "00:00:00";

        if (play_time.equals(adv_time)) {
            return answer;
        }

        AnalyzeLog(logs);
        int advStart = getAdvStart(adv_time, n);

        answer = parseTimeFormat(advStart);
        return answer;
    }

    private int getAdvStart(String adv_time, int n) {
        int adv = parseSecond(adv_time);
        long maxSum = 0, sum = 0;
        int advStart = 0;
        for (int i = 0; i < adv; i++) {
            sum += video[i];
        }
        maxSum = sum;

        for (int i = adv; i<=n; i++) {
            sum += video[i] - video[i-adv];

            if (sum > maxSum) {
                maxSum = sum;
                advStart = i-adv+1;
            }
        }
        return advStart;
    }

    private void AnalyzeLog(String[] logs) {
        for (String log : logs) {
            String[] splitLog = log.split("-");

            int start = parseSecond(splitLog[0]);
            int end = parseSecond(splitLog[1]);

            for (int i=start; i<end; i++) {
                video[i]++;
            }
        }

        return;
    }

    private String parseTimeFormat(int key) {
        int s = key % 60;
        key /= 60;
        int m = key % 60;
        key /= 60;
        int h = key;

        String time = h < 10 ? "0" + String.valueOf(h) : String.valueOf(h);
        time += ":";
        time += m < 10 ? "0" + String.valueOf(m) : String.valueOf(m);
        time += ":";
        time += s < 10 ? "0" + String.valueOf(s) : String.valueOf(s);

        return time;
    }

    private int parseSecond(String time) {
        String[] sTime = time.split(":");
        int h = Integer.parseInt(sTime[0]);
        int m = Integer.parseInt(sTime[1]);
        int s = Integer.parseInt(sTime[2]);

        return h * 3600 + m * 60 + s;
    }
}
