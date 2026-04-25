class Solution {
    public int findPath(ArrayList<ArrayList<Integer>> adj, int src, int dest){
        int count = 0;
        if(src == dest){
            return 1;
        }
       for(int neigh : adj.get(src)){
           count += findPath(adj,neigh,dest);
       }
       return count;
    }
    public int countPaths(int[][] edges, int V, int src, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        return findPath(adj,src,dest);
        
    
    }
}
