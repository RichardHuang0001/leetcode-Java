package Hot100第一轮复习;

public class 盛水最多的容器11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        盛水最多的容器11 solution = new 盛水最多的容器11();
        System.out.println(solution.maxArea(height));
    }
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0,right = height.length-1;
        while(left<right){
            int curArea = Math.min(height[left],height[right])*(right - left);
            max = Math.max(max,curArea);
            if(height[left]<height[right]){//左边更矮就移动左边，直到一个比原来高的
                int originLeftH = height[left];
                while(height[left]<=originLeftH && left < right){
                    left++;
                }
            }
            else{
                int originRightH = height[right];
                while(height[right]<=originRightH && right > left){
                    right--;
                }
            }
        }
        return max;
    }
}
