class Solution {
    public static int minCost(int[] arr) {//t.c->o(n)
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=0; i<arr.length; i++){
           pq.add(arr[i]);
       }
       int cost = 0;
       while(pq.size() > 1){
           int a = pq.remove();
           int b = pq.remove();
           cost += a + b;
           pq.add(a+b);
       }
       return cost;
    }
}
