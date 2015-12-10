import java.io.*;

public class Rational{

int num;
int den;

public Rational(int n, int d){
   num = n;
   den = d;
}

public int getNum(){
   return num;
}

public int getDen(){
   return den;
}

public void setNum(int a){
   num = a;
}

public void setDen(int b){
   den = b;
}

public String toString(){
   return num + "/" + den;
}

public int GCF(){
   int div = den;
   if(den > num){
   div = num;
   }
   for(; div > 0; div--){
      if(num%div == 0 && den%div == 0){
      return div;
      }
   }
   return 0;
}

public int LCM(){
   return num*den/GCF();
}

public String simplify(){
   return num/GCF() + "/" + den/GCF();
}

public String add(Rational a, Rational b){
   Rational c = new Rational(a.getDen(), b.getDen());
   int lcm = c.LCM();
   c.setNum(a.getNum()*lcm/a.getDen() + b.getNum()*lcm/b.getDen());
   c.setDen(lcm);
   return c.simplify();
}

public String subtract(Rational a, Rational b){
   Rational c = new Rational(a.getDen(), b.getDen());
   int lcm = c.LCM();
   c.setNum(a.getNum()*lcm/a.getDen() - b.getNum()*lcm/b.getDen());
   c.setDen(lcm);
   if(c.getNum() == 0){
   return "0";
   }
   if(c.getNum() < 0){
   c.setNum(-c.getNum());
   }
   return c.simplify();
}

public void equals(Rational a, Rational b){
   if(a.getNum()*b.getDen() == b.getNum()*a.getDen()){
   System.out.println("The fractions are equal.");
   }
   else{
   System.out.println("The fractions are NOT equal.");
   }
}

}