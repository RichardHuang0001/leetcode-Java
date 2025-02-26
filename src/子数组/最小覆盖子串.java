package 子数组;

import java.util.Arrays;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "A";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        int[] tMap = new int[128];
        int[] sMap = new int[128];
        if(s.length()<t.length()){
            return "";
        }
        for (char c : t.toCharArray()) {
            tMap[c-'A']++;
        }
        int[] min={s.length()+1,0,s.length()};
        //变长滑动窗口
        for(int l=0,r=0;r<s.length();r++){
            sMap[s.charAt(r)-'A']++;//记录右边加新增的
            while(check(tMap,sMap) && l<=r){
                if(min[0] > r-l+1){
                    min[0] = r-l+1;
                    min[1] = l;
                    min[2] = r;
                }
                sMap[s.charAt(l)-'A']--;//记录左边移除的
                l++;
            }//检查是否满足条件
            //左侧收缩到尽了，还是满足条件的，就找到答案了
        }
        if(min[0] <= s.length()){
            return s.substring(min[1],min[2]+1);}
        else{
            return "";
        }
    }
    public static boolean check(int[] tMap,int[] sMap){
        //检查s是否大于等于t
        for(int i=0;i<tMap.length;i++){
            if(sMap[i] < tMap[i]){
                return false;
            }
        }
        return true;
    }
}
