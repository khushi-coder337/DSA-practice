class Solution {//t.c -> O(n)
    public int countWays(int n, int[] ways){
        if(n < 0) return 0;
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        return countWays(n,ways);
    }
}
