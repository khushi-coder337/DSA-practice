class Solution {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;
        }
    }
    public int[][] kClosest(int[][] arr, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
        int distSq = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
        pq.add(new Point(arr[i][0], arr[i][1], distSq,i));
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            Point p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}
