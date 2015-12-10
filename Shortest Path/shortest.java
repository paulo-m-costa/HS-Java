//Paulo Costa
//3/16/2012
//Class that determines the path of shortest distance from a starting node to an ending one using a priority queue.

import java.util.*;
import java.io.*;

public class shortest implements Iterable{ //breadth-first traversal that takes into account weighting.
   static node[] paths;
   PQ next;
   int[][] DAJM;
   static Stack in;
   public shortest(int[][] AJM, int start){ //constructor method.
      in = new Stack();
      node starter = new node(0, start);
      paths = new node[20]; //creates array to hold path.
      next = new PQ();
      DAJM = AJM;
      next.insert(starter);
      paths[start]= new node(0, null);
   }
   public Iterator iterator(){ //iteration method.
      return new shortIter();
   }
   public class shortIter implements Iterator{
      public Object next(){ //carries out the traversal.
         int next1 = (Integer)next.peek().getName();
         for(int b = 0; b < DAJM[next1].length; b++){
            if(DAJM[next1][b] != 0 && DAJM[next1][b] != ' '-'0' && (paths[b] == null || paths[b].getWeight().compareTo((Integer)next.peek().getWeight() + DAJM[next1][b]) > 0)){
               node enter = new node((Integer)next.peek().getWeight() + DAJM[next1][b], b);
               next.insert(enter);
               node original = new node(enter.getWeight(), next1);
               paths[b] = original;
            }
         }
         return next.pop();		
      }
      public boolean hasNext(){ //determines if the queue is empty or not.
         return (!next.isEmpty());
      }
      public void remove(){ //default method that must be defined but is not used.
      }
   }
   public static int getStart(String[] s) { //obtains the starting point and returns it as an integer.
      char b = s[10].charAt(0);
      switch (b){case 'A': return 0; case 'B': return 1; case 'C': return 2; case 'D': return 3; case 'E': return 4; case 'F': return 5; case 'G': return 6; case 'H': return 7; case 'I': return 8; case 'J': return 9; case 'K': return 10; case 'L': return 11; case 'M': return 12; default: return 13;}
   }
   public static int getEnd(String[] s){ //obtains the ending point and returns it as an integer.
      char c = s[10].charAt(1);
      switch (c){case 'A': return 0; case 'B': return 1; case 'C': return 2; case 'D': return 3; case 'E': return 4; case 'F': return 5; case 'G': return 6; case 'H': return 7; case 'I': return 8; case 'J': return 9; case 'K': return 10; case 'L': return 11; case 'M': return 12; default: return 13;}
   }
   public static int[][] convert(String[] AJML){ //translates inputted array into an adjacency matrix.
      int row; int col;
      int AJM[][] = new int[AJML.length + 1][AJML[0].length() + 1];
      for (row = 0; row < AJML.length; row++){
         for (col = 0; col<AJML[row].length(); col++){ 
            AJM[row][col]=AJML[row].charAt(col)-'0';
         }
         col = 0; //moves back to first column.
      }
      return AJM;
   }
   public static char output(int i){ //translates nodes from integers back into characters.
      switch(i){case 0: return 'A';case 1: return 'B';case 2: return 'C';case 3: return 'D';case 4: return 'E'; case 5: return 'F'; case 6: return 'G'; case 7: return 'H'; case 8: return 'I'; case 9: return 'J'; case 10: return 'K'; case 11: return 'L'; case 12: return 'M'; default: return 'N';}
   }
   public static String[] input(){ //input method.
      String array[] = new String[2001];

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

         e.printStackTrace();
      }

      String[] smallarray = new String[i];

      for (int j = 0; j < i; j++){

         smallarray[j]=array[j];

      }

      return smallarray;

   }	
   public static void print(int end){ //printing method.
      char endNode = output(end);
      if(paths[end] == null){
         System.out.println("There are no possible traversals.");
         System.exit(0);
      }
      while(paths[end].getName() != null){
         in.insert(output((Integer)paths[end].getName()));
         end = (Integer)paths[end].getName();
      }
      while(!in.isEmpty()){
         System.out.print(in.pop());
      }
      System.out.println(endNode);
   }
   public static void main(String[] args){
      String[] input = input();
      int start = getStart(input);
      int end = getEnd(input);
      if (start == end){
         System.out.println("No traversal is necessary.");
         System.exit(0);
      }
      int[][] AJM = convert(input);
      shortest SP = new shortest(AJM, start);
      Iterator SPI = SP.iterator();
      while (SPI.hasNext()){
         SPI.next();
      }
      System.out.print("Shortest traversal from " + output(start) +" to " + output(end) + ": ");
      print(end);
      if(end == 8) paths[end].setWeight((Integer)paths[end].getWeight()-1);
      System.out.println("Optimal Distance: " + (Integer)paths[end].getWeight()); 
   }
}		