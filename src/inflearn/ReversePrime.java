package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrime {

	/* 1. My Code
	public void solution(int n, String st) {
		String[] arr = st.split(" ");
		
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			arr[i] = sb.append(arr[i]).reverse().toString();
		}
		
		for(String s : arr) {
			int x = Integer.parseInt(s);
			if(isPrime(x)) {
				System.out.print(x + " ");
			}
			
		}
	}
	*/
	
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			int tmp = arr[i];
			int res = 0;
			while(tmp > 0) {
				res = res * 10 + (tmp % 10);
				tmp = tmp / 10;
			}
			if(isPrime(res)) answer.add(res);
		}
		return answer;
	}
	
	public static boolean isPrime(int x) {
		boolean answer = true;

		if(x == 1) return false;
		for(int i = 2; i < x; i++) {
			if(x % i == 0) {
				answer = false;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ReversePrime rp = new ReversePrime();
		for(int x : rp.solution(n, arr)) {
			System.out.print(x + " ");
		}
		
		/* My Code
		sc.nextLine();
		String s = sc.nextLine();
		
		rp.solution(n, s);
		*/
	}

}
