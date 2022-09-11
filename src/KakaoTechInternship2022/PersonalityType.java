package KakaoTechInternship2022;

import java.util.HashMap;
import java.util.Map;

public class PersonalityType {

    int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
    Character[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        PersonalityType pt = new PersonalityType();

        String[] survey = {"TR", "RT", "TR"}; //{"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {7, 1, 3}; //{5, 3, 2, 7, 5};
        System.out.println(pt.solution(survey, choices));
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (Character type : types) {
            map.put(type, 0);
        }

        for (int i = 0; i < choices.length; i++) {
            char type;
            int idx = choices[i];
            if (idx < 4) {
                type = survey[i].charAt(0);
                map.replace(type, map.get(type)+score[idx]);
            }
            if (idx > 4) {
                type = survey[i].charAt(1);
                map.replace(type, map.get(type)+score[idx]);
            }
        }

        answer = getType();
        return answer;
    }

    private String getType() {
        String personality = "";

        for (int i=0; i<4; i++) {
            int idx = 2 * i;
            int scoreA = map.get(types[idx]);
            int scoreB = map.get(types[idx+1]);

            if (scoreA >= scoreB) {
                personality += (char) types[idx];
            } else {
                personality += (char) types[idx+1];
            }
        }

        return personality;
    }
}
