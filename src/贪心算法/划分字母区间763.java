package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 划分字母区间763 {
    public static void main(String[] args) {
        划分字母区间763 solution = new 划分字母区间763();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndexMap = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            lastIndexMap[s.charAt(i)-'a'] = i;
        }
        System.out.println(Arrays.toString(lastIndexMap));
        int curEnd = 0;
        int curStart = 0;
        for (int i = 0; i < len; i++) {
            curEnd = Math.max(curEnd,lastIndexMap[s.charAt(i)-'a']);
            if(curEnd==i){
                ans.add(curEnd-curStart+1);
                curStart = curEnd+1;
            }
        }
        return ans;
    }
}
