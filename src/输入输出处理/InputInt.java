package 输入输出处理;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InputInt {
    public static void main(String[] args) {
        String input = "6\n" +
                "5 2 4 1 7 5\n" +
                "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = Integer.parseInt(sc.nextLine());

            if(n==0){
                break;
            }
            System.out.println(n);
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[n];
            System.out.println(Arrays.toString(s));
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(Arrays.toString(nums));
            }
        }
    }

