package 子数组;

import java.util.Arrays;
import java.util.PriorityQueue;

//已通过
public class 滑动窗口最大值239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //用2个数来表示nums中的一个数，第一位是值，第二位是在nums中的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] res = new int[nums.length-k+1];
        int l=0,r=0;
        for(r=0;r<k;r++){//循环k次，构建初始窗口
            int[] temp = {nums[r],r};
            pq.offer(temp);
        }
        r--;
        while(r < nums.length){
            while(pq.peek()[1] < l){//如果窗口的左边界大于当前最大值，则移除
                pq.remove();
            }
            int[] top = pq.peek();
            res[l] = top[0];
            r++;
            if(r < nums.length){
                int[] temp = {nums[r],r};
                pq.offer(temp);
            }
            l++;
        }
        return res;
    }
}
