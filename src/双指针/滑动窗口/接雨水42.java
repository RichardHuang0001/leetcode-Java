package 双指针.滑动窗口;

public class 接雨水42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));

    }

    //动态规划方法
    public static int trap1(int[] height) {
        int volume = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len-1];
        for(int i = 1;i<len;i++){
            leftMax[i]= Math.max(leftMax[i-1],height[i]);
        }
        for(int i = len-2;i >=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        for (int i = 0; i < len; i++) {
            volume += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return volume;
    }
    //双指针方法
    public static int trap2(int[] height){
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int volume = 0;
        while(left <= right){
            //更新两个最大值
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            //基于两个最大值，计算当前位置的水量并累加
            if(leftMax < rightMax){
                volume += leftMax - height[left];
                left++;
            }
            else{
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}
