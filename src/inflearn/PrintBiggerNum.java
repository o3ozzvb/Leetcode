package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintBiggerNum {

	/* 1. My Code 
	public String solution(int n, String s) {
		String	 answer = "";
		String[] num = s.split(" ");
		
		System.out.print(num[0] + " ");
		for(int i = 1; i < n; i++) {
			int n1 = Integer.parseInt(num[i-1]);
			int n2 = Integer.parseInt(num[i]);
			System.out.print(n1 < n2 ? n2 + " " : "");
		}
		
		return answer;
	}
	*/
	
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) answer.add(arr[i]);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		/* 1. My Code
		String n = in.nextLine();
		String input = in.nextLine();
		
		PrintBiggerNum pb = new PrintBiggerNum();
		pb.solution(Integer.parseInt(n), input);
		*/
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		PrintBiggerNum pb = new PrintBiggerNum();
		for(int x : pb.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}
