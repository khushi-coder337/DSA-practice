class Solution {//t.c -> O(n+m)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet<>();
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
          // Convert HashSet<Integer> to int[]
        int[] ans = new int[res.size()];
        int index = 0;
        for (int val : res) {
            ans[index++] = val;
        }
        return ans;
    }
}
