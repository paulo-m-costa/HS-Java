import java.io.*;

public class Main{
   public static void main(String arg[]){
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Enter First String: ");
         Stringer str = new Stringer();
         str.setString(br.readLine());
         System.out.println("Expansion: " + str.expand());
         System.out.println("Rotation: " + str.rotate(str.toString()));
         System.out.println("Conversion: " + str.convert());
         System.out.print("Enter Second String: ");
         Stringer str2 = new Stringer();
         str2.setString(br.readLine());
         System.out.println("Conjoinment: " + str.conjoin(str,str2));
         br.close();
      }
      catch(Exception e){
         System.out.print("An Error Occured: " + e);
      }
   }
}	