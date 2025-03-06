package 二分查找;

public class 搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3}};
        int target = 3;
        搜索二维矩阵 solution = new 搜索二维矩阵();
        System.out.println(solution.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        int left = 0,right = m-1;
        while(left<=right){
            int mid = (left+right)/2;
            int midNum = matrix[mid][0];
            if(midNum == target){
                return true;
            }
            if(target < midNum){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if(left==0 || left>=m+1){
            return false;
        }
        int[] nums = matrix[left-1];
        left = 0;
        right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            int midNum = nums[mid];
            if(midNum == target){
                return true;
            }
            if(target < midNum){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}
