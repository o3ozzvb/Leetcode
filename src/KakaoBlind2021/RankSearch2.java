package KakaoBlind2021;

import java.util.*;

public class RankSearch2 {

    Map<String, List<Integer>> infoMap;

    public static void main(String[] args) {
        RankSearch2 rs = new RankSearch2();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        int[] answer = rs.solution(info, query);
        for (int i : answer) {
            System.out.print(i + ", ");
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        infoMap = new HashMap<>();

        for (String s : info) {
            String[] sInfo = s.split(" ");
            getCasesInfo(sInfo, "", 0);
        }

        for (String s : infoMap.keySet()) {
            Collections.sort(infoMap.get(s));
        }

        for (int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] sQuery = query[i].split(" "); // query score

            if (infoMap.containsKey(sQuery[0])) {
                answer[i] = binarySearch(sQuery[0], Integer.parseInt(sQuery[1]));
            }
        }
        return answer;
    }

    //Info 의 모든 경우의 수 Map에 담기
    private void getCasesInfo(String[] s, String str, int idx) {
        if (idx == 4) {
            if (!infoMap.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                infoMap.put(str, list);
            }
            infoMap.get(str).add(Integer.parseInt(s[4]));
            return;
        }

        getCasesInfo(s, str + "-", idx+1);
        getCasesInfo(s, str + s[idx], idx+1);
    }

    private int binarySearch(String key, int score) {
        List<Integer> list = infoMap.get(key);

        int left = 0, right = list.size() - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return list.size() - left;
    }
}
