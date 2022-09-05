package KakaoBlind2022;

import java.util.*;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees = {120, 0, 60, 591}; //{180, 5000, 10, 600};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
                //{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        for (int fee : solution(fees, records)) {
            System.out.print(fee + ", ");
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        for (String s : records) {
            String[] record = s.split(" ");
            if (record[2].equals("IN")) {
                map.put(record[1], record[0]); //차량번호, 출입시간
            }
            if (record[2].equals("OUT")) {
                String[] inTime = map.get(record[1]).split(":");
                String[] outTime = record[0].split(":");

                int out = Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1]);
                int in = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);

                int time = timeMap.getOrDefault(record[1], 0) + (out - in);
                timeMap.put(record[1], time);
                map.remove(record[1]);
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            int out = 23 * 60 + 59;
            String[] inTime = entry.getValue().split(":");
            int in = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);
            int time = timeMap.getOrDefault(entry.getKey(), 0) + (out - in);
            timeMap.put(entry.getKey(), time);
        }

        //map 정렬
        List<String> list = new ArrayList<>(timeMap.keySet());
        list.sort((s1, s2) -> s1.compareTo(s2));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String car = list.get(i);
            int time = timeMap.get(car);
            int fee = fees[1]; //기본요금
            if (time > fees[0]) {
                int ceil = (int) Math.ceil((time - fees[0])/ (double) fees[2]);
                fee += (ceil * fees[3]);
            }

            answer[i] = fee;
        }

        return answer;
    }
}
