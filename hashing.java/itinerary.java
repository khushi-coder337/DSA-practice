class Solution {//t.c->O(n)
    public String getStart(List<List<String>> tickets){
        HashMap<String,String> rev = new HashMap<>();

        for(List<String> key : tickets){
            rev.put(key.get(1),key.get(0));
        }

        for(List<String> key : tickets){
            String ele = key.get(0);
            if(!rev.containsKey(ele)){
                return ele;//single element of 1 part in a array
            }
        }
        return null;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        String start = getStart(tickets);
        List<String> ans = new ArrayList<>();
        HashMap<String,String> forwardPath = new HashMap<>();
        for(List<String> key  : tickets){
            forwardPath.put(key.get(0),key.get(1));
        }

        String curr = start;
        while(curr != null){
            ans.add(curr);
            forwardPath.get(curr);
        }
        return ans;
    }
}
