package 图论;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子994 {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ans = -1;
        int fresh = 0;

        // 添加所有烂橘子入队
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(grid, i, j) == 2) { // 烂橘子
                    q.offer(new int[]{i, j});
                } else if (check(grid, i, j) == 1) {
                    fresh++;
                }
            }
        }

        // 如果没有新鲜橘子，直接返回0
        if (fresh == 0) return 0;

        while (!q.isEmpty()) {
            int layerCount = q.size();
            ans++;
            for (int i = 0; i < layerCount; i++) {
                int[] position = q.poll(); // 烂橘子出队
                int x = position[0], y = position[1];

                // 将其四周的新鲜橘子入队，并标记它为烂橘子
                if (check(grid, x - 1, y) == 1) {
                    q.offer(new int[]{x - 1, y}); // 修正了这里的语法错误，缺少右括号
                    fresh--;
                    grid[x - 1][y] = 2;
                }
                if (check(grid, x + 1, y) == 1) {
                    q.offer(new int[]{x + 1, y});
                    fresh--;
                    grid[x + 1][y] = 2;
                }
                if (check(grid, x, y - 1) == 1) {
                    q.offer(new int[]{x, y - 1});
                    fresh--;
                    grid[x][y - 1] = 2;
                }
                if (check(grid, x, y + 1) == 1) {
                    q.offer(new int[]{x, y + 1});
                    fresh--;
                    grid[x][y + 1] = 2;
                }
            }
        }

        if (fresh > 0) {
            return -1;
        } else {
            return ans;
        }
    }

    public int check(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0; // 0表示不在范围内
        } else {
            return grid[x][y];
        }
    }
}