package 回溯;

import 二叉树.从前序与中序遍历序列构造二叉树;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int m = board.length,n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int x,int y,int index){
        //如果坐标越界，或者坐标位置与word index位置不匹配，返回false
        if((x<0||x>=board.length) || (y<0||y>=board[0].length) || board[x][y]!=word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){//如果匹配，且长度已经走完，返回true
            return true;
        }
        //继续向四个方向找下一个匹配
        char temp = board[x][y];
        board[x][y] = '0';
        boolean found = dfs(board,word,x-1,y,index+1)||
                dfs(board,word,x+1,y,index+1)||
                dfs(board,word,x,y-1,index+1)||
                dfs(board,word,x,y+1,index+1);
        board[x][y] = temp;//回溯回来记得撤销选择
        return found;
    }
}
