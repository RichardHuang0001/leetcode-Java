package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 合并区间 {

    //比较复杂的方法
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
            System.out.println(intervals[i][0]);
        }
        Collections.sort(list , (a, b) -> a[0] - b[0]);
        boolean[] toRemove = new boolean[list.size()];
        for (int i = 1; i < list.size(); i++) {
            int[] interval = list.get(i);
            int[] pre = list.get(i-1);
            if (interval[0] <= pre[1]) {
                int[] newInterval = new int[]{pre[0], Math.max(interval[1], pre[1])};
                list.set(i, newInterval);
                toRemove[i-1] = true;
            }
        }
        List <int[]> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!toRemove[i]) {
                res.add(list.get(i));
            }
        }
        int[][] result = res.toArray(new int[res.size()][]);
        return result;
    }

    //简单的方法
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        //把第一个区间加入答案
        ans.add(intervals[0]);
        int curEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //可以合并
            if(intervals[i][0] <= curEnd){
                //更新当前区间的右边界
                if(intervals[i][1] > curEnd){//区间要扩张
                    curEnd = intervals[i][1];
                    ans.get(ans.size() - 1)[1] = curEnd;
                }else{//区间被前一个区间包进去了
                    continue;
                }
            }else{//不能合并，开启一个新区间
                ans.add(intervals[i]);
                curEnd = intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
