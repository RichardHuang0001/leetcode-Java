package Hot100第一轮复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(int[] o1, int[] o2)->{return o1[0]-o2[0];});

        ans.add(intervals[0]);

        int len = intervals.length;

        for (int i = 1; i < len; i++) {
            if(intervals[i][0]>ans.get(ans.size()-1)[1]){//不能合并
                ans.add(intervals[i]);
            }else{
                int[] old = ans.get(ans.size()-1);
                int[] newInt = {old[0],Math.max(old[1],intervals[i][1])};
                ans.set(ans.size()-1,newInt);
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
