package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) return this.y - o.y;
		else return  this.x - o.x;
	}
}

public class Coordinate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coordinate c = new Coordinate();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			arr.add(new Point(x,y));
		}
	
		Collections.sort(arr);
		
		for(Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}
	}
}



