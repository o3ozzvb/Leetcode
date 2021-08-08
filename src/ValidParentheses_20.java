import java.util.Stack;

public class ValidParentheses_20 {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c == ')' || c == '}' || c == ']') {
				char top = ' ';
				if(!stack.empty()) {
					top = stack.peek();
				}else {
					return false;
				}
			
				if (c == ')') {
					if (top == '(') {
						stack.pop();
						continue;
					}
				} else if (c == '}') {
					if (top == '{') {
						stack.pop();
						continue;
					}
				} else if (c == ']') {
					if (top == '[') {
						stack.pop();
						continue;
					}
				}
			} 
			stack.push(c);
		}
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
    }
	
	public static void main(String[] args) {
		String s = "{()}[]";
		Boolean ans = isValid(s);
		
		System.out.println(ans.toString());

	}

}
