import java.io.*;

public class prefix{
   static int limit = 1123;
   static int i = 0;
   public static char[] input(){
   char[] d = new char[limit];
    try{
         BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
         String b = key.readLine();
         int c = 0;
         
         while(c < b.length()){
            d[c] = b.charAt(c);
            c++;
         }
         key.close();
         return d;
      }
      catch(Exception e){
         System.out.println("input failed: " + e);
         e.printStackTrace();
      }
      return d;
   }
   public static double eval(){
      char[] ent = input();
      char c = ent[i];
      i++;
      if(c == '+'){
         return eval() + eval();
      }
      if(c == '-'){
         return eval() - eval();
      }
      if(c == '*'){
         return eval() * eval();
      }
      if(c == '/'){
         return eval() / eval();
      }
      return c;
   }
   public static void main(String args[]){
      System.out.println(eval());
   }
}