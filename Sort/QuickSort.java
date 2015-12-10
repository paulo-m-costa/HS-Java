//Paulo Costa
//10/18/2011

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;

public class QuickSort{

public static int count = 0;
public static int threshold = 0;

public static String[] input(int x){
   String infile[] = new String[x];
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s; int i=0;
      while(i<infile.length){
	 s = br.readLine();
         infile[i]=s;
         i++;
      } 
      br.close();
   }
   catch(Exception e){
   System.out.println("Input failed: " + e);
   }
   return infile;
} 

public static void InsertionSort(Comparable[] tosort, int first, int last){
   Comparable newslot;
   for(int a = first; a <= last; a++){
      newslot = tosort[a];
      int b = a - 1;
      while(b >= first && newslot.compareTo(tosort[b]) < 0){
            tosort[b + 1] = tosort[b];
            b--;
            count++;
      }
      tosort[b + 1] = newslot;
      if (b >= first){
         count++;
      }
   }
}

public static int partition(Comparable[] arraybit, int left, int right) {
   Comparable pivot = arraybit[right];
   Comparable medianpivot = arraybit[(left + right)/2];
   int random = (int) (Math.random()*(right-left)) + left;
   Comparable randompivot = arraybit[random];
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

public static void main(String args[]){
   int size = Integer.parseInt(args[0]);
   //System.out.println('\n' + "Please input your array of size " + size + ": " + '\n');       
   String inputted[] = input(size);
   QS(inputted);
   //System.out.println('\n' + "After sorting, the array is now: " + '\n');
   for(int j = 0; j < inputted.length; j++){
      System.out.println(inputted[j]);
   }
   System.out.println('\n' + "A total of " + count + " comparisons were made.");
}
}