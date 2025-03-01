package 贪心算法;

public class 跳跃游戏55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len<=1){
            return true;
        }
        int longest=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0){
                return false;
            }
            longest = Math.max(nums[i]+i,longest);
            if(longest >=len-1){
                return true;
            }else{
                i += nums[i];
            }
        }
        return false;
    }
}
