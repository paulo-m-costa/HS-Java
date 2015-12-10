import java.io.*;

public class animal{

public static void treeInput(){
   tree t = new tree();
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      boolean game = true;
      while(game){
         t.restart();
         System.out.println("Give me your best shot! Think of any animal!");
         System.out.println(t.returnRoot());
         boolean inSession = true;
         while(inSession){
            String line = br.readLine();
            if(line != null){
               if(t.gety() == null && t.getn() == null){
                  if(line.toLowerCase().charAt(0) == 'y'){
                     System.out.println("Thou mind hath been readeth.");
                     inSession = false;
                  }
                  else{
                     System.out.println("Darn it! What animal were you thinking of?");
                     String anim = br.readLine();
                     if(anim == null){
                        System.out.println("Sorry to disappoint. Please come back soon.");
                        System.exit(0);
                     }
                     System.out.println("What differentiates a(n) " + anim + " from a(n) " + t.returnTrack() + '?');
                     String diff = br.readLine();
                     if(diff == null){
                        System.out.println("Sorry to disappoint. Please come back soon.");
                        System.exit(0);
                     }
                     t.makeNode(diff, anim);
                     inSession = false;
                     }
                  }
                  else{
                     if (line.toLowerCase().charAt(0) == 'y'){
                        t.yes();
                        if(t.gety() == null || t.getn() == null){
                           System.out.println("Are you thinking of a(n) " + t.returnTrack() + "?");
                        }
                        else{
                           System.out.println(t.returnTrack());
                        }
                     }
                     else if(line.toLowerCase().charAt(0) == 'n'){
                        t.no();
                        if(t.gety() == null || t.getn() == null){
                           System.out.println("Are you thinking of a(n) " + t.returnTrack() + "?");
                        }
                        else{
                           System.out.println(t.returnTrack());
                        }
                     }
                     else{
                        System.out.println("Seriously? Please respond with yes or no.");
                     }
                  }
               }
               else{
                  inSession = false; 
                  System.out.println("Sorry to disappoint. Please come back soon.");
                  System.exit(0);
               }
            }
            if(inSession = true){
               System.out.print('\n');
               game = true;
            }
         }
         br.close();
      }
      catch (Exception e){
         System.out.println("input failed: " + e);
      }
   }
   public static void main(String[] args){
      treeInput();
   }
}