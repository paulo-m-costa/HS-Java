import java.io.*;
import java.util.*;

public class execute{

   private static String getValue(String line){
      int i = line.indexOf(' ');
      if(i < 0){
         return null;
      }
      String value = line.substring(i).trim();
      return value;
   }

   public static void print(node node){ 
      if(node == null) return;
      print(node.left); 
      if(node.d!=" ") System.out.print(node.d + "\n");
      print(node.right);
   }

   public static void BSTinput(){
      BST BST = new BST();
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("I - Insert, D - Delete, C - Check, P - Print, Q - Quit" + '\n');
         String line = br.readLine();
         while (line != null){
            String value = getValue(line);
            char c = line.charAt(0);
            if(c == 'i' || c == 'I'){
               BST.insert(BST.root, value);
            } 
            else if(c == 'c' || c == 'C'){
               if (BST.check(value)) {
                  System.out.println(value + " is in the tree.");
               }
               else {
                  System.out.println(value + " is NOT in the tree.");
               }
            }
            else if(c == 'd' || c == 'D'){
               BST.delete(BST.root, value);
            } 
            else if(c == 'p' || c == 'P'){
               print(BST.root);
            }
            else if(c == 'q' || c == 'Q'){
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
      BSTinput();
   }

}