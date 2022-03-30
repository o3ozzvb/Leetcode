package ohouse;

import java.util.Arrays;

public class Test1 {
    public int solution(String[][] rounds) {
        int answer = 0;
        String[] participant = {"a", "b", "c", "d"};
        String[] couple = new String[4];
        Arrays.fill(couple, "");

        for(String[] round : rounds) {
            for(int i=0; i<4; i++) {
                //if(!couple[i].equals("")) continue;
                if(round[i].equals(participant[i]) || round[i].equals(couple[i])) {
                    answer++;
                    couple[i] = "";
                }
                else {
                    String choice = round[i];
                    int idx = 0;
                    if(choice.equals("a")) idx = 0;
                    else if(choice.equals("b")) idx = 1;
                    else if(choice.equals("c")) idx = 2;
                    else if(choice.equals("d")) idx = 3;

                    if(round[idx].equals(participant[i])) {
                        couple[i] = round[i];
                        //couple[idx] = participant[i];
                    } else {
                        couple[i] = "";
                    }
                }
            }
            System.out.println("couple = " + Arrays.toString(couple));
        }

        return answer;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        String[][] rounds = {{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}};
        System.out.println("answer = " + test1.solution(rounds));
    }
}
