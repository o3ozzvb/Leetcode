package DevMatching2021;

import java.util.*;

public class ToothBrushSales {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();

        for(int i=0; i<enroll.length; i++) {
            map.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++) {
            String sel = seller[i]; //referral
            int com = amount[i] * 100;
            money.replace(sel, money.get(sel) + com - com/10);

            while(!map.get(sel).equals("-")) {
                com /= 10;
                if(com == 0) break;

                String ref = map.get(sel);

                int tmp = money.get(ref);
                money.replace(ref, tmp + com - com/10);
                sel = ref;
            }

        }

        for(int i=0; i<enroll.length; i++) {
            answer[i] = money.get(enroll[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        ToothBrushSales tbs = new ToothBrushSales();
        int[] answer = tbs.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(answer));
    }
}
