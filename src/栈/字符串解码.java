package 栈;

import java.util.Stack;

public class 字符串解码 {
    public String decodeString(String s) {
        // 用于存储重复次数的栈
        Stack<Integer> countStack = new Stack<>();
        // 用于存储之前结果的栈
        Stack<StringBuilder> resStack = new Stack<>();

        // 用于构建当前结果的StringBuilder
        StringBuilder currentResult = new StringBuilder();
        // 当前的数字（重复次数）
        int k = 0;

        // 遍历字符串中的每个字符
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 如果是数字，累积数字得到重复次数
                // 注意要处理多位数字的情况
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 遇到开括号，把当前的重复次数和结果分别压入对应的栈
                countStack.push(k);
                resStack.push(currentResult);

                // 重置k和currentResult，准备处理括号内的内容
                k = 0;
                currentResult = new StringBuilder();
            } else if (ch == ']') {
                // 遇到闭括号，处理一个嵌套层级

                // 取出之前的结果
                StringBuilder prevResult = resStack.pop();
                // 取出重复次数
                int repeatTimes = countStack.pop();

                // 将当前结果重复相应次数
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentResult);
                }

                // 拼接到之前的结果上
                currentResult = prevResult.append(temp);
            } else {
                // 如果是普通字符，直接添加到结果中
                currentResult.append(ch);
            }
        }

        // 返回最终结果
        return currentResult.toString();
    }
}
