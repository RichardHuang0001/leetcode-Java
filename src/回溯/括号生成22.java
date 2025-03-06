package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 括号生成22 {
    public static void main(String[] args) {
        括号生成22 instance = new 括号生成22();
        System.out.println(instance.isValid("(()))("));
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int[] state = new int[2];//0表示左括号
        backtrack(ans,sb,state,n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder sb, int[] state, int n) {
        if (state[0] == n && state[1] == n) {//生成结束
            String s = sb.toString();
            ans.add(s);
            return;
        }
        if(state[0]<n){//可以优先添加左括号
            sb.append('(');
            state[0]++;
            backtrack(ans,sb,state,n);
            sb.deleteCharAt(sb.length()-1);
            state[0]--;//回溯
        }
        if(state[1]<state[0]) {//可以添加右括号
            sb.append(')');
            state[1]++;
            backtrack(ans, sb, state, n);
            sb.deleteCharAt(sb.length() - 1);
            state[1]--;//回溯
        }
    }

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top = stack.peek();
                    if(top == '(' && s.charAt(i)==')'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

