package Hot100第一轮复习;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,ans,cur,0);
        return ans;
    }
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> cur,int start){
        //每一个长度的子集都是答案之一
        ans.add(new ArrayList<>(cur));
        //如果长度已经满了，添加完这个答案之后就返回了
        if(cur.size() == nums.length){
            return;
        }
        //如果长度还没满，继续往组合成更长的子集
        for (int i = start; i < nums.length; i++) {
            if(nums[i] != Integer.MAX_VALUE){
                int temp = nums[i];
                cur.add(temp);
                nums[i] = Integer.MAX_VALUE;
                backtrack(nums,ans,cur,i+1);
                cur.removeLast();
                nums[i] = temp;
            }
        }
    }

    //方法二：位运算
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int len = nums.length;
        //遍历从0-2**len的数
        for (int i = 0; i < Math.pow(2,len); i++) {
            cur.clear();
            //遍历nums的每一位，看看是否要取入当前集合
            for (int j = 0; j < len; j++) {
                //i右移j位&1==1来判断i的第j位是否为1，如果是，则取nums[j]加入cur中
                if((i >> j & 1) == 1){
                       cur.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(cur));
        }
        return ans;
    }
}
