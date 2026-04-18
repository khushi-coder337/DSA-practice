class Solution {
    int maxLength(int arr[]) {//t.c ->O(n)
        HashMap<Integer,Integer> map = new HashMap<>();
        //if starting point is 0 then add -1
        map.put(0,-1);
        //sum,idx
        int sum = 0;
        int len = 0;
        
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len,j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }
        return len;
    }
}
