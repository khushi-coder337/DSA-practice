class Solution {//t.c = 0(4k) -> o(1), sc -> 0(1)
     int[] par;
     int[] rank;
    public int find(int x){
        if(x == par[x]){
            return x;
        }else{
            return par[x] = find(par[x]);//path compression
        }
    }
    
    public void union(int a, int b) {
    int parA = find(a);
    int parB = find(b);
    if (parA != parB) {
        // Strictly make the second element's root the new parent
        par[parA] = parB;
    }
}
    // public void union(int a , int b){
    //     int parA = find(a);
    //     int parB = find(b);
    //     if(parA != parB){//if they are not equal
    //     if(rank[parA] == rank[parB]){
    //         par[parB] = parB;
    //     }else if(rank[parA] < rank[parB]){
    //         par[parA] = parB;
    //     }else{
    //         par[parB] = parA;
    //     }
    //   }
    // }
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        par = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<=n; i++){
            par[i] = i;
            rank[i] = 0;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] query : queries){
            int type = query[0];
            //find 1 for union
            if(type == 1){
                union(query[1],query[2]);
            }else if(type == 2){//for find
                ans.add(find(query[1]));
            }
        }
        return ans;
    }
}
