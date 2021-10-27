package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class FindAnagram {

	public int solution(String s, String t) {
		int answer = 0;
		HashMap<Character, Integer> tMap = new HashMap<>();
		HashMap<Character, Integer> sMap = new HashMap<>();
		int lt = 0;
		
		for(char c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0)+1);
		}
		
		for(int i=0; i<t.length(); i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
		}
		if(sMap.equals(tMap)) answer++;
		
		
		for(int rt=t.length(); rt<s.length(); rt++) {
			char c = s.charAt(lt);
			sMap.put(c, sMap.get(c)-1);
			if(sMap.get(c)==0) sMap.remove(c);
			lt++;
			
			c = s.charAt(rt);
			sMap.put(c, sMap.getOrDefault(c, 0)+1);
			
			if(sMap.equals(tMap)) answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAnagram fa = new FindAnagram();
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		String t = in.nextLine();
		
		System.out.println(fa.solution(s, t));
	}

}
