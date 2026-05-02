class Solution {//t.c -> O(n*m)
    static int rec(int i, int j, int[][] dp, int n, int m, int prev , int mat[][]){
        //base case
        if(i < 0 || i == n || j < 0 || j == m || mat[i][j] <= prev){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int top = rec(i-1,j,dp,n,m,mat[i][j],mat);
        int down = rec(i+1,j,dp,n,m,mat[i][j],mat);
        int left = rec(i,j-1,dp,n,m,mat[i][j],mat);
        int right = rec(i,j+1,dp,n,m,mat[i][j],mat);

        int ans = 1 + Math.max(left,Math.max(right,Math.max(top,down)));
        dp[i][j] = ans;
        return ans;
    }
    public int longestIncreasingPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(max, rec(i,j,dp,n,m,-1,mat));
            }
        }
        return max;
    }
}
