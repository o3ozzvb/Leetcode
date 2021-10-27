package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class KindsOfSales {

	public int[] solution(int n, int k, int[] arr) {
		int[] answer = new int[n-k+1];
		HashMap<Integer, Integer> map = new HashMap<>();
		int lt=0, rt=k-1, idx=0;
		
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		rt++;
		answer[idx++] = map.size();
		
		while(rt<n) {
			if(map.containsKey(arr[lt]) && map.get(arr[lt])>1) {
				map.put(arr[lt], map.get(arr[lt])-1);
			}
			else {
				map.remove(arr[lt]);
			}
			
			lt++;
			
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			answer[idx++] = map.size();
			rt++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KindsOfSales ks = new KindsOfSales();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int x : ks.solution(n, k, arr)) {
			System.out.print(x + " ");
		}
	}

}
