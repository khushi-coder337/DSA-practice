// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
       int INF = (int)1e8;//10 to the power 8
       int[]dist = new int[V];
       Arrays.fill(dist,INF);
       dist[src] = 0;
       
       for(int i=0; i<V; i++){
           boolean updated = false;
           for(int[]edge : edges){
               int u = edge[0],v=edge[1],wt = edge[2];
               if(dist[u] != INF && dist[u] + wt < dist[v]){
                   dist[v] = dist[u] + wt;
                   updated  = true;
               }
           }
           if(!updated) break;
       }
       for(int[]edge : edges){
           int u = edge[0],v = edge[1],wt = edge[2];
           if(dist[u] != INF && dist[u] + wt < dist[v]){
            return new int[]{-1};
       }
    }
     return dist;
    }
}
