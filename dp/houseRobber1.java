class Solution {//t.c -> o(n)
    static int rec(int i, int[] nums, int n, int[] dp){
        //base case
        if(i >= n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = nums[i] + rec(i+2, nums, n , dp);
        int notTake = rec(i+1,nums,n,dp);

        int max = Math.max(take,notTake);
        dp[i] = max;
        return max;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = -1;
        }
        return rec(0,nums,n,dp);
    }
}
