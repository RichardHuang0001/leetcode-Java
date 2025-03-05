package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合17 {
    public List<String> letterCombinations(String digits) {
        int digitsLen = digits.length();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        if(digitsLen == 0){
            return ans;
        }
        backtrack(digits,sb,ans,0,digitsLen,map);
        return ans;
    }
    public void backtrack(String digits, StringBuilder sb, List<String> ans, int curLen, int digitsLen, Map<Integer,String> map){
        if(sb.length() == digitsLen){//长度满了，说明对应的字母个数已经选满了，直接返回
            ans.add(sb.toString());
            return;
        }
        //根据当前curlen（也就是当前在选取第几个数字对应的字母表，获得table
        String table = map.get(digits.charAt(curLen) - '0');
        for (int i = 0; i < table.length(); i++) {//遍历table长度（3或者4）
            sb.append(table.charAt(i));//以此选取一个
            backtrack(digits,sb,ans,curLen+1,digitsLen,map);//然后curLen+1,到下一层获取下一个数字对应的字母表
            sb.deleteCharAt(sb.length()-1);//回溯，删除最后一个字符，然后下一轮循环会在当前字母表中选下一个字符加到sb中
        }
    }
}
