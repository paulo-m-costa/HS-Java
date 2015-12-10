import java.util.*;
import java.io.*;

public class Concordance{

   static ArrayList AL = new ArrayList();
   static TreeMap <String, String> TM = new TreeMap <String, String> ();

   public static void CInput(){
      int count = 1;
      try{	
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s;
         int max = 0;
         s = br.readLine();	
         while(s != null){
            StringTokenizer tokenator = new StringTokenizer(s);
            while (tokenator.hasMoreTokens()) {
               String next = tokenator.nextToken();
               next = next.toLowerCase();
               while(next.length() > max){
                  max = next.length();
               }
               if(AL.contains(next) == false) AL.add(next);
               MakeTM(next, count);
            }
            s = br.readLine();	
            count++;
         }
         Collections.sort(AL);
         System.out.println('\n' + "Concordance:" + '\n');
         while(AL.isEmpty() == false){
            String inputted = (String)AL.get(0);
            while(inputted.length() < max){
               inputted = " "  + inputted;
            }
            System.out.print(inputted + " : ");
            System.out.println(TM.get(AL.get(0)));
            AL.remove(0);
         }
      }
      catch (Exception e){
         System.out.println("An Error Occured");
      }
   }

   public static void MakeTM(String s, int num){
      String value;
      String previous = Integer.toString(num);
      if(TM.containsKey(s) == true){
         value = TM.get(s);
         if(value.charAt(value.length() - 1) == Character.forDigit(num,10)){
            value = TM.get(s) + "(2)";
         }
         else if(value.charAt(value.length() - 1) == ')' && value.charAt(value.length() - 4) == Character.forDigit(num,10)){
            char c =  (char) (value.charAt(value.length() - 2) + 1);
            value = value.substring(0, value.length() - 2) + c + ")";
         }
         else{
            value = TM.get(s) + ", " + previous;
         }
         TM.put(s, value);
      }
      else{
         TM.put(s, previous);
         return;
      }
   }

   public static void main(String[] args){
      System.out.println('\n' + "Enter stuff to be concorded:" + '\n');
      CInput();	
   }

}
