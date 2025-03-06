package 二分查找;

public class 寻找旋转排序数组中的最小值153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0,right = len-2;
        int end = nums[len-1];
        while(left<=right){
            int mid = (left+right)/2;
            int midNum = nums[mid];
            if(midNum>end){//mid肯定在左边，最小值在mid右边
                left = mid+1;
            }else{// <= 的话，最小值在mid左边
                right = mid-1;
            }
        }
        return nums[left];
    }
}
