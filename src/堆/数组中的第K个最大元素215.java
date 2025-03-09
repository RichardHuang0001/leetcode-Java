package 堆;

import java.util.PriorityQueue;


public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        数组中的第K个最大元素215 solution = new 数组中的第K个最大元素215();
        int ans = solution.findKthLargest(nums,k);
        System.out.println(ans);
    }

    public int findKthLargest(int[] nums, int k) {
        // 转换成查找第n-k+1小的元素
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    // 使用三路快排的快速选择算法
    public int quickSelect(int[] nums, int left, int right, int k) {
        // 边界条件：如果区间只有一个元素
        if (left == right) {
            return nums[left];
        }

        // 进行三路分区
        int[] partition = partition3Way(nums, left, right);
        int lt = partition[0]; // 小于区域的右边界
        int gt = partition[1]; // 大于区域的左边界

        // 判断k落在哪个区域
        if (k <= lt) {
            // k在小于区域内，继续在左侧查找
            return quickSelect(nums, left, lt, k);
        } else if (k <= gt) {
            // k在等于区域内，直接返回
            return nums[lt + 1];
        } else {
            // k在大于区域内，继续在右侧查找
            return quickSelect(nums, gt + 1, right, k);
        }
    }

    // 三路分区，返回小于区域右边界和大于区域左边界的索引
    public int[] partition3Way(int[] nums, int left, int right) {
        // 选择右端点作为基准
        int pivot = nums[right];

        int lt = left - 1;      // 小于区域右边界
        int i = left;           // 当前遍历位置
        int gt = right;         // 大于区域左边界

        // 当前元素还未分类完成
        while (i < gt) {
            if (nums[i] < pivot) {
                // 当前元素小于基准，放入小于区域
                lt++;
                swap(nums, lt, i);
                i++;
            } else if (nums[i] > pivot) {
                // 当前元素大于基准，放入大于区域
                gt--;
                swap(nums, i, gt);
                // 注意：这里不增加i，因为交换过来的元素还未处理
            } else {
                // 当前元素等于基准，保留在等于区域
                i++;
            }
        }

        // 将基准元素放到等于区域的末尾
        swap(nums, gt, right);

        // 返回小于区域右边界和大于区域左边界
        return new int[]{lt, gt};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}