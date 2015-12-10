import java.io.*;
import java.util.*;
public class runner{
   public static String input(){
      String s = new String();
      try{
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         s = br.readLine();
         br.close();
      }
      catch(Exception e){
         System.out.println("An Error Occured." + e);
      }
      return s;
   }
   public static void main(String[] args){
      try{ 
         String input = input();
         tests test = new tests();
         translator Trans = new translator(input);
         String output;
         output = Trans.translate();
         double evaluated = evaluator.evaluate(output);
         System.out.println(output);
         System.out.println(evaluated);
      }
      catch(EndError end){
         System.out.println(end);
      }
      catch(OpError op){
         System.out.println(op);
      }
      catch(DubError d){
         System.out.println(d);
      }
      catch(ParenError p){
         System.out.println(p);
      }
      catch(ZeroError z){
         System.out.println(z);
      }
      catch (Exception e) {
         System.out.println("An Error Occured: Check Infix Expression.");
      }
   }
}