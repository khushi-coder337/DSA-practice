class Solution {
    public static TreeNode createBST(int[] arr, int si, int ei){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr,si,mid-1);
        root.right = createBST(arr,mid+1,ei);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] arr) {
        return createBST(arr,0,arr.length-1);
    }
}
