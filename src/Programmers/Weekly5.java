package Programmers;
import java.util.HashMap;
import java.util.Map;

public class Weekly5 {

	public static int solution(String word) {
		int answer = 0;
		int cnt[] = {781, 156, 31, 6 , 1};
		int len = word.length();
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('E', 1);
		map.put('I', 2);
		map.put('O', 3);
		map.put('U', 4);
		
		
		for(int i = 0; i < len; i++) {
			answer += map.get(word.charAt(i)) * cnt[i];
			answer += 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		String s = "AAAE";
		int count = 0;
		
		System.out.println(solution(s));
		return;
	}

}
