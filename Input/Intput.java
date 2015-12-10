import java.io.*;

public class Intput{
   public static int input(){
   int i = 0;
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      i = Integer.parseInt(s);
      br.close();
   }
   catch(Exception e){
      System.out.println("Input failed: " + e);
   }
   return i;
   }
   public static void main(String args[]){
      System.out.print("Enter the number you want to generate up to: ");
      int in = input();
      for(int start = 0; start <= in; start++){
         System.out.println(start);
      }
   }  
}