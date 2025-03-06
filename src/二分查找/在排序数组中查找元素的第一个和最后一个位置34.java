package 二分查找;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        在排序数组中查找元素的第一个和最后一个位置34 solution = new 在排序数组中查找元素的第一个和最后一个位置34();
        System.out.println(Arrays.toString(solution.searchRange(nums,target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int left=0,right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                System.out.println(mid);
                int last = mid;
                while(last<nums.length && nums[last]==target){
                    last++;
                }
                int first = mid;
                while(first>=0 && nums[first]==target){
                    first--;
                }
                return new int[]{first+1,last-1};
            }
            if (target < midNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
