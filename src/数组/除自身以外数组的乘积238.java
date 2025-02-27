package 数组;

public class 除自身以外数组的乘积238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans_left = new int[len];
        ans_left[0]=1;
        int[] ans_right = new int[len];
        ans_right[len-1]=1;

        //利用上三角矩阵计算ans数组的右半部分
        for (int i = len-2;i>=0;i--){
            ans_right[i] = ans_right[i+1]*nums[i+1];
        }

        //利用下三角矩阵，计算ans数组的左半边
        for (int i = 1; i < len; i++) {
            ans_left[i] = ans_left[i-1]*nums[i-1];

        }

        for (int i = 0; i < len; i++) {
            ans_left[i]*=ans_right[i];
        }
        return ans_left;
    }
}
