class Solution {//t.c->o(n)
    static int distinct(int arr[]) {
       HashSet<Integer> set = new HashSet<>();
       for(int i=0; i<arr.length; i++){
           set.add(arr[i]);
       }
       return set.size();
    }
}
