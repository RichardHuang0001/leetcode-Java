package 二分查找;

public class 山脉数组的峰顶索引 {
    public static void main(String[] args) {
        山脉数组的峰顶索引 solution = new 山脉数组的峰顶索引();
        int[] arr = {0,2,1,0};
        System.out.println(solution.peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0,right = len-1;
        while(left<=right){
            int mid = (left+right)/2;
            int numMid = arr[mid];
            if(arr[mid]>arr[mid+1]){//要么mid是峰顶，要么mid和mid+1都在峰顶右侧
                right = mid-1;
            }
            else {//要么mid+1是峰顶，要么mid和mid+1都在峰顶左侧\
                left = mid + 1;
            }
        }
        return left;
    }
}
