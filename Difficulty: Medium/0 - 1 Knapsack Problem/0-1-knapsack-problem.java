class Solution {
    static int rec(int W, int val[], int[] wt){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;//items row
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;//weight col
        }
        //tabulation code
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1]; //item val
                int w = wt[i-1]; // weight val
                if(w <= j){//valid
                    int include = v + dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }else{//include
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[n][W];
    }
    public int knapsack(int W, int val[], int wt[]) {
        return rec(W,val,wt);
    }
}
