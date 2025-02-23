package 双指针.滑动窗口;

public class 盛水最多的容器11 {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Math.min(height[left],height[right]) * (right-left);
        while(left<right){
            //左边更小
            if(height[left]<height[right]){
                left++;

            }else{
                right--;
            }
            int area = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max,area);
        }
        return max;
    }
}
