package Kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MenuRenewal {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> ansList = new ArrayList<String>(); //priorityQueue 로 대체 가
        boolean[] visited = new boolean[21];
       
        for(int i : course) {
        	map = new HashMap<String, Integer>();
        	System.out.println("course : " + i);
        	for(String order : orders) {
        		if(i > order.length()) {
        			continue;
        		}
        		System.out.println("order : " + order);
        		char[] orderArr = order.toCharArray();
        		Arrays.sort(orderArr);
        		order = new String(orderArr);
        		combination(order, visited, 0, order.length(), i);
        	}
        	
    		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());

    		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
    			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
    				return obj2.getValue().compareTo(obj1.getValue());
    			}
    		});
    		
			if (!list.isEmpty()) {
				int max = list.get(0).getValue();
				for (Entry<String, Integer> entry : list) {
					if (max > 1 && max == entry.getValue()) {
						ansList.add(entry.getKey());
						System.out.println(entry.getKey() + " : " + entry.getValue());
					} else {
						break;
					}
				}
			}
        }
        
		Collections.sort(ansList);
		
        answer = ansList.toArray(new String[ansList.size()]);
        return answer;
    }
	
	static void combination(String arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	 String combi = "";
	    	 for (int i = 0; i < n; i++) {
	             if (visited[i]) {
	            	 combi += arr.charAt(i);
	                 //System.out.print(arr.charAt(i) + " ");
	             }
	         }
	    	 
	    	 if(map.containsKey(combi)) {
	    		 map.replace(combi, map.get(combi.toString()) + 1);
	    		 System.out.println("combi(Contain) : " + combi + " - " + map.get(combi.toString()));
	    	 }else {
	    		 System.out.println("combi(not Contain) : " + combi);
	    		 map.put(combi, 1);
	    	 }
	    	 
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	
	// 배열 출력
    static void print(String arr, boolean[] visited, int n) {
       
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"XYZ", "XWY", "WXA"}; //{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; //{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] answers = {};
		
		answers = solution(orders, course);
		for(String ans : answers) {
			System.out.println(ans);
		}
		
	}

}
