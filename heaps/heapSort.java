class Solution {
    // Function to sort an array using Heap Sort.
    public static void heapify(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        
        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        
        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
             heapify(arr,maxIdx,size);
        }
       
    }
    public void heapSort(int arr[]) {
      int n = arr.length;
      //step1 -> build a maxHeap
      for(int i=n/2; i>=0; i--){
          heapify(arr,i,n);
      }
      //Step 2 -> put largest element at the last
      for(int i=n-1; i>0; i--){
          //swaping
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;
          heapify(arr,0,i);
      }
    }
}
