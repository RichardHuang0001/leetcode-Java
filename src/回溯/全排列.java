package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new 全排列().permute(nums);
        System.out.println(result);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // 存储所有排列结果
        List<Integer> current = new ArrayList<>();       // 当前正在构建的排列
        boolean[] used = new boolean[nums.length];       // 标记数字是否已使用

        backtrack(nums, used, current, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // 基本情况：如果当前排列长度等于数组长度，说明找到了一个完整排列
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // 注意要创建一个新的列表添加到结果中
            return;
        }

        // 尝试每个可能的数字
        for (int i = 0; i < nums.length; i++) {
            // 如果这个数字已经在当前排列中，跳过
            if (used[i]) {
                continue;
            }

            // 做出选择
            used[i] = true;           // 标记为已使用
            current.add(nums[i]);     // 添加到当前排列

            // 继续构建排列（递归）
            backtrack(nums, used, current, result);

            // 撤销选择（回溯）
            current.remove(current.size() - 1);  // 从当前排列中移除
            used[i] = false;                     // 标记为未使用
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        bt(nums,used,result,current);
        return result;
    }
    public void bt(int[] nums,boolean[] used,List<List<Integer>> result,List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            bt(nums,used,result,current);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}

