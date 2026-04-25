class Solution {
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; // path based sorting
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
         // 1. Convert Edge List to Adjacency List (Required for V = 10^6)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt}); // Use if undirected
        }

        // 2. Standard Dijkstra logic
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.n;

            if (curr.path > dist[u]) continue; // Optimization

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int wt = neighbor[1];

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
