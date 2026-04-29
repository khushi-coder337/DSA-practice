// User function Template for Java
class Solution {
    static int V;
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    static int[] par;
    static int[] rank;
    
    public static void init(int V){
        par = new int[V];
        rank = new int[V];
        for(int i=0; i<V; i++){
            par[i] = i;
        }
    }
    
    public static int find(int x){
        if(x == par[x]){
            return x;
        }else{
            return par[x] = find(par[x]);
        }
    }
    
    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        
       if(parA != parB){
           par[parA] = parB;
       }
    }
    static int kruskalsMST(int V, int[][] edges) {
        
       
       ArrayList<Edge> arr = new ArrayList<>(V);
       for(int[] edge : edges){
           arr.add(new Edge(edge[0],edge[1],edge[2]));
       }
       Collections.sort(arr);
       init(V);
       int mstCost = 0;
       int count = 0;
       
       for(Edge e : arr){
           if(count == V-1) break;
           
            int parA = find(e.src);
            int parB = find(e.dest);
            
            if(parA != parB){
                union(parA,parB);
                mstCost += e.wt;
                count++;
            }
       }
       return mstCost;
    }
}
