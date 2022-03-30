package Programmers.level3;

import java.util.*;

public class TravelRoute {
    Map<String, ArrayList<String>> map = new HashMap<>();
    ArrayList<String[]> answers = new ArrayList<>();
    Map<String, Integer> countries = new HashMap<>();

    public void dfs(int cnt, int tot, String from, String[] answer, int[][] visit) {

        if(cnt == tot) {
            answers.add(answer.clone());
//            System.out.println("=============");
//            for(String[] routes : answers) {
//                for(String route : routes) {
//                    System.out.print(route + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("=============");
            return;
        }

        ArrayList<String> list = map.get(from);
        if(list == null) return;

        for(int i=0; i<list.size(); i++) {
            String to = list.get(i);
            int fromIdx = countries.get(from);
            int toIdx = countries.get(to);

            if(visit[fromIdx][toIdx] > 0) {
                answer[cnt] = to;
                visit[fromIdx][toIdx]--;
                dfs(cnt + 1, tot, to, answer, visit);
                visit[fromIdx][toIdx]++;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        int[][] visit = new int[tickets.length+1][tickets.length+1];
        int idx = 0;

        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if(!map.containsKey(from)) {
                ArrayList<String> list = new ArrayList<>();
                Boolean[] visited = {false, false};

                list.add(to);
                map.put(from, list);
            } else {
                ArrayList<String> list = map.get(from);
                list.add(to);
                map.replace(from, list);
            }
            if(!countries.containsKey(from)) countries.put(from, idx++);
            if(!countries.containsKey(to)) countries.put(to, idx++);
            visit[countries.get(from)][countries.get(to)]++;
        }

        answer[0] = "ICN";
        dfs(1, tickets.length+1, "ICN", answer, visit);

        Collections.sort(answers, new Comparator<String[]>() {
            @Override
            public int compare(String[] s, String[] t) {
                for(int i=0; i<s.length; i++) {
                    if(s[i].equals(t[i])) continue;
                    else if(s[i].compareTo(t[i]) > 0) return 1;
                    else return -1;
                }
                return 0;
            }
        });

//        System.out.println(answers.get(0));
//        for(String[] routes : answers) {
//            for(String route : routes) {
//                System.out.print(route + " ");
//            }
//            System.out.println();
//        }
        return answers.get(0);
    }

    public static void main(String[] args) {
        TravelRoute tr = new TravelRoute();

        String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
                //{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        //{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};// {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};//
        for(String route : tr.solution(tickets)) {
            System.out.print(route + ", ");
        }
    }
}
