package inflearn;

import java.util.Scanner;

public class WordInSentence {

	/*
	 * 설명

		한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
		
		문장속의 각 단어는 공백으로 구분됩니다.
		
		
		입력
		첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
		
		
		출력
		첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
		
		단어를 답으로 합니다.
	 */
	
	public String solution(String str) {
		String answer = "";
		String[] sp = str.split(" ");
		int maxLen = 0;
		
		// 1 : split 사용하기 
		for(String s : sp) {
			if(maxLen < s.length()) {
				maxLen = s.length();
				answer = s;
			}
		}
		
		/* 2 : indexOf 사용 
		int pos;
		while((pos = str.indexOf(' ')) != -1){
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(maxLen < len) {
				maxLen = len;
				answer = tmp;
			}
			str = str.substring(pos+1);
		}
		if(maxLen < str.length()) {
			answer = str;
		}
		*/
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		WordInSentence wis = new WordInSentence();
		System.out.println(wis.solution(input));

	}

}
