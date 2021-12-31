package inflearn;

import java.util.Scanner;

public class InsertionSort {

	public int[] solution(int n, int[] arr) {
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(tmp < arr[j]) {
					arr[j+1] = arr[j];
				}else {
					break;
				}
			}
			arr[j+1] = tmp;	
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 삽입정렬 : 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘 */
		InsertionSort is = new InsertionSort();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int x : is.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}



