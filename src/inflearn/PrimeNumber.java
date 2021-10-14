package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {

	public int solution(int n) {
		/* 1. My Code
		int answer = 1;
		ArrayList<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		for(int i = 3; i <= n; i++) {
			boolean isPrime = true;
			for(int x : prime) {
				if(i%x == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				answer++;
				prime.add(i);
			}
		}
		
		//for(int x : prime) System.out.print(x + " ");
		
		*/
		
		int answer = 0;
		int[] ch = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(ch[i]==0) {
				answer++;
				//i의 배수 체크 
				for(int j = 0; j <= n; j=j+i) {
					ch[j]=1;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PrimeNumber pn = new PrimeNumber();
		System.out.println(pn.solution(n));
		
	}

}
