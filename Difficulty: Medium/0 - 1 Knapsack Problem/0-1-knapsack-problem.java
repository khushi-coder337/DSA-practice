class Solution {
    public int knap(int W, int val[], int wt[], int n, int[][] dp){//memoisation
        //base case
        if(W == 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){//valid
            int ans1 = val[n-1] + knap(W-wt[n-1], val, wt,n-1,dp);//include
            int ans2 = knap(W,val,wt,n-1,dp);//exclude
            dp[n][W] =  Math.max(ans1,ans2);
            return dp[n][W];
        }else{//not valid
            dp[n][W] =  knap(W,val,wt,n-1,dp);
            return dp[n][W];
        }
    }
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
       return knap(W,val,wt,val.length,dp);
    }
}
