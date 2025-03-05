package 回溯;

import java.util.*;

public class 组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, ans, curList, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int curSum, List<List<Integer>> ans, List<Integer> curList, int start) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curList));
            return;
        } else if (curSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i>=start&&candidates[i]==candidates[i-1]){
                continue;
            }
            curList.add(candidates[i]);
            curSum += candidates[i];
            backtrack(candidates, target, curSum, ans, curList, i + 1);
            curList.removeLast();
            curSum -= candidates[i];
        }
    }
}
