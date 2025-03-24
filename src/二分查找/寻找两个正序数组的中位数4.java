package 二分查找;

public class 寻找两个正序数组的中位数4 {
    // 比较难，看不太懂
    public class FindMedianSortedArrays {

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 1. 保证 nums1 是较短的数组（若不是就交换）
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;

            // 2. 在 [0..m] 的范围里对 nums1 的分割位置 i 进行二分
            int left = 0;
            int right = m;

            // 需要的左边元素总数 (m + n + 1) / 2
            // +1 是为了让奇数总长度时左边部分的元素个数更易处理
            int halfLen = (m + n + 1) / 2;

            while (left <= right) {
                // i: nums1 左边分割的元素个数
                int i = (left + right) / 2;
                // j: nums2 左边分割的元素个数
                int j = halfLen - i;

                // nums1[i-1] 和 nums2[j-1] 是左半部分的"尾部"元素
                // nums1[i]   和 nums2[j]   是右半部分的"首部"元素

                // 3. 判断是否满足“左侧最大值 <= 右侧最小值”
                //    注意边界情况：i=0 或 i=m 或 j=0 或 j=n

                // 左侧最大值
                int leftMaxA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
                int leftMaxB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
                int leftMax = Math.max(leftMaxA, leftMaxB);

                // 右侧最小值
                int rightMinA = (i == m) ? Integer.MAX_VALUE : nums1[i];
                int rightMinB = (j == n) ? Integer.MAX_VALUE : nums2[j];
                int rightMin = Math.min(rightMinA, rightMinB);

                if (leftMax <= rightMin) {
                    // 找到合适的切分
                    if (((m + n) % 2) == 1) {
                        // 总长度奇数，中位数就是左侧最大值
                        return leftMax;
                    } else {
                        // 总长度偶数，中位数是 (左侧最大值 + 右侧最小值)/2
                        return (leftMax + rightMin) / 2.0;
                    }
                } else {
                    // 若 leftMaxA > rightMinB，说明 i 选大了，需要往左移
                    // 若 leftMaxB > rightMinA，说明 i 选小了，需要往右移
                    if (leftMaxA > rightMinB) {
                        // A 左半部分中有个数太大了，减小 i
                        right = i - 1;
                    } else {
                        // B 左半部分中有个数太大了，需要增大 i
                        left = i + 1;
                    }
                }
            }

            // 理论上不会到这里，如果到了，说明输入有问题
            throw new IllegalArgumentException("Input arrays are not valid.");
        }

        // 测试
        public static void main(String[] args) {
            int[] nums1 = {1, 3};
            int[] nums2 = {2};
            System.out.println(findMedianSortedArrays(nums1, nums2)); // 2.0

            int[] nums3 = {1, 2};
            int[] nums4 = {3, 4};
            System.out.println(findMedianSortedArrays(nums3, nums4)); // 2.5
        }
    }

}
