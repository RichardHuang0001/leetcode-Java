package 双指针.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        // 调用 threeSum 方法并打印结果
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        // 遍历数组，固定一个数，然后使用双指针寻找另外两个数
        for (int i = 0; i < len; i++) {
            // 如果当前数与前一个数相同，跳过以避免重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //排序过的数组用双指针，一般用从两边向中间对撞的方式
            int left = i + 1; // 左指针
            int right = len - 1; // 右指针

            // 使用双指针寻找和为0的三元组
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 如果三数之和等于0，添加到结果列表中
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左指针和右指针值
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //移动到连续相同数字中的最后一个

                    // 然后执行正常的下一步，移动指针
                    left++;
                    right--;
                }
                //因为排序过了，所以这样移动
                // 如果三数之和小于0，左指针右移
                else if (sum < 0) {
                    left++;
                }
                // 如果三数之和大于0，右指针左移
                else {
                    right--;
                }
            }
        }
        return list;
    }
}
