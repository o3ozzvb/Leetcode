package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	public int solution(int n, int[] arr) {
		int answer = 1;
		int tallest = arr[0];
		for(int i = 1; i < n; i++) {
			if(tallest < arr[i]) {
				tallest = arr[i];
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Student st = new Student();
		System.out.println(st.solution(n, arr));
	}

}
