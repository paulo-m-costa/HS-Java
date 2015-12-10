public class fred{
   static int paths = 0;
   public static void jumps(int a,int b,String step){
      if(a==b){
      System.out.println(step); paths++;
      }
      if(a<b){
      jumps(a+1,b,step+1); jumps(a+2,b,step+2); jumps(a+3,b,step+3);
      }
   }
   public static void main(String decisions[]){
      Integer c = Integer.valueOf(decisions[0]);
      jumps(0,c,"");
      System.out.println("Number of possible paths for Freddy: " + paths);
   }
}