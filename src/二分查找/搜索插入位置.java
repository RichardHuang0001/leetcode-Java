package 二分查找;

public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6,7};
        int target = 2;
        搜索插入位置 solution = new 搜索插入位置();
        System.out.println(solution.searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        return search(nums,0, nums.length-1,target);
    }
    public int search(int[] nums,int left,int right,int target){
        if(left>right){
            return left;
        }
        int mid = (left+right)/2;
        if(nums[mid]==target){
            return mid;
        }else if (target<nums[mid]) {
            return search(nums,left,mid-1,target);
        }else{
            return search(nums,mid+1,right,target);
        }
    }
}
