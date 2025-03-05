package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new 子集78().subsets(nums));
    }
    //方法一：算术移位
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        ans.add(new ArrayList<>());
        for (int musk = 0; musk < (int)Math.pow(2,len); musk++) {
            cur.clear();
            for (int i = 0; i < len ; i++) {
                if(((musk >> i) & 1) == 1) {//如果musk的第i位是1，则将nums[i]加入cur
                    cur.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(cur));
        }
    return ans;
    }
    //方法二：回溯
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,0,cur,ans);
        return ans;
    }
    public void backtrack(int[] nums,int start,List<Integer> cur,List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}
