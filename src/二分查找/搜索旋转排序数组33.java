package 二分查找;

public class 搜索旋转排序数组33 {
    public int search(int[] nums, int target) {
        //一次二分就可以解决问题
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            int midNum = nums[mid];
            if(midNum==target){
                return mid;
            }
            if(nums[left]<=midNum){//说明左边是有序的
                if(nums[left]<=target && target<midNum){//target处于left 到mid之间的完全有序序列中
                    right = mid-1;
                }else{//target处于mid和right之间的，跟原问题一样，有山谷的序列中
                    left = mid+1;
                }
            }else{//说明右边是有序的
                if(target>midNum && target<=nums[right]) {//target处于mid到right之间的完全有序序列中
                    left = mid + 1;
                }else{//target处于left和mid之间的，跟原问题一样，有山谷的序列中
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
