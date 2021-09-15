package inflearn;

import java.util.Scanner;

public class ReverseOnlyAplphabet {

	public String solution(String str) {
		String answer;
		char[] arr = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;
		
		while(lt < rt) {
			while(!Character.isAlphabetic(arr[lt])) {
				lt++;
			}
			while(!Character.isAlphabetic(arr[rt])) {
				rt--;
			}
			//System.out.println("arr["+lt+"] : " + arr[lt]);
			//System.out.println("arr["+rt+"] : " + arr[rt]);
			char tmp = arr[lt];
			arr[lt] = arr[rt];
			arr[rt] = tmp;
			lt++;
			rt--;
		}
		
		answer = String.valueOf(arr);
		return answer;
		
	}
	
	public static void main(String[] args) {
		ReverseOnlyAplphabet r = new ReverseOnlyAplphabet();
		
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		System.out.println(r.solution(s));
	}

}
