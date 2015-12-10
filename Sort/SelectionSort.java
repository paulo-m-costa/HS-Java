//Paulo Costa
//10/1/2011
//Sorts an inputted set of strings of a specified size using the Selection Sort method. Selection Sort locates the string with the lowest value in the set and then places as the greatest sorted value on the sorted side of strings. It does this until there is only one string left in the unsorted side of strings. This method ensures the same number of comparisons for any set of the same size, regardless of the order of the strings.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionSort{

public static int count = 0;

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

public static void sort(String tosort[]){
   String newslot;
   for(int a = 0; a < tosort.length; a++){
      int smallest = a;
      for(int b = a + 1; b < tosort.length; b++){
      if(tosort[b].compareTo(tosort[smallest]) < 0)
         smallest = b;
         count++;
      }
      if(smallest != a){
         newslot = tosort[a];
         tosort[a] = tosort[smallest];
         tosort[smallest] = newslot;
      }
   }
}

public static void main(String args[]){
   int size = Integer.parseInt(args[0]);
   System.out.println('\n' + "Please input your array of size " + size + ": " + '\n');       
   String inputted[] = input(size);
   sort(inputted);
   System.out.println('\n' + "After sorting, the array is now: " + '\n');
   for(int j=0; j<inputted.length; j++){
      System.out.println(inputted[j]);
   }
   //System.out.println('\n' + "A total of " + count + " comparisons were made.");
}
}
