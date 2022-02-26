package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Top implements Comparable<Top>{
    int s;
    int h;
    int w;

    public Top(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Top o) {
        return o.s - this.s;
    }

    
}
public class StackTop {
    
    public int solution(int n, ArrayList<Top> list) {
        int answer = 0;
        int[] dy = new int[n];

        dy[0] = list.get(0).h;

        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(list.get(i).w < list.get(j).w && dy[j] > max)
                    max = dy[j];
                dy[i] = max + list.get(i).h;
            }
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        StackTop st = new StackTop();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<Top> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int tempS = in.nextInt();
            int tempH = in.nextInt();
            int tempW = in.nextInt();

            list.add(new Top(tempS, tempH, tempW));
        }
        Collections.sort(list);

        System.out.println(st.solution(n, list));
    }
}
