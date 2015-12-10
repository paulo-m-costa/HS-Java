import java.io.*;
import java.math.*;
import java.util.*;

public class NSMB{

private static String getValue(String line){
   int x = line.indexOf(' ');
   if(x < 0){
      return null;
   }
   String value = line.substring(x).trim();
   return value;
}

public static void input(){
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line = br.readLine();
      while (line != null){
         int random = (int) (Math.random()*2);
         String value = getValue(line);
         char first = line.charAt(0);
         if(first == 'y' || first == 'Y'){
            if(random == 1){System.out.println("Correct. Dis nigga stole yo bike!");}
            else System.out.println("Wrong. Nigga stole yo fried chicken instead!"); 
         }
         else if(first == 'n' || first == 'N'){
            if(random == 0){System.out.println("Correct. Nigga stole yo fried chicken instead!");}
            else System.out.println("Wrong. Dis nigga stole yo bike!"); 
         }
         else System.out.println("What did you say NIGGAAAAAAAAA?!?");
         line = br.readLine();
      }
      br.close();
   }
   catch (Exception e){
      System.out.println("input failed: " + e);
      e.printStackTrace();
   }
}

public static void main(String args[]){
   System.out.println("Did dis nigga steal yo bike?");
   input();
}
}