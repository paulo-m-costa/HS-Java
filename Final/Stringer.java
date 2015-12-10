import java.util.*;

public class Stringer{
   String string;
   public Stringer(){
      string = "";
   }
   public Stringer(String newString){
   string = newString;
   }
   public Stringer(Stringer s){
      string = s.toString();
   }
   public String toString(){
      return string;
   }
   public void setString(String a){
      string = a;
   }
   public Stringer expand(){
      Stringer n = new Stringer();
      String newStr = "";
      String firstChar = string.substring(0,1);
      for(int x=0; x<string.length(); x++){
         if((string.substring(x,x+1)).equals(firstChar)){
            newStr = newStr + firstChar + firstChar;
         }
         else newStr = newStr + string.substring(x,x+1);
      }
      n.setString(newStr);
      return n;
   }
   public Stringer rotate(String a){
      Stringer newStringer = new Stringer(a);
      String str = newStringer.toString();
      int x = str.length()-1;
      String lastChar = str.substring(x,x+1);
      while(x>0 && (str.substring(x-1,x)).equals(lastChar)){
         x--;
      }
      newStringer.setString(str.substring(x,str.length())+str.substring(0,x));
      return(newStringer);
   }
   public Stringer conjoin(Stringer a, Stringer b){
      Stringer newStringer = new Stringer();
      String aStr = a.toString();
      String bStr = b.toString();
      if((aStr.substring(aStr.length()-1,aStr.length()).equals(bStr.substring(0,1)))){
         aStr = aStr.substring(0,aStr.length()-1);
         bStr = bStr.substring(1,bStr.length());
      }
      newStringer.setString(aStr+bStr);
      return newStringer;
   }
   public Stringer convert(){
      String conversion = "";
      Stringer newStringer = new Stringer();
      String str = toString();
      ArrayList letters = new ArrayList();
      for(int i=0; i<str.length(); i++){
         String letter = str.substring(i,i+1);
         if(!(letters.contains(letter))){
            letters.add(letter);
         }
      }
      System.out.println(letters);
      for(int i=0; i<str.length(); i++){
         for(int j=0; j<letters.size(); j++){
            if(letters.get(j).equals(str.substring(i,i+1))){
               conversion = conversion + letters.get((j+1)%letters.size());
            }
				
         }
      }
      newStringer.setString(conversion);
      return newStringer;
   }	
}
			