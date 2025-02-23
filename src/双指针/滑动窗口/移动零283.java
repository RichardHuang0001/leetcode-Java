package 双指针.滑动窗口;

import java.util.Arrays;

public class 移动零283 {
    public static void main(String[] args) {
        int[] nums = {1};// 131200
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int zeroPtr= 0; //左指针寻找下一个0
        int nonZeroPtr = 0; //右指针寻找下一个非0
        while(zeroPtr < len && nonZeroPtr <len){
            //移动左指针到下一个0的位置
            while(nums[zeroPtr] != 0 && zeroPtr < len){
                zeroPtr++;
                if(zeroPtr>=len){
                    break;
                }
            }
            //移动右指针到下一个非0的位置
            while(nonZeroPtr < len && nums[nonZeroPtr]==0){
                nonZeroPtr++;
                if(nonZeroPtr>=len){
                    break;
                }
            }
            //交换左右指针指向的元素
            if(zeroPtr < nonZeroPtr){
                int temp = nums[zeroPtr];
                nums[zeroPtr] = nums[nonZeroPtr];
                nums[nonZeroPtr] = temp;
            }

        }

    }
}
