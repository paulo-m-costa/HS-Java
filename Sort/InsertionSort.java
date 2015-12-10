//Paulo Costa
//10/1/2011
//Sorts an inputted set of strings of a specified size using the Insertion Sort method. Insertion Sort sorts strings by comparing the next string with those previously sorted and then placing it in the appropriate position. It does this for every single string until the the set is fully sorted. The number of comparisons made using this method varies extensively based on the order of the inputted strings.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort{

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
   for(int a = 1; a < tosort.length; a++){
      newslot = tosort[a];
      int b = 0;
      for(b = a; b > 0; b--)
         if(newslot.compareTo(tosort[b - 1]) < 0){
            tosort[b] = tosort[b - 1];
            count++;
         }
            else{ 
            count++;
            break;
         }
         tosort[b] = newslot;
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
