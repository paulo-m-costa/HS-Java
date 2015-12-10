//Paulo Costa
//10/18/2011
//Quick Sort sorts inputted data using a divide-and-conquer method. The following code employs Lomuto partitioning, in which the rightmost value is selected as the pivot. Values smaller or equal to the pivot are placed on the left; larger values to the right. This process is continuously repeated via recursion until the unsorted 'partitions', or array segments, are of size 1 or 0 (i.e. not requiring sorting). A third and final method is used to call the recursive method in order to initiate the sorting. 

public static int partition(Comparable[] arraybit, int left, int right) {
   Comparable pivot = arraybit[right];
   Comparable temp;
   int i = left - 1;
   for(int j = left; j < right; j++){		
      if(arraybit[j].compareTo(pivot) <= 0) {
         i++;
         temp = arraybit[i];
         arraybit[i] = arraybit[j];
         arraybit[j] = temp;
      }
   count++;
   }
   temp = arraybit[i + 1];
   arraybit[i + 1] = arraybit[right];
   arraybit[right] = temp;
   return i + 1;
}

public static void RecurQS(Comparable[] array, int L, int R){   
   if(R - L > threshold){
      int m = partition(array, L, R);
      RecurQS(array, L, m - 1);
      RecurQS(array, m + 1, R);
   }
   else{
      InsertionSort(array, L, R);
   }
}

public static void QS(String array[]){
   RecurQS(array, 0, array.length - 1);
}