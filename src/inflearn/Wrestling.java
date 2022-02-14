package inflearn;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Player implements Comparable<Player> {
	int height;
	int weight;
	
	public Player(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Player o) {
		return o.height - this.height;
	}
	
}
public class Wrestling {

	public static int solution(List<Player> list) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			Player p1 = list.get(i);
			if(max < p1.weight) {
				answer++;
				max = Math.max(max, p1.weight);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Wrestling wr = new Wrestling();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		List<Player> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int h = in.nextInt();
			int w = in.nextInt();
			list.add(new Player(h, w));
		}
		Collections.sort(list);
		
		System.out.println(wr.solution(list));
	}
}



