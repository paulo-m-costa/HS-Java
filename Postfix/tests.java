import java.util.*;
public class tests{
   public static boolean isOperator(char yy){
      if(!translator.integerCheck(yy) && yy!='(' && yy!=')') return true;
      else return false;
   }
   public static boolean endChecks(String trex2){
      int ghb=trex2.length()-1;
      if(isOperator(trex2.charAt(ghb)) || isOperator(trex2.charAt(0))) return false;
      else return true;
   }
   public static boolean opChecks(String asd){
      int xx=0;
      int test2=0;
      while(xx<asd.length()-2){
         if(isOperator(asd.charAt(xx)) && isOperator(asd.charAt(xx+1))) test2++;
         xx++;
      }
      if(test2==0) return true;
      else return false;
   }
   public static boolean dubChecks(String qwerty){
      char char3;
      int xyz=0;
      int test3=0;
      while(xyz<qwerty.length()-1){
      if(translator.integerCheck(qwerty.charAt(xyz)) && translator.integerCheck(qwerty.charAt(xyz+1))) test3++;
         xyz++;
      }
      if(test3==0) return true;
      else return false;
   }
   public static boolean brackChecks(String fgh){
      int p=0;
      int test=0;
      int destroy=0;
      while(p<fgh.length()){
         if(fgh.charAt(p)=='(') test++;
         if (fgh.charAt(p)==')'){
            test--;
            if (test<0) destroy++;
         }
         p++;
      }
      if(test==0 && destroy==0) return true;
      else return false;
   }
   public static boolean impChecks(String s){
      int xy=0;
      int xz=0;
      int testy=0;
      int testz=0;
      while(xy<s.length()-2){
         if(translator.integerCheck(s.charAt(xy)) && s.charAt(xy+1) == '(') testy++;
         xy++;
      }
      while(xz<s.length()-1){
         if(s.charAt(xz) == ')' && translator.integerCheck(s.charAt(xz+1))) testz++;
         xz++;
      }
      if(testy == 0 && testz == 0) return true;
      else return false;
   }
}