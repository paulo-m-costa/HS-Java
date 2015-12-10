//Paulo Costa
//1/15/2012
//Class to handle inputted graphs and perform Depth-First searching to traverse all relevant nodes.

import java.io.*;
import java.util.*;

class DF implements Iterable{
   public boolean[] marker; //keeps track of visited nodes.
   Stack NextPlace;
   int[][] AdjMat2;	
   public DF(int[][] AdjMat, int start){ //constructor for handling input.
      marker = new boolean[13];
      for(int count = 0; count < marker.length; count++){
         marker[count] = false;
      }
      NextPlace = new Stack();
      AdjMat2 = AdjMat;
      NextPlace.add(start);
      marker[start] = true;
   }
   public Iterator iterator(){ //constructor for Depth-First exploration.
      return new DFE();
   }
   public class DFE implements Iterator{ //Depth-First search algorithm.
      public Object next(){ //determines the next node to visit.
         int next1 = (Integer)NextPlace.peek();
         int b = 0;
         if(AdjMat2[next1][b] == 1 && marker[b] == false){
               next1 = b;
               NextPlace.add(b);
               marker[b] = true;
         }
         else{ 
            b++;
         }
         return NextPlace.pop();		
      }
      public boolean hasNext(){ //determines if there are nodes left to visit.
         return !NextPlace.isEmpty();
      }
      public void remove(){} //empty method as it is not needed.
   }
   public static String[] input(){ //reads the input.
      String array[] = new String[1123];

      int i = 0;

      try{

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         String s;

         s = br.readLine();

         while(s != null && i < array.length){

            array[i] = s;

            s = br.readLine();

            i++;

         }

         br.close();

      }

      catch (Exception e){

         System.out.println("An Error Occurred.");

      }

      String[] returned = new String[i];

      for(int q = 0; q < i; q++){

         returned[q]=array[q];

      }

      return returned;

   }
   public static int start(String[] a){ //obtains the starting location and translates it from character to integer.
      char ch = a[13].charAt(0);
      switch(ch){
         case 'A': return 0; case 'B': return 1; case 'C': return 2; case 'D': return 3; case 'E': return 4; case 'F': return 5; case 'G': return 6; case 'H': return 7; case 'I': return 8; case 'J': return 9; case 'K': return 10; case 'L': return 11; case 'M': return 12; default: return 13;
      }
   }
   public static int[][] convert(String[] AdjMat3){ //converts the inputted graph into an adjacency matrix.
      int row;
      int col;
      int AdjMat[][] = new int[AdjMat3.length+1][AdjMat3[0].length()+1];
      for(row = 0; row < AdjMat3.length; row++){
         for(col = 0; col < AdjMat3[row].length(); col++){
            AdjMat[row][col] = AdjMat3[row].charAt(col)-'0';
         }
      col = 0;
      }
      return AdjMat;
   }
   public static char output(int a){ //translates the integer string into a character string for output.
      switch(a){
         case 0: return 'A'; case 1: return 'B'; case 2: return 'C'; case 3: return 'D'; case 4: return 'E'; case 5: return 'F'; case 6: return 'G'; case 7: return 'H'; case 8: return 'I'; case 9: return 'J'; case 10: return 'K'; case 11: return 'L'; case 12: return 'M'; default: return 'N';
      }
   }	
   public static void main(String[] args){
      String[] in = input();
      int st = start(in);
      int[][] AdjMat = convert(in);
      DF DFE1 = new DF(AdjMat, st);
      Iterator Fpath = DFE1.iterator();
      System.out.print("Depth-First Search: ");
      while(Fpath.hasNext()){
         int x = (Integer)Fpath.next();
         char out = output(x);
         System.out.print(out);
      }
   }	
}