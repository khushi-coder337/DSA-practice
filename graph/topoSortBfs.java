class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] graph) { //t.c -> O(V+E)
        //using bfs
        ArrayList<Integer> ans = new ArrayList<>();
        int [] inDeg = new int[V];
        
        for(int i=0; i<graph.length; i++){
            int v = graph[i][1];
            inDeg[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);//add curr
            
            for(int i=0; i<graph.length; i++){
                if(graph[i][0] == curr){
                    int v = graph[i][1];
                    inDeg[v]--;
                    
                    if(inDeg[v] == 0){
                        q.add(v);
                    }
                }
            }
        }
        return ans;
    }
}
