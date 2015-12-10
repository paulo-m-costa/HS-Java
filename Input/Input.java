import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input{
static int limit = 2001;
   public static void main(String args[]){
   String infile[] = new String[limit];
   try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine(); int i=0;
      while(s!=null&&i<infile.length){
         infile[i]=s;
         s = br.readLine();
      }
      br.close();
   }
   catch(Exception e){
   System.out.println("Input failed: " + e);
   }
   }  
}