package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 每日温度739_单调栈 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int len = temperatures.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()]){//栈非空且当前元素大于栈顶，就找到了栈顶元素的下一个比他大的元素了。
                int topIndex = st.pop();//读取栈顶元素
                    result[topIndex] = i-topIndex;//写入result
            }
            st.push(i);
        }
        return result;
    }
}
