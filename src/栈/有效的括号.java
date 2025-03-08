package 栈;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='['|| s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            } else if (s.charAt(i)==')') {
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if (s.charAt(i)==']') {
                if(!stack.isEmpty()&&stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if (s.charAt(i)=='}') {
                if(!stack.isEmpty()&&stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
