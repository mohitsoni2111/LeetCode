// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/

package Queue_and_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_islands {

    // ****************************************  DFS  *****************************************
    private int n;
    private int m;

    public void DFSMarking(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return ;

        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1'){
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    // ****************************************  BFS  *****************************************

    // int n = grid.length;
    // int m = grid[0].length;
    int[][] dirs = {{0,1}, {1,0} ,{0,-1}, {-1,0}};

    public void BFS(char[][] grid, Queue<int[]> queue, boolean[][] visited){
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || grid[x][y] == '0') continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    /*
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    BFS(grid, queue, visited);
                    count++;
                }
            }
        }
    }

    */
}
