package DevMatching2021;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoNumbers {

    public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {1, 6};
            int[] grade = {6, 6, 5, 4, 3, 2, 1};
            int zeroCnt = 0, winCnt = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for(int x : win_nums) {
                map.put(x, 0);
            }

            for(int x : lottos) {
                if(x == 0) zeroCnt++;
                if(map.containsKey(x)) {
                    map.replace(x, 1);
                    winCnt++;
                }
            }

            answer[0] = grade[winCnt + zeroCnt];
            answer[1] = grade[winCnt];

            return answer;
    }

    public static void main(String[] args) {
        LottoNumbers ln = new LottoNumbers();

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums ={31, 10, 45, 1, 6, 19};
        int[] answer = ln.solution(lottos, win_nums);

        System.out.println("answer = " + Arrays.toString(answer));
    }
}
