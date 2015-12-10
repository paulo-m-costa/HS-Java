import java.io.*;
import java.util.*;

public class UI{

private static String getValue(String line){
   int x = line.indexOf(' ');
   if(x < 0){
      return null;
   }
   String value = line.substring(x).trim();
   return value;
}

public static void UIinput(){
   dlist manipulate = new dlist();
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("I - Insert, D - Delete, C - Check, P - Print, Q - Quit" + '\n');
      String line = br.readLine();
      while (line != null){
         String value = getValue(line);
         char first = line.charAt(0);
         if(first == 'i' || first == 'I'){
            manipulate.insert(value);
         }
         else if(first == 'c' || first == 'C'){
            if(manipulate.check(value) == true){
               System.out.println(value + " is in the list.");
            }
            else{
               System.out.println(value + " is NOT in the list.");
            }
         }
         else if(first == 'd' || first == 'D'){
            manipulate.delete(value);
         }
         else if(first == 'p' || first == 'P'){
            Iterator iterate = manipulate.iterator();
            while(iterate.hasNext()){
               System.out.println(iterate.next());
            }
         }
         else if(first == 'q' || first == 'Q'){
            System.out.println("The program will now terminate.");
            System.exit(0);
         }
         else System.out.println("I do not comply. Please enter a valid command.");
         line = br.readLine();
      }
      br.close();
   }
   catch (Exception e){
      System.out.println("input failed: " + e);
      e.printStackTrace();
   }
}

public static void main(String[] args){
   UIinput();
}

}
