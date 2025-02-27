package Hot100第一轮复习;

import java.util.*;

public class 字母异位词分组49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)){
                List<String > newList = new ArrayList<>();
                newList.add(str);
                map.put(key,newList);
            }else{
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
        }
}
