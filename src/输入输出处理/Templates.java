package 输入输出处理;

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Templates {

    /**
     * 本地调试模拟System.in的方法
     */
    public static void main(String[] args) {
        //方法一，输入写在字符串，然后用ByteArrayInputStream，输入字符串的getBytes
        // 预定义的输入数据
        String input = "2\n3 4 5\n1 2 3";

        // 将字符串转换为输入流并重定向到System.in
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 现在你可以正常使用Scanner或BufferedReader读取输入
        Scanner sc = new Scanner(System.in);
        // 你的代码...

        //方法二：写在txt文件，用System.setIn(new FileInputStream(filename)
        try {
            // 将文件重定向到System.in
            System.setIn(new FileInputStream("input.txt"));

            // 现在你可以正常使用Scanner或BufferedReader读取输入
            Scanner scanner = new Scanner(System.in);
            // 你的代码...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 模式1：固定数量的测试用例
     * 第一行输入一个整数T，表示测试用例数量
     * 接下来T行，每行一个测试用例
     */
    public class Template1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt(); // 读取测试用例数量

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt(); // 读取每个测试用例的输入
                // 处理逻辑
                System.out.println(solve(n)); // 输出结果
            }
            sc.close();
        }

        private static int solve(int n) {
            // 实现你的算法
            return n * 2;
        }
    }

    /**
     * 模式2：不定数量的测试用例，直到输入结束
     * 每行一个测试用例，直到没有更多输入
     */
    public class Template2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                int n = sc.nextInt();
                // 处理逻辑
                System.out.println(solve(n));
            }
            sc.close();
        }

        private static int solve(int n) {
            // 实现你的算法
            return n * 2;
        }
    }

    /**
     * 模式3：不定数量的测试用例，特定条件结束
     * 每行一个测试用例，当输入为0时结束
     */
    public class Template3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (true) {
                int n = sc.nextInt();
                if (n == 0) break; // 特定条件结束

                // 处理逻辑
                System.out.println(solve(n));
            }
            sc.close();
        }

        private static int solve(int n) {
            // 实现你的算法
            return n * 2;
        }
    }

    /**
     * 模式4：每个测试用例有多行输入
     * 第一行输入一个整数T，表示测试用例数量
     * 每个测试用例第一行输入n，表示接下来有n个数
     * 第二行输入n个整数
     */
    public class Template4 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt(); // 测试用例数量

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt(); // 数组大小
                int[] arr = new int[n];

                for (int j = 0; j < n; j++) {
                    arr[j] = sc.nextInt(); // 读取数组元素
                }

                // 处理逻辑
                System.out.println(solve(arr));
            }
            sc.close();
        }

        private static int solve(int[] arr) {
            // 实现你的算法
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        }
    }

    /**
     * 模式5：读取矩阵
     * 第一行输入两个整数n和m，表示矩阵的行数和列数
     * 接下来n行，每行m个整数
     */
    public class Template5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // 行数
            int m = sc.nextInt(); // 列数

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // 处理逻辑
            System.out.println(solve(matrix));
            sc.close();
        }

        private static int solve(int[][] matrix) {
            // 实现你的算法
            int sum = 0;
            for (int[] row : matrix) {
                for (int num : row) {
                    sum += num;
                }
            }
            return sum;
        }
    }

    /**
     * 模式6：读取字符串
     * 每行一个字符串，共T行
     */
    public class Template6 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine(); // 注意：需要读取换行符

            for (int i = 0; i < t; i++) {
                String s = sc.nextLine();
                // 处理逻辑
                System.out.println(solve(s));
            }
            sc.close();
        }

        private static String solve(String s) {
            // 实现你的算法
            return new StringBuilder(s).reverse().toString();
        }
    }

    /**
     * 模式7：读取多种类型的输入
     * 每行包含一个整数，一个浮点数和一个字符串
     */
    public class Template7 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                int a = sc.nextInt();
                double b = sc.nextDouble();
                sc.nextLine(); // 注意：需要读取换行符
                String s = sc.nextLine();

                // 处理逻辑
                System.out.println(solve(a, b, s));
            }
            sc.close();
        }

        private static String solve(int a, double b, String s) {
            // 实现你的算法
            return a + " " + b + " " + s;
        }
    }

    /**
     * 模式8：读取用分隔符分隔的数据
     * 每行包含多个由空格分隔的整数
     */
    public class Template8 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                String line = sc.next();
                String[] parts = line.split(","); // 以逗号分隔

                int[] numbers = new int[parts.length];
                for (int j = 0; j < parts.length; j++) {
                    numbers[j] = Integer.parseInt(parts[j]);
                }

                // 处理逻辑
                System.out.println(solve(numbers));
            }
            sc.close();
        }

        private static int solve(int[] numbers) {
            // 实现你的算法
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            return sum;
        }
    }

/**
 * 模式9：使用BufferedReader提高输入效率
 * 适用于大量输入的情况
 */

    public class Template9 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int[] arr = new int[n];

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }

                // 处理逻辑
                System.out.println(solve(arr));
            }
        }

        private static int solve(int[] arr) {
            // 实现你的算法
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        }
    }

    /**
     * 模式10：输出格式化
     * 处理特定格式的输出要求
     */
    public class Template10 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                double x = sc.nextDouble();

                // 处理逻辑
                System.out.printf("Case #%d: %.2f\n", i + 1, solve(n, x));
            }
            sc.close();
        }

        private static double solve(int n, double x) {
            // 实现你的算法
            return n * x;
        }
    }
}
