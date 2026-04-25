class Solution {
    public int orangesRot(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int timer = 0;
        while(!q.isEmpty()){
            int[] arr = q.remove();
            int r = arr[0], c = arr[1],d = arr[2];
            timer = Math.max(timer,d);
            if(r-1 >= 0 && grid[r-1][c] == 1){
            q.add(new int[]{r-1,c,d+1}); grid[r-1][c] = -1;
            }
            if(r+1 < row && grid[r+1][c] == 1){
            q.add(new int[]{r+1,c,d+1}); grid[r+1][c] = -1;
            }
            if(c-1 >= 0 && grid[r][c-1] == 1){
            q.add(new int[]{r,c-1,d+1}); grid[r][c-1] = -1;
            }
            if(c+1 < col && grid[r][c+1] == 1){
            q.add(new int[]{r,c+1,d+1}); grid[r][c+1] = -1;
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return timer;
    }
}