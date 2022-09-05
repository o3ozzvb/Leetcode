package KakaoBlind2022;

import java.util.*;

public class ReportResult {

    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"}; //{"muzi", "frodo", "apeach", "neo"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"}; //{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 3;
        for (int x : solution(id_list, report, k)) {
            System.out.print(x + ", ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, List<String>> map = new HashMap<>();

        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        report = set.toArray(new String[0]);

        for (String s : report) {
            String[] splitRpt = s.split(" ");

            List<String> list = map.getOrDefault(splitRpt[1], new ArrayList<>());
            list.add(splitRpt[0]);
            map.put(splitRpt[1], list);
        }

        for (int i = 0; i < id_list.length; i++) {
            List<String> list = map.getOrDefault(id_list[i], new ArrayList<>());
            if (list.size() >= k) {
                for (String s : list) {
                    int idx = Arrays.asList(id_list).indexOf(s);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
