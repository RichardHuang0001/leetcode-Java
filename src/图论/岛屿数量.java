package 图论;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int m=grid.length,n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!='1'){
                    continue;
                }
                count++;
                dfs(grid,i,j);
            }
        }
        return count;
    }
    //只能从陆地格子开始出发dfs方式标记相连的所有陆地格子
    public void dfs(char[][] grid,int x,int y){
        if(x<0||x>= grid.length||y<0||y>=grid[0].length||grid[x][y]!='1'){
            return;
        }
        grid[x][y] = '2';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}
