import java.io.*;
import java.util.*;

public class execute{

public static list input(){
   list storage = new list();
   try{
      BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
      String s;
      s = br.readLine();
      while (s != null){
         storage.insert(s);
         s = br.readLine();
      }
      br.close();
   }
   catch (Exception e){
      System.out.println("An Error Occured:" + e);
   }
   return storage;
}

public static void main (String args[]){
   list inputted = input();
   inputted.sort();
   Iterator iter = inputted.iterator();
   Object t = iter.next();
   while(t != null){
      System.out.println(t);
      t = iter.next();
   }
}

}

