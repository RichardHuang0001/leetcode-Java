package 子数组;

public class 长度最小的子数组209 {
    public static void main(String[] args) {

    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int min = nums.length+1;
        int sum = 0;
        for(;r<nums.length;r++){
            sum += nums[r];
            if(sum < target) {
                continue;
            }
            while(sum >= target) {//收缩左边界满足条件
                min = Math.min(min, r-l+1);
                sum -= nums[l];
                l++;
            }
        }
        return min<=nums.length? min:0;
    }
}
