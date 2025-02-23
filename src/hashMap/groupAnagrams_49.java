package hashMap;

import java.util.*;

public class groupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] ch = str.toCharArray();

            Arrays.sort(ch);
            String sortedStr = new String(ch);
            if(!map.containsKey(sortedStr)){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(sortedStr, newList);
            }
            else{
                map.get(sortedStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
