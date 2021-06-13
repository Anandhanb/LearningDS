class SmallestPositiveMissingNumber
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        int res = 0;

        //Separate positive from negative numbers.
        int start =0;
        for(int i=0;i<size;i++){
            if(arr[i]<=0){
                reverseArr(arr,i,start);
                start++;
            }
        }
        int arr2[] = new int[size-(start)];
        int j = 0;
        for (int i = start; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }

        //Iterate over positive numbers segment and mark the index of positive elements as negative
        for(int i=0; i < j; i++){
            int x = Math.abs(arr2[i]);
            if(x-1 < j && arr2[x-1] > 0){
                arr2[x-1] = -arr2[x-1];
            }
        }
        
        //Iterate over positive numbers segment and print the first non-negative number
        for(int i=0; i< j; i++){
            if(arr2[i]>0){
                return i+1;
            }
        }
        
        return j+1;
    }
    static void reverseArr(int arr[], int start, int end){
        
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        
    }
}