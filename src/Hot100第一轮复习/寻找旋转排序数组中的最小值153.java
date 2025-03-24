package Hot100第一轮复习;

public class 寻找旋转排序数组中的最小值153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int end = nums[len-1];
        int left = 0,right = len-2;
        //整个数组被分成左右两段，左边是更大的一段，右边是更小的一段，
        //目标是找到右边一段的第一个数，就是最小值了。
        while(left<=right){
            int mid = (left+right) /2;
            if(nums[mid]>end){//mid在左边，而答案肯定在mid右边
                left = mid+1;
            }else{// mid在右边一段，答案肯定在mid左边
                right = mid-1;
            }
        }
        return nums[left];
    }
}
