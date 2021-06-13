class RearrangeArrayO1
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n)
    {
        //Idea is we have to store both the values in same element.
        
        //Dividend = Divisor * Quotient + Remainder
        //where Divisor = size of array
        //   Quotient = New number at index i after rearrangement
        //   Remainder = Old Number at index i before rearrangement
        //   Dividend = The number stored at index i
        // While Traversing the array, we will Look for the value at arr[arr[i]] (which is to be stored at index i), 
        // multiply it with Divisor (size of array), and add the old value present at arr[i] to it.
        // Divisor is a value which is higher then values in array 
        // (in this case n - size of array, as array elements are between 0 to n-1)
       for(int i=0;i<n;i++){
           //For every index increment the element by array[array[index] ] % n. 
           //To get the ith element find the modulo with n, i.e array[index]%n.
           arr[i] += (arr[(int) arr[i]%n]%n)*n;
       }
       for(int i=0;i<n;i++){
           arr[i]=arr[i]/n;
       }
    }
}