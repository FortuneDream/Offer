package search;

//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
//
//        我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
//
//        如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
//
//涂色问题：每个点的初始访问时val=1，dfs访问设置矩阵[i][j]=1，这里需要去除延伸到边界的路，如果有一个DFS的下一个节点超过边界，那么说明这个节点就在边界上，
// 在边缘就表示val=0，并返回
public class CloseIsLand {
    private int val = 1;

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    val = 1;
                    DFS(grid, i, j);
                    count += val;
                }
            }
        }
        return count;
    }

    public void DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) { //有一条路延伸触碰边界，那就不再是封闭的路了，可以判定无效
            val = 0;
            return;
        }
        if (grid[i][j] == 1) return;
        grid[i][j] = 1;
        DFS(grid, i + 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i - 1, j);
        DFS(grid, i, j - 1);
    }
}
