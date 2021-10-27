package inflearn;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ClassPresident {

	public char solution(int n, String s) {
		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c,0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		for(Entry<Character, Integer> e : map.entrySet()) {
			if(max < e.getValue()) {
				max = e.getValue();
				answer = e.getKey();
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPresident cp = new ClassPresident();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String s = in.next();
		
		System.out.println(cp.solution(n, s));
	}

}
