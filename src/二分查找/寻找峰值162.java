package 二分查找;

public class 寻找峰值162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len==1){
            return 0;
        }
        int left = 0,right = len-2;
        while(left<=right){
            int mid = (left+right)/2;
            //mid是峰值或者mid和mid+1都在峰值右侧
            if(nums[mid]>nums[mid+1]){
                right = mid-1;//到左侧继续寻找
            }else{//n mid <= n mid+1,mid+1是峰值或者mid和mid+1都在左侧
                left= mid+1;//到右侧继续寻找
            }
        }
        return left;
    }
}
