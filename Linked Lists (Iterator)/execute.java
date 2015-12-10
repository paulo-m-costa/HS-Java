import java.io.*;
import java.util.*;

public class execute{
static int limit = 1123;
static int count = 0;

public static Comparable[] input(){
   Comparable largest[] = new Comparable[limit];
   int i = 0;
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Comparable s;
      s = br.readLine();
      while(i <= limit && s != null){
         largest[i]=s;
         i++;
         s = br.readLine();
      } 
      br.close();
   }
   catch(Exception e){
   System.out.println("Input failed: " + e);
   }
   Comparable data[] = new Comparable[i];
   for(int x = 0; x < i; x++){
      data[x] = largest[x];
   }
   return data;
}

public static void main(String args[]){
   Comparable[] given = input();
   int x;
   list manipulate = new list();
   for(x = 0; x < given.length; x++){
      manipulate.insert(given[x]);
   }
   Iterator iterate = manipulate.iterator(); 
   while(iterate.hasNext() == true){
      System.out.println(iterate.next());
   }
}
}