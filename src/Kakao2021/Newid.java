package Kakao2021;

import java.util.regex.Pattern;

public class Newid {
/*
 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
 */
	public static String solution(String new_id) {
        int len = new_id.length();
        String idPtn = "^[_a-z0-9-]*([\\._a-z0-9-])[_a-z0-9-]*$";
        String spPtn = "~!@#$%^&*()=[+][{]}:?,<>/";
        
		if (len >=3 && len <= 15 && Pattern.matches(idPtn, new_id)) {
			return new_id;
		}
        
        new_id = new_id.toLowerCase();
        System.out.println("1 : " + new_id);
        new_id = new_id.replaceAll("[~!@#[$]%\\^&[*]\\(\\)=[+]\\[\\{\\]\\}:?,<>/]", "");
        System.out.println("2 : " + new_id);
        new_id = new_id.replaceAll("\\.{2,}", ".");
        System.out.println("3 : " + new_id);
        new_id = new_id.replaceAll("^[\\.]", "");
        new_id = new_id.replaceAll("[\\.]$", "");
        System.out.println("4 : " + new_id);
        if(new_id.isBlank() || "".equals(new_id)){
        	new_id = "a";
        }
        System.out.println("5 : " + new_id);
        int newLen = new_id.length();
        if(newLen > 15) {
        	new_id = new_id.substring(0,15);
        	new_id = new_id.replaceAll("[\\.]$", "");
        	 System.out.println("6 : " + new_id);
        }
        newLen = new_id.length();
        if(newLen < 3) {
        	String last = new_id.substring(newLen-1, newLen);
        	System.out.println(last);
        	for(int i = newLen; i < 3; i++) {
        		new_id = new_id.concat(last);	
        	}
        	 System.out.println("7 : " + new_id);
        }
        
        return new_id;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "...!@BaT#*..y.abcdefghijklm";
		//System.out.println(checkId(id));
		System.out.println("answer : " + solution("abcdefghijklmn.p"));
		System.out.println("answer : " + solution("z-+.^."));
		System.out.println("answer : " + solution("=.="));
		System.out.println("answer : " + solution("i123_.def"));
		
	}

}
