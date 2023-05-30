package Kakao2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validation {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        List<Integer> answerList = new ArrayList<>();

        int[] todayDate = makeDateArr(today);
        Map<String, int[]> termsMap = new HashMap<>();

        for (String s : terms) {
            String[] term = s.split(" ");
            termsMap.put(term[0], calExpireDate(todayDate, Integer.parseInt(term[1])));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            int[] startDate = makeDateArr(privacy[0]);
            int[] expireDate = termsMap.get(privacy[1]);

            if (isExpired(startDate, expireDate)) {
                answerList.add(i + 1);
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public int[] makeDateArr(String date) {
        int[] dateArr = new int[3];
        int idx = 0;

        for (String s : date.split("\\.")) {
            dateArr[idx++] = Integer.parseInt(s);
        }
        return dateArr;
    }

    public int[] calExpireDate(int[] today, int term) {
        int year = today[0];
        int mon = today[1];
        int day = today[2];

        year -= term / 12;
        mon -= term % 12;
        if (day < 1) {
            day += 28;
            mon -= 1;
        }
        if (mon < 1) {
            mon += 12;
            year -= 1;
        }
        int[] expireDate = {year, mon, day};

        return expireDate;
    }

    public boolean isExpired(int[] startDate, int[] expireDate) {
        if (startDate[0] > expireDate[0]) return false;
        if (startDate[0] == expireDate[0]) {
            if (startDate[1] > expireDate[1]) return false;
            else if (startDate[1] == expireDate[1]) {
                return startDate[2] <= expireDate[2];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Validation v = new Validation();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] answer = v.solution(today, terms, privacies);

    }
}
