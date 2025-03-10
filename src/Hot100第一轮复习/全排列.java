package Hot100第一轮复习;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,ans,cur);
        return ans;
    }
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> cur){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!= Integer.MAX_VALUE){
                int temp = nums[i];
                cur.add(nums[i]);
                nums[i] = Integer.MAX_VALUE;
                backtrack(nums,ans,cur);
                nums[i] = temp;
                cur.removeLast();
            }
        }
    }
}
