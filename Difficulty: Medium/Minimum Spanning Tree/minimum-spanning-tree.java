class Solution {
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public int spanningTree(int V, int[][] edges) {
     boolean[] vis = new boolean[V];
     PriorityQueue<Pair> pq = new PriorityQueue<>();
     pq.add(new Pair(0,0));
     int finalCost = 0;
     
     while(!pq.isEmpty()){
         Pair curr = pq.remove();
         if(!vis[curr.v]){
             vis[curr.v] = true;
             finalCost += curr.cost;
             
             for(int i=0; i<edges.length; i++){
                 int u = edges[i][0];
                 int v = edges[i][1];
                 int wt = edges[i][2];
                 
                 if( u == curr.v){
                     pq.add(new Pair(v,wt));
                 }else if(v == curr.v){
                     pq.add(new Pair(u,wt));
                 }
                 }
             }
         }
         return finalCost;
     }
}
