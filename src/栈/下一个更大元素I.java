package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        int[] nextGreater = new int[len];
        Deque<Integer> st = new ArrayDeque<>();//单调栈，存储数字本身
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums2[i],i);//存一个反向索引
            while(!st.isEmpty() && nums2[i]>st.peek()){
                int top = st.pop();
                nextGreater[map.get(top)] = nums2[i];
            }
            st.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            result[i] = nextGreater[index]==0? -1:nextGreater[index];
        }

        return result;
    }
}
