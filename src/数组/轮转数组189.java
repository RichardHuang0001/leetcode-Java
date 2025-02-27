package 数组;

public class 轮转数组189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k>=len){
            k = k%len;
        }
        int[] res = new int[len];
        int j=0;
        for(int i =len-k;i<len;i++,j++){
            res[j] = nums[i];
        }//把后面的k个数写入新数组
        for(int i = 0;i<len-k;i++,j++){
            res[j] = nums[i];
        }
        for(int i = 0;i<len;i++){
            nums[i] = res[i];
        }
    }
}
