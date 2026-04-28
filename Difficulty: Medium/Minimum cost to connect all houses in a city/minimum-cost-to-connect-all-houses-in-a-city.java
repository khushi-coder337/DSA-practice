class Solution {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        public Edge(int dest,int cost){
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost;
        }
    }
    public int minCost(int[][] houses) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean [] vis = new boolean[houses.length];
        pq.add(new Edge(0,0));
        int finalCost = 0;
        int count = 0; //need a count to track vertices
        while(!pq.isEmpty() && count  < houses.length){
            Edge curr = pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost += curr.cost;
                count++;
                
                // Use 'i' to represent the index of the next house
            for(int i = 0; i < houses.length; i++){
                if(!vis[i]){
                    // Calculate distance between house 'curr.dest' and house 'i'
                    int dist = Math.abs(houses[curr.dest][0] - houses[i][0]) + 
                               Math.abs(houses[curr.dest][1] - houses[i][1]);
                    pq.add(new Edge(i, dist));
                }
            }
            }
        }
        return finalCost;
    }
}
