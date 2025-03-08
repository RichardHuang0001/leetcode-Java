package 输入输出处理;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 平均绩点 {
    public static void main(String[] args) {
        String input = "A B C D F\n" +
                "B F F C C A\n" +
                "D C E F";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Map<Character,Float>  map = new HashMap<>();
        map.put('A',4.0f);
        map.put('B',3.0f);
        map.put('C',2.0f);
        map.put('D',1.0f);
        map.put('F',0.0f);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            float sum = 0;
            float mean = 0;
            int len = s.length;
            boolean unknown = false;
            for(int i = 0;i<len;i+=1){
                float cur = map.getOrDefault(s[i].charAt(0),-1f);
                if(cur<0){
                    unknown = true;
                }
                sum += cur;
            }
            if(unknown){
                System.out.println("Unknown");
            }else{
                mean = sum/len;
                System.out.println(String.format("%.2f",mean));
            }
        }
    }
}
