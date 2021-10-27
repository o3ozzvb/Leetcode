package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

	public String solution(String a, String b) {
		/* My Code
		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();
		
		for(char c : a.toCharArray()) {
			mapA.put(c, mapA.getOrDefault(c,0)+1);
		}
		for(char c : b.toCharArray()) {
			mapB.put(c, mapB.getOrDefault(c,0)+1);
		}
		
		if(mapA.size() == mapB.size()) {
			for(char key : mapA.keySet()) {
				int valA = mapA.get(key);
				int valB = mapB.get(key);
				if(valA != valB) {
					return "NO";
				}
			}
		} else {
			return "NO";
		}
		
		return "YES";
		*/
		
		String answer = "YES";
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : a.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : b.toCharArray()) {
			if(!map.containsKey(x) || map.get(x)==0) {
				return "NO";
			}
			map.put(x, map.get(x)-1);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram a = new Anagram();
		Scanner in = new Scanner(System.in);
		
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		
		System.out.println(a.solution(s1, s2));
	}

}
