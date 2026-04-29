class Solution {
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v, int cost, int stops){
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[0], flight[1], flight[2]));
        }
        int[] dist  = new int[n];
        for(int i=0; i<n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                continue;
            }
            for(int i=0; i<graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dst;
                int wt = e.wt;
                if(curr.cost + wt < dist[v]){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }
    }
}
