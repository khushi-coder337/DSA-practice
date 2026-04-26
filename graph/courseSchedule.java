class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Step 1 : build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];//courses
            int v = pre[1];//prerequistics
            adj.get(v).add(u);//edge from v to u
        }
        //step 2 : compute in degress
        int[] inDegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neighbour : adj.get(i)){
                inDegree[neighbour]++;
            }
        }
        //step 3 : add courses to 0 indegree to quote
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        //step 4 : topological sort
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;

            for(int neighbour : adj.get(curr)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return (count == numCourses);
    }
}
